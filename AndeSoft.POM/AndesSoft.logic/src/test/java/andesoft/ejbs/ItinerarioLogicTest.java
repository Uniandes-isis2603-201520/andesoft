/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.ejbs;

import andesoft.api.IItinerarioLogic;
import andesoft.entities.ItinerarioEntity;
import andesoft.entities.UsuarioEntity;
import andesoft.persistence.ItinerarioPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jg.tamura10
 */
@RunWith(Arquillian.class)
public class ItinerarioLogicTest 
{
    
    @Inject 
    private IItinerarioLogic itinerarioLogic;
    @PersistenceContext
    private EntityManager em;
    private final PodamFactory factory = new PodamFactoryImpl();
    @Inject
    UserTransaction utx;
    
    @Deployment 
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                
                .addClass(ItinerarioLogic.class)
                .addClass(IItinerarioLogic.class)

                .addPackage(ItinerarioEntity.class.getPackage())
                .addPackage(ItinerarioPersistence.class.getPackage())
                
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
    
        private void clearData() 
    {
        em.createQuery("delete from ItinerarioEntity").executeUpdate();
        em.createQuery("delete from UsuarioEntity").executeUpdate();
    }

    private List<ItinerarioEntity> data = new ArrayList<>();

    private void insertData() 
    {
        for (int i = 0; i < 3; i++)
        {
            ItinerarioEntity entity = factory.manufacturePojo(ItinerarioEntity.class);
            UsuarioEntity nuevaC = new UsuarioEntity(0);
            nuevaC.setId((long)0);
            em.persist(nuevaC);
            System.out.println("itinerario creado con dueño "+ nuevaC.getId() );
            entity.setUsuario(nuevaC);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    
    @Before
    public void configTest(){
        try{
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            try{
                utx.rollback();
            } catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
    }
    public ItinerarioLogicTest() 
    {
    }

    @Test
    public void getItinerariosTest() 
    {
        List<ItinerarioEntity> list = itinerarioLogic.getItinerarios(Long.parseLong("0"));
        //Assert.assertEquals(data.size(), list.size());
        for (ItinerarioEntity ent : list) 
        {
            ItinerarioEntity actual = null;
            for (ItinerarioEntity entityy : data) {
                if (ent.getId().equals(entityy.getId())) {
                    actual = entityy;
                }
            }
            Assert.assertEquals(actual.getUsuario(),0);
        }
    }
    
    @Test
    public void createItinerarioTest() 
    {
        ItinerarioEntity newEntity = factory.manufacturePojo(ItinerarioEntity.class);
        ItinerarioEntity result = itinerarioLogic.crearItinerario(newEntity);
        newEntity.setUsuario(null);
        Assert.assertNotNull(result);

        ItinerarioEntity entity = em.find(ItinerarioEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }
    
    @Test
    public void updateItinerarioTest() 
    {
        ItinerarioEntity entity = data.get(0);
        ItinerarioEntity newEntity = factory.manufacturePojo(ItinerarioEntity.class);

        newEntity.setId(entity.getId());

        itinerarioLogic.updateItinerario(newEntity);

        ItinerarioEntity resp = em.find(ItinerarioEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }
    
    @Test
    public void deleteItinerarioTest() 
    {
        ItinerarioEntity entity = data.get(0);
        itinerarioLogic.deleteItinerario(entity.getUsuario().getId() ,entity.getId());
        ItinerarioEntity deleted = em.find(ItinerarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void getItinerarioTest()
    {
        ItinerarioEntity entity = data.get(0);
        ItinerarioEntity newEntity = itinerarioLogic.getItinerario(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getFechaIni(), newEntity.getFechaIni());
        Assert.assertEquals(entity.getFechaFin(), newEntity.getFechaFin());
    }
    
}
