/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package andesoft.ejbs;


import andesoft.api.IPuntoInteresLogic;
import andesoft.entities.PuntoInteresEntity;
import andesoft.exceptions.BusinessLogicException;
import andesoft.persistence.PuntoInteresPersistence;
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
public class PuntoIntereslLogicTest
{
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private IPuntoInteresLogic puntoInteresLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<PuntoInteresEntity> data = new ArrayList<PuntoInteresEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PuntoInteresEntity.class.getPackage())
                .addClass(PuntoInteresLogic.class)
                .addClass(IPuntoInteresLogic.class)
                .addPackage(PuntoInteresPersistence.class.getPackage())
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
        em.createQuery("delete from PuntoInteresEntity").executeUpdate();
        
    }
    
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PuntoInteresEntity puntoInteres = factory.manufacturePojo(PuntoInteresEntity.class);
            em.persist(puntoInteres);
            data.add(puntoInteres);
        }
    }

    @Test
    public void createPuntoInteresTest() {
        PuntoInteresEntity entity = factory.manufacturePojo(PuntoInteresEntity.class);
        PuntoInteresEntity created = puntoInteresLogic.createPuntoInteres(entity);
        PuntoInteresEntity result = em.find(PuntoInteresEntity.class, created.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getNombre(), result.getNombre());
    }
    
    @Test
    public void getPuntosInteresTest() {
        List<PuntoInteresEntity> resultList = puntoInteresLogic.getPuntosInteres();
        List<PuntoInteresEntity> expectedList = em.createQuery("SELECT u from PuntoInteresEntity u").getResultList();
        Assert.assertEquals(expectedList.size(), resultList.size());
        for (PuntoInteresEntity expected : expectedList) {
            boolean found = false;
            for (PuntoInteresEntity result : resultList) {
                if (result.getId().equals(expected.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getPuntoInteresTest() throws BusinessLogicException {
        PuntoInteresEntity result = puntoInteresLogic.getPuntoInteres((data.get(0).getId()));
        PuntoInteresEntity expected = em.find(PuntoInteresEntity.class, data.get(0).getId());
        
        Assert.assertNotNull(expected);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getNombre(), result.getNombre());
    }
    
    @Test
    public void deletePuntoInteresTest() {
        PuntoInteresEntity entity = data.get(1);
        puntoInteresLogic.deletePuntoInteres(entity.getId());
        PuntoInteresEntity deleted = em.find(PuntoInteresEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updatePuntoInteresTest() {
        PuntoInteresEntity entity = data.get(0);
        PuntoInteresEntity pojoEntity = factory.manufacturePojo(PuntoInteresEntity.class);
        pojoEntity.setId(entity.getId());
        puntoInteresLogic.updatePuntoInteres(pojoEntity);
        PuntoInteresEntity resp = em.find(PuntoInteresEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
    }    
}
