/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.ejbs;

import andesoft.entities.EventoEntity;
import andesoft.entities.ItinerarioEntity;
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
 * @author jg.tamura10
 */
public class ItinerarioLogicTest 
{
    
    @Inject 
    private ItinerarioLogic itinerarioLogic;
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
    
    private List <ItinerarioEntity> data = new ArrayList<>();
    
    private void insertData (){
        for (int i = 0; i < 3; i++){
            ItinerarioEntity entity = factory.manufacturePojo(ItinerarioEntity.class);
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
        for (ItinerarioEntity ent : list) {
            ItinerarioEntity actual = null;
            for (ItinerarioEntity entityy : data) {
                if (ent.darId().equals(entityy.darId())) {
                    actual = entityy;
                }
            }
            Assert.assertEquals(actual.darIdUsuarioDueño(),0);
        }
    }
    
    @Test
    public void createItinerarioTest() 
    {
        ItinerarioEntity newEntity = factory.manufacturePojo(ItinerarioEntity.class);
        ItinerarioEntity result = itinerarioLogic.createItinerario(newEntity);

        Assert.assertNotNull(result);

        ItinerarioEntity entity = em.find(ItinerarioEntity.class, result.darId());

        Assert.assertEquals(newEntity.darNombre(), entity.darNombre());
    }
    
    @Test
    public void updateItinerarioTest() 
    {
        ItinerarioEntity entity = data.get(0);
        ItinerarioEntity newEntity = factory.manufacturePojo(ItinerarioEntity.class);

        newEntity.setId(entity.darId());

        itinerarioLogic.updateItinerario(newEntity);

        ItinerarioEntity resp = em.find(ItinerarioEntity.class, entity.darId());

        Assert.assertEquals(newEntity.darNombre(), resp.darNombre());
    }
    
    @Test
    public void deleteItinerarioTest() 
    {
        ItinerarioEntity entity = data.get(0);
        itinerarioLogic.deleteItinerario(entity.darId());
        ItinerarioEntity deleted = em.find(ItinerarioEntity.class, entity.darId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void getItinerarioTest()
    {
        ItinerarioEntity entity = data.get(0);
        ItinerarioEntity newEntity = itinerarioLogic.getItinerario((long)0,entity.darId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.darNombre(), newEntity.darNombre());
        Assert.assertEquals(entity.darFechaIni(), newEntity.darFechaIni());
        Assert.assertEquals(entity.darFechaFin(), newEntity.darFechaFin());
    }
    
}
