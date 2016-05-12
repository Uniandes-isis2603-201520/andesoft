/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.ejbs;

import andesoft.api.IEventoLogic;
import andesoft.entities.EventoEntity;
import andesoft.exceptions.BusinessLogicException;
import andesoft.persistence.EventoPersistence;
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
 * @author mm.gomez10
 */
@RunWith(Arquillian.class)
public class EventoLogicTest
{
      private PodamFactory factory = new PodamFactoryImpl();

      @Inject
        private IEventoLogic eventoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<EventoEntity> data = new ArrayList<>();

   // private List<"otraentity"> otraData = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)

                .addClass(EventoLogic.class)
                .addClass(IEventoLogic.class)

                .addPackage(EventoEntity.class.getPackage())
                .addPackage(EventoPersistence.class.getPackage())
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
        em.createQuery("delete from EventoEntity").executeUpdate();
        //em.createQuery("delete from otherEntity").executeUpdate();
    }

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            EventoEntity eventos = factory.manufacturePojo(EventoEntity.class);
            em.persist(eventos);
            data.add(eventos);
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
    public void createEventoTest() {
        EventoEntity entity = factory.manufacturePojo(EventoEntity.class);
        EventoEntity created = eventoLogic.createEvento(entity);
        EventoEntity result = em.find(EventoEntity.class, created.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getNombre(), result.getNombre());
    }

    @Test
    public void getEventosTest() {
        List<EventoEntity> resultList = eventoLogic.getEventos();
        List<EventoEntity> expectedList = em.createQuery("SELECT u from EventoEntity u").getResultList();
        Assert.assertEquals(expectedList.size(), resultList.size());
        for (EventoEntity expected : expectedList) {
            boolean found = false;
            for (EventoEntity result : resultList) {
                if (result.getId().equals(expected.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getEventoTest() {
        EventoEntity result = eventoLogic.getEvento((data.get(0).getId()));
        EventoEntity expected = em.find(EventoEntity.class, data.get(0).getId());

        Assert.assertNotNull(expected);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getNombre(), result.getNombre());
    }

     @Test
    public void deleteEventoTest() {
        EventoEntity entity = data.get(1);
        eventoLogic.deleteEvento(entity.getId());
        EventoEntity deleted = em.find(EventoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateEventoTest() {
        EventoEntity entity = data.get(0);
        EventoEntity pojoEntity = factory.manufacturePojo(EventoEntity.class);
        pojoEntity.setId(entity.getId());
        eventoLogic.updateEvento(pojoEntity);
        EventoEntity resp = em.find(EventoEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
    }


}
