/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.ejbs;

import andesoft.api.IHotelLogic;
import andesoft.entities.HotelEntity;
import andesoft.exceptions.BusinessLogicException;
import andesoft.persistence.CiudadPersistence;
import andesoft.persistence.HotelPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author AndresFelipe
 */
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

   // private List<"otraentity"> otraData = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HotelEntity.class.getPackage())
                .addPackage(HotelLogic.class.getPackage())
                .addPackage(IHotelLogic.class.getPackage())
                .addPackage(HotelPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
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

    @After
    public void tearDown() throws Exception {
    }

    private void clearData() {
        em.createQuery("delete from CiudadEntity").executeUpdate();
        //em.createQuery("delete from otherEntity").executeUpdate();
    }

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            HotelEntity ciudades = factory.manufacturePojo(HotelEntity.class);
            em.persist(ciudades);
            data.add(ciudades);
        }

        /*
        for (int i = 0; i < 3; i++) {
            OtherEntity entity = factory.manufacturePojo(OtherEntity.class);

            em.persist(entity);
            data.add(entity);

            otherData.add(entity)
        }
        */
    }

    /**
     *
     */
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
        List<HotelEntity> expectedList = em.createQuery("SELECT u from CiudadEntity u").getResultList();
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

    /**
     * Test of getHoteles method, of class HotelLogic.
     */
    @Test
    public void testGetHoteles() throws Exception {
        System.out.println("getHoteles");
        HotelLogic instance = new HotelLogic();
        List<HotelEntity> expResult = null;
        List<HotelEntity> result = instance.getHoteles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHotel method, of class HotelLogic.
     */
    @Test
    public void testGetHotel() throws Exception {
        System.out.println("getHotel");
        Long id = null;
        HotelLogic instance = new HotelLogic();
        HotelEntity expResult = null;
        HotelEntity result = instance.getHotel(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createHotel method, of class HotelLogic.
     */
    @Test
    public void testCreateHotel() throws Exception {
        System.out.println("createHotel");
        HotelEntity entity = null;
        HotelLogic instance = new HotelLogic();
        HotelEntity expResult = null;
        HotelEntity result = instance.createHotel(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateHotel method, of class HotelLogic.
     */
    @Test
    public void testUpdateHotel() throws Exception {
        System.out.println("updateHotel");
        HotelEntity entity = null;
        HotelLogic instance = new HotelLogic();
        HotelEntity expResult = null;
        HotelEntity result = instance.updateHotel(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteHotel method, of class HotelLogic.
     */
    @Test
    public void testDeleteHotel() throws Exception {
        System.out.println("deleteHotel");
        Long id = null;
        HotelLogic instance = new HotelLogic();
        instance.deleteHotel(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


}
