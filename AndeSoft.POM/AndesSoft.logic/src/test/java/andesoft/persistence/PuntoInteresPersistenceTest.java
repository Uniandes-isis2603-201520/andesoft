/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.persistence;

import andesoft.entities.PuntoInteresEntity;
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
public class PuntoInteresPersistenceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PuntoInteresEntity.class.getPackage())
                .addPackage(PuntoInteresPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private PuntoInteresPersistence puntoInteresPersistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private final PodamFactory factory = new PodamFactoryImpl();

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
        em.createQuery("delete from PuntoInteresEntity").executeUpdate();
    }

    private List<PuntoInteresEntity> data = new ArrayList<>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PuntoInteresEntity entity = factory.manufacturePojo(PuntoInteresEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createPuntoInteresTest() {
        PuntoInteresEntity newEntity = factory.manufacturePojo(PuntoInteresEntity.class);
        PuntoInteresEntity result = puntoInteresPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PuntoInteresEntity entity = em.find(PuntoInteresEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }

    @Test
    public void getPuntosInteresTest() {
        List<PuntoInteresEntity> list = puntoInteresPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PuntoInteresEntity ent : list) {
            boolean found = false;
            for (PuntoInteresEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getPuntoInteresTest() {
        PuntoInteresEntity entity = data.get(0);
        PuntoInteresEntity newEntity = puntoInteresPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getFechaLlegada(), newEntity.getFechaLlegada());
        Assert.assertEquals(entity.getFechaSalida(), newEntity.getFechaSalida());
    }

    @Test
    public void deletePuntoInteresTest() {
        PuntoInteresEntity entity = data.get(0);
        puntoInteresPersistence.delete(entity.getId());
        PuntoInteresEntity deleted = em.find(PuntoInteresEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updatePuntoInteresTest() {
        PuntoInteresEntity entity = data.get(0);
        PuntoInteresEntity newEntity = factory.manufacturePojo(PuntoInteresEntity.class);

        newEntity.setId(entity.getId());

        puntoInteresPersistence.update(newEntity);

        PuntoInteresEntity resp = em.find(PuntoInteresEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }
}
