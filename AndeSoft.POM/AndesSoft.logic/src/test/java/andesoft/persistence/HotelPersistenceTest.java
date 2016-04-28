/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package andesoft.persistence;

import andesoft.entities.HotelEntity;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(Arquillian.class)
public class HotelPersistenceTest {
    
    @Inject
    private HotelPersistence hotelPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private final PodamFactory factory = new PodamFactoryImpl();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HotelEntity.class.getPackage())
                .addPackage(HotelPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    private void clearData() {
        em.createQuery("delete from HotelEntity").executeUpdate();
    }
    
    private List<HotelEntity> data = new ArrayList<>();
    
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            HotelEntity entity = factory.manufacturePojo(HotelEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createHotelTest() {
        HotelEntity newEntity = factory.manufacturePojo(HotelEntity.class);
        HotelEntity result = hotelPersistence.create(newEntity);
        HotelEntity entity = em.find(HotelEntity.class, result.getid());
        
        Assert.assertNotNull(result);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    @Test
    public void getHotelesTest() {
        List<HotelEntity> list = hotelPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (HotelEntity ent : list) {
            boolean found = false;
            for (HotelEntity entity : data) {
                if (ent.getid().equals(entity.getid())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getHotelsTest() {
        HotelEntity entity = data.get(0);
        HotelEntity newEntity = hotelPersistence.find(entity.getid());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getFechaLlegada(), newEntity.getFechaLlegada());
        Assert.assertEquals(entity.getFechaSalida(), newEntity.getFechaSalida());
    }
    
    @Test
    public void deleteHotelTest() {
        HotelEntity entity = data.get(0);
        hotelPersistence.delete(entity.getid());
        HotelEntity deleted = em.find(HotelEntity.class, entity.getid());
        
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateHotelTest() {
        HotelEntity entity = data.get(0);
        HotelEntity newEntity = factory.manufacturePojo(HotelEntity.class);
        newEntity.setId(entity.getid());
        hotelPersistence.update(newEntity);
        HotelEntity resp = em.find(HotelEntity.class, entity.getid());
        
        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
}
