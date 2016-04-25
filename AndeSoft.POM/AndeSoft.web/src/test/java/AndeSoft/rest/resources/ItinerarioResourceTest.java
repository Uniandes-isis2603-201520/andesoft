/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.resources;

import AndeSoft.converters.EventoConverter;
import AndeSoft.rest.dtos.EventoDTO;
import AndeSoft.rest.dtos.ItinerarioDTO;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jg.tamrua10
 */
@RunWith(Arquillian.class)
public class ItinerarioResourceTest {
    
    private final int OK = Response.Status.OK.getStatusCode();
    private final int CREATED = Response.Status.CREATED.getStatusCode();
    private final int NO_CONTENT = Response.Status.NO_CONTENT.getStatusCode();

    private final String itinerarioPath = "Itinerarios";

    private final static List<ItinerarioDTO> oraculo = new ArrayList<>();

    private javax.ws.rs.client.WebTarget target;
    private final String apiPath = "api";
    private static PodamFactory factory = new PodamFactoryImpl();

    @ArquillianResource
    private URL deploymentURL;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                // Se agrega la dependencia a la logica con el nombre groupid:artefactid:version (GAV)
                .addAsLibraries(Maven.resolver()
                        .resolve("AndeSoft.rest.resources:AndesSoft.logic:1.0-SNAPSHOT")
                        .withTransitivity().asFile())
                // Se agregan los compilados de los paquetes de servicios
                .addPackage(EventoResource.class.getPackage())
                .addPackage(EventoDTO.class.getPackage())
                .addPackage(EventoConverter.class.getPackage())
                // El archivo que contiene la configuracion a la base de datos.
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                // El archivo beans.xml es necesario para injeccion de dependencias.
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                // El archivo web.xml es necesario para el despliegue de los servlets
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));
    }

    @Before
    public void setUpTest() {
        target = ClientBuilder.newClient().target(deploymentURL.toString()).path(apiPath);
    }

    @BeforeClass
    public static void setUp() {
        insertData();
    }

    public static void insertData() {
        for (int i = 0; i < 5; i++) {
            ItinerarioDTO itinerario = factory.manufacturePojo(ItinerarioDTO.class);
            itinerario.setFechaIni(getMaxDate());
            itinerario.setId(i + 1L);
            
            oraculo.add(itinerario);
        }
    }

    @Test
    @InSequence(1)
    public void createItinerarioTest() {
       ItinerarioDTO itinerario = oraculo.get(0);
        Response response = target.path(itinerarioPath).request()
                .post(Entity.entity(itinerario, MediaType.APPLICATION_JSON));

        ItinerarioDTO oTest = (ItinerarioDTO) response.readEntity(ItinerarioDTO.class);

        Assert.assertEquals(CREATED, response.getStatus());

        Assert.assertEquals(itinerario.getNombreIt(), oTest.getNombreIt());
        Assert.assertEquals(itinerario.getFechaIni(), oTest.getFechaIni());
        Assert.assertEquals(itinerario.getFechaFin(), oTest.getFechaFin());
    }

    @Test
    @InSequence(2)
    public void getItinerarioById() {
        ItinerarioDTO oTest = target.path(itinerarioPath)
                .path(oraculo.get(0).getId().toString())
                .request().get(ItinerarioDTO.class);
        Assert.assertEquals(oTest.getId(), oraculo.get(0).getId());
        Assert.assertEquals(oTest.getNombreIt(), oraculo.get(0).getNombreIt());
        Assert.assertEquals(oTest.getFechaIni(), oraculo.get(0).getFechaIni());
        Assert.assertEquals(oTest.getFechaFin(), oraculo.get(0).getFechaFin());
    }

    @Test
    @InSequence(3)
    public void listEventoTest() {
        Response response = target.path(itinerarioPath)
                .request().get();

        List<ItinerarioDTO> listItinerarioTest = response.readEntity(new GenericType<List<ItinerarioDTO>>() {
        });
        Assert.assertEquals(OK, response.getStatus());
        Assert.assertEquals(1, listItinerarioTest.size());
    }

    @Test
    @InSequence(4)
    public void updateItinerarioTest() {
        ItinerarioDTO ito = oraculo.get(0);
        ItinerarioDTO itoChanged = factory.manufacturePojo(ItinerarioDTO.class);
        itoChanged.setFechaIni(getMaxDate());
        ito.setNombreIt(itoChanged.getNombreIt());
        ito.setFechaIni(itoChanged.getFechaIni());
        ito.setFechaFin(itoChanged.getFechaFin());
        Response response = target.path(itinerarioPath).path(ito.getId().toString())
                .request().put(Entity.entity(ito, MediaType.APPLICATION_JSON));
        ItinerarioDTO itoTest = (ItinerarioDTO) response.readEntity(ItinerarioDTO.class);
        Assert.assertEquals(OK, response.getStatus());
        Assert.assertEquals(ito.getNombreIt(), itoTest.getNombreIt());
        Assert.assertEquals(ito.getFechaIni(), itoTest.getFechaIni());
        Assert.assertEquals(ito.getFechaFin(), itoTest.getFechaFin());
    }

    @Test
    @InSequence(9)
    public void deleteItinerarioTest() {
        ItinerarioDTO ito = oraculo.get(0);
        Response response = target.path(itinerarioPath).path(ito.getId().toString())
                .request().delete();
        Assert.assertEquals(NO_CONTENT, response.getStatus());
    }

    

    private static Date getMaxDate() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 9999);
        c.set(Calendar.DAY_OF_YEAR, c.getActualMaximum(Calendar.DAY_OF_YEAR));
        c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
        c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
        c.set(Calendar.MILLISECOND, c.getActualMinimum(Calendar.MILLISECOND));
        return c.getTime();
    }
    
}
