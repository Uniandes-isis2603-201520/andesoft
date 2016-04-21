/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.persistence;

import andesoft.entities.CiudadEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import static org.glassfish.pfl.basic.tools.argparser.ElementParser.factory;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author e.galvis10
 */
@RunWith(Arquillian.class)
public class CiudadPersistenceTest {



     @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CiudadEntity.class.getPackage())
                .addPackage(CiudadPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private CiudadPersistence ciudadPersistence;
      @Inject
UserTransaction utx;

       private final PodamFactory factory = new PodamFactoryImpl();

      @PersistenceContext
    private EntityManager em;

      private List<CiudadEntity> data = new ArrayList<>();

    public CiudadPersistenceTest() {
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
        em.createQuery("delete from CiudadEntity").executeUpdate();
    }

  private void insertData() {
        for (int i = 0; i < 3; i++) {
            CiudadEntity entity = factory.manufacturePojo(CiudadEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

  @Test
public void createCiudadTest() {
    CiudadEntity newEntity = factory.manufacturePojo(CiudadEntity.class);
    CiudadEntity result = ciudadPersistence.create(newEntity);

    Assert.assertNotNull(result);

    CiudadEntity entity = em.find(CiudadEntity.class, result.getId());

    Assert.assertEquals(newEntity.getName(), entity.getName());

    Assert.assertEquals( newEntity.getFechaInicio(), entity.getFechaInicio());
    Assert.assertEquals(newEntity.getFechaFinal(), entity.getFechaFinal());
    //Arreglar lo del iditinerario y mirar bien que sucede
    Assert.assertEquals(newEntity.getItinerarioId(), entity.getItinerarioId());
}

  @Test
    public void getCiudadesTest() {
        List<CiudadEntity> list = ciudadPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CiudadEntity ent : list) {
            boolean found = false;
            for (CiudadEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

     @Test
    public void getCiudadTest() {
        CiudadEntity entity = data.get(0);
        CiudadEntity newEntity = ciudadPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getFechaFinal(), newEntity.getFechaFinal());
        Assert.assertEquals(entity.getFechaInicio(), newEntity.getFechaInicio());
    }

    @Test
    public void deleteCiudadTest() {
        CiudadEntity entity = data.get(0);
        ciudadPersistence.delete(entity.getId());
        CiudadEntity deleted = em.find(CiudadEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /*
    @BeforeClass
    public static void setUpClass() {
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
*/
}
