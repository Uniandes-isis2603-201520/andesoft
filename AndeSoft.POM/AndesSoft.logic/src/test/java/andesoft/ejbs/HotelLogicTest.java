/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package andesoft.ejbs;

import andesoft.api.IHotelLogic;
import andesoft.entities.HotelEntity;
import andesoft.exceptions.BusinessLogicException;
import andesoft.persistence.HotelPersistence;
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

/**
 *
 * @author AndresFelipe
 */
@RunWith(Arquillian.class)
public class HotelLogicTest
{
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private IHotelLogic hotelLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<HotelEntity> data = new ArrayList<HotelEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HotelEntity.class.getPackage())
                .addClass(HotelLogic.class)
                .addClass(IHotelLogic.class)
                .addPackage(HotelPersistence.class.getPackage())
                .addPackage(BusinessLogicException.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Before
    public void configTest() {
        try {
            utx.begin();
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
    
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            HotelEntity hotel = factory.manufacturePojo(HotelEntity.class);
            em.persist(hotel);
            data.add(hotel);
        }
    }

    @Test
    public void createHotelTest() {
        HotelEntity entity = factory.manufacturePojo(HotelEntity.class);
        HotelEntity created = hotelLogic.createHotel(entity);
        HotelEntity result = em.find(HotelEntity.class, created.getid());
        Assert.assertNotNull(result);
        Assert.assertEquals(entity.getid(), result.getid());
        Assert.assertEquals(entity.getName(), result.getName());
    }
    
    @Test
    public void getHotelesTest() {
        List<HotelEntity> resultList = hotelLogic.getHoteles();
        List<HotelEntity> expectedList = em.createQuery("SELECT u from HotelEntity u").getResultList();
        Assert.assertEquals(expectedList.size(), resultList.size());
        for (HotelEntity expected : expectedList) {
            boolean found = false;
            for (HotelEntity result : resultList) {
                if (result.getid().equals(expected.getid())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getHotelTest() throws BusinessLogicException {
        HotelEntity result = hotelLogic.getHotel((data.get(0).getid()));
        HotelEntity expected = em.find(HotelEntity.class, data.get(0).getid());
        
        Assert.assertNotNull(expected);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getid(), result.getid());
        Assert.assertEquals(expected.getName(), result.getName());
    }
    
    @Test
    public void deleteHotelTest() {
        HotelEntity entity = data.get(1);
        hotelLogic.deleteHotel(entity.getid());
        HotelEntity deleted = em.find(HotelEntity.class, entity.getid());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateHotelTest() {
        HotelEntity entity = data.get(0);
        HotelEntity pojoEntity = factory.manufacturePojo(HotelEntity.class);
        pojoEntity.setId(entity.getid());
        hotelLogic.updateHotel(pojoEntity);
        HotelEntity resp = em.find(HotelEntity.class, entity.getid());
        Assert.assertEquals(pojoEntity.getid(), resp.getid());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
    }    
}
