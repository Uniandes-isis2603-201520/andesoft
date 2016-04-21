/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.ejbs;

import andesoft.entities.EventoEntity;
import andesoft.persistence.EventoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author mm.gomez10
 */
public class EventoLogicTest {
    
    @Inject 
    private EventoLogic eventoLogic;
    @PersistenceContext
    private EntityManager em;
    private final PodamFactory factory = new PodamFactoryImpl();
    @Inject
    UserTransaction utx;
    
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
    public EventoLogicTest() {
    }

    @Test
    public void getEventoTest() {
        EventoEntity ent = data.get(2);
        EventoEntity result = eventoLogic.getEvento(ent.getId());
        Assert.assertEquals(ent, result);
    }
    
    @Test
    public void createEventoTest(){
        EventoEntity newEntity = factory.manufacturePojo(EventoEntity.class);
        
        EventoEntity result = eventoLogic.createEvento(newEntity);
        
        Assert.assertNotNull(result);
        EventoEntity entity = em.find(EventoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getNombre(),entity.getNombre());
        Assert.assertEquals(newEntity.getFechaFinal(),entity.getFechaFinal());
        Assert.assertEquals(newEntity.getFechaInicio(),entity.getFechaInicio());
        Assert.assertEquals(newEntity.getCiudad(),entity.getCiudad());
    }
    
    @Test
    public void updateEventoTest(){
        EventoEntity entity1 = data.get(0);
        entity1.setNombre("nuevoNombre");
        EventoEntity result = eventoLogic.updateEvento(entity1);
        Assert.assertEquals("nuevoNombre", result.getNombre());
    }
    
    @Test
    public void deleteEvento(){
         EventoEntity entity2 = data.get(1);
        eventoLogic.deleteEvento(entity2.getId());
        EventoEntity result = em.find(EventoEntity.class, entity2.getId());
        Assert.assertNull(result);
    }
    
    @Test
    public void getEventosTest(){
        List<EventoEntity> list = eventoLogic.getEventos();
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
