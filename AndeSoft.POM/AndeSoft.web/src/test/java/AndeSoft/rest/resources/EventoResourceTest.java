/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.resources;

import AndeSoft.converters.EventoConverter;
import AndeSoft.rest.dtos.EventoDTO;
import Andesoft.adapters.DateAdapter;
import Andesoft.providers.CreatedFilter;
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
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author mm.gomez10
 */
public class EventoResourceTest {
    
    private final int OK = Response.Status.OK.getStatusCode();
    private final int CREATED = Response.Status.CREATED.getStatusCode();
    private final int NO_CONTENT = Response.Status.NO_CONTENT.getStatusCode();

    private final String eventoPath = "eventos";

    private final static List<EventoDTO> oraculo = new ArrayList<>();

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
                .addPackage(DateAdapter.class.getPackage())
                .addPackage(CreatedFilter.class.getPackage())
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
            EventoDTO evento = factory.manufacturePojo(EventoDTO.class);
            evento.setFechaInicio(getMaxDate());
            evento.setId(i + 1L);
            
            oraculo.add(evento);
        }
    }

    @Test
    @InSequence(1)
    public void createEventoTest() {
        EventoDTO evento = oraculo.get(0);
        Response response = target.path(eventoPath).request()
                .post(Entity.entity(evento, MediaType.APPLICATION_JSON));

        EventoDTO eventoTest = (EventoDTO) response.readEntity(EventoDTO.class);

        Assert.assertEquals(CREATED, response.getStatus());

        Assert.assertEquals(evento.getNombre(), eventoTest.getNombre());
        Assert.assertEquals(evento.getFechaInicio(), eventoTest.getFechaInicio());
        Assert.assertEquals(evento.getFechaFinal(), eventoTest.getFechaFinal());
        Assert.assertEquals(evento.getCiudad(), eventoTest.getCiudad());
    }

    @Test
    @InSequence(2)
    public void getEventoById() {
        EventoDTO eventoTest = target.path(eventoPath)
                .path(oraculo.get(0).getId().toString())
                .request().get(EventoDTO.class);
        Assert.assertEquals(eventoTest.getId(), oraculo.get(0).getId());
        Assert.assertEquals(eventoTest.getNombre(), oraculo.get(0).getNombre());
        Assert.assertEquals(eventoTest.getFechaInicio(), oraculo.get(0).getFechaInicio());
        Assert.assertEquals(eventoTest.getFechaFinal(), oraculo.get(0).getFechaFinal());
        Assert.assertEquals(eventoTest.getCiudad(), oraculo.get(0).getCiudad());
    }

    @Test
    @InSequence(3)
    public void listEventoTest() {
        Response response = target.path(eventoPath)
                .request().get();

        List<EventoDTO> listEventoTest = response.readEntity(new GenericType<List<EventoDTO>>() {
        });
        Assert.assertEquals(OK, response.getStatus());
        Assert.assertEquals(1, listEventoTest.size());
    }

    @Test
    @InSequence(4)
    public void updateEventoTest() {
        EventoDTO evento = oraculo.get(0);
        EventoDTO eventoChanged = factory.manufacturePojo(EventoDTO.class);
        eventoChanged.setFechaInicio(getMaxDate());
        evento.setNombre(eventoChanged.getNombre());
        evento.setFechaInicio(eventoChanged.getFechaInicio());
        evento.setFechaFinal(eventoChanged.getFechaFinal());
        evento.setCiudad(eventoChanged.getCiudad());
        Response response = target.path(eventoPath).path(evento.getId().toString())
                .request().put(Entity.entity(evento, MediaType.APPLICATION_JSON));
        EventoDTO eventoTest = (EventoDTO) response.readEntity(EventoDTO.class);
        Assert.assertEquals(OK, response.getStatus());
        Assert.assertEquals(evento.getNombre(), eventoTest.getNombre());
        Assert.assertEquals(evento.getFechaInicio(), eventoTest.getFechaInicio());
        Assert.assertEquals(evento.getFechaFinal(), eventoTest.getFechaFinal());
        Assert.assertEquals(evento.getCiudad(), eventoTest.getCiudad());
    }

    @Test
    @InSequence(9)
    public void deleteEventoTest() {
        EventoDTO evento = oraculo.get(0);
        Response response = target.path(eventoPath).path(evento.getId().toString())
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
