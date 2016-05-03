/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.persistence;

import andesoft.entities.EventoEntity;
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
 * @author mm.gomez10
 */
@RunWith(Arquillian.class)
public class EventoPersistenceTest {
    
    @Inject 
    private EventoPersistence eventoPersistence;
    @PersistenceContext
    private EntityManager em;
    private final PodamFactory factory = new PodamFactoryImpl();
    @Inject
    UserTransaction utx;    
    
    public EventoPersistenceTest() {
    }
    
    @Deployment 
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EventoEntity.class.getPackage())
                .addPackage(EventoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
    
    private void clearData(){
        em.createQuery("delete from EventoEntity").executeUpdate();
    }
    
    private List <EventoEntity> data = new ArrayList<>();
    
    private void insertData (){
        for (int i = 0; i < 3; i++){
            EventoEntity entity = factory.manufacturePojo(EventoEntity.class);
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

    @Test
    public void createEventoTest() {
        EventoEntity newEntity = factory.manufacturePojo(EventoEntity.class);
        
        EventoEntity result = eventoPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        EventoEntity entity = em.find(EventoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getNombre(),entity.getNombre());
        Assert.assertEquals(newEntity.getFechaFinal(),entity.getFechaFinal());
        Assert.assertEquals(newEntity.getFechaInicio(),entity.getFechaInicio());
        Assert.assertEquals(newEntity.getCiudad(),entity.getCiudad());
    }
    
    @Test
    public void updateEventoTest() {
        EventoEntity entity1 = data.get(0);
        entity1.setNombre("nuevoNombre");
        EventoEntity result = eventoPersistence.update(entity1);
        Assert.assertEquals("nuevoNombre", result.getNombre());
    }
    
    @Test
    public void deleteEventoTest(){
        EventoEntity entity2 = data.get(1);
        eventoPersistence.delete(entity2.getId());
        EventoEntity result = em.find(EventoEntity.class, entity2.getId());
        Assert.assertNull(result);
    }
    
    @Test
    public void findTest(){
        EventoEntity ent = data.get(2);
        EventoEntity result = eventoPersistence.find(ent.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(ent.getNombre(), result.getNombre());
        Assert.assertEquals(ent.getFechaFinal(), result.getFechaFinal());
        Assert.assertEquals(ent.getFechaInicio(), result.getFechaInicio());
    }
    
    @Test
    public void findAllTest(){
        List<EventoEntity> list = eventoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (EventoEntity ent : list){
            boolean found = false;
            for (EventoEntity entity : data)
            {
                if(ent.getId().equals(entity.getId())){
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
            
    }
    
}
