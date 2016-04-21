package andesoft.logic;


import andesoft.api.IUsarioLogic;

import andesoft.ejbs.UsuarioLogic;

import andesoft.entities.UsuarioEntity;

import andesoft.persistence.UsuarioPersistenceTest;
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
import org.junit.Before;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author js.arciniegas10
 */
public class UsuarioLogicTest {
 private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private IUsarioLogic usuarioLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<UsuarioEntity> data = new ArrayList<UsuarioEntity>();

//    private List<ItinerarioEntity> itinerarioData = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioLogic.class.getPackage())
                .addPackage(IUsarioLogic.class.getPackage())
                .addPackage(UsuarioPersistenceTest.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
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
        em.createQuery("delete from ItineararioEntity").executeUpdate();
        em.createQuery("delete from UsuarioEntity").executeUpdate();
    }

//    private void insertData() {
//        for (int i = 0; i < 3; i++) {
//            ItinerarioEntity itinerarios = factory.manufacturePojo(ItinerarioEntity.class);
//            itinerarios.setPublishDate(getMaxDate());
//            em.persist(itinerarios);
//            ItinerarioData.add(itinerarios);
//        }
//
//        for (int i = 0; i < 3; i++) {
//            UsuarioEntity entity = factory.manufacturePojo(UsuarioEntity.class);
//
//            em.persist(entity);
//            data.add(entity);
//
//            ItinerariosData.get(0).getAuthors().add(entity);
//        }
//    }

    @Test
    public void createUsuarioTest() {
        UsuarioEntity expected = factory.manufacturePojo(UsuarioEntity.class);
        UsuarioEntity created = usuarioLogic.createUsuario(expected);

        UsuarioEntity result = em.find(UsuarioEntity.class, created.getId());

        Assert.assertNotNull(result);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());

    }

    @Test
    public void getUsuariosTest() {
        List<UsuarioEntity> resultList = usuarioLogic.getUsuarios();
        List<UsuarioEntity> expectedList = em.createQuery("SELECT u from UsuarioEntity u").getResultList();
        Assert.assertEquals(expectedList.size(), resultList.size());
        for (UsuarioEntity expected : expectedList) {
            boolean found = false;
            for (UsuarioEntity result : resultList) {
                if (result.getId().equals(expected.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getUsuarioTest() {
        UsuarioEntity result = usuarioLogic.getUsuario(data.get(0).getId());

        UsuarioEntity expected = em.find(UsuarioEntity.class, data.get(0).getId());

        Assert.assertNotNull(expected);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());

    }

    @Test
    public void deleteUsuarioTest() {
        UsuarioEntity entity = data.get(1);
        usuarioLogic.deleteUsuario(entity.getId());
        UsuarioEntity expected = em.find(UsuarioEntity.class, entity.getId());
        Assert.assertNull(expected);
    }

    @Test
    public void updateUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        UsuarioEntity expected = factory.manufacturePojo(UsuarioEntity.class);

        expected.setId(entity.getId());

        usuarioLogic.updateUsuario(expected);

        UsuarioEntity resp = em.find(UsuarioEntity.class, entity.getId());

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getId(), resp.getId());
    }

//    @Test
//    public void getItinerarioTest() {
//        UsuarioEntity entity = data.get(0);
//        ItinerarioEntity itinerarioEntity = ItinerariosData.get(0);
//        ItinerarioEntity response = usuarioLogic.getBook(entity.getId(), bookEntity.getId());
//
//        BookEntity expected = getAuthorBook(entity.getId(), bookEntity.getId());
//
//        Assert.assertNotNull(expected);
//        Assert.assertNotNull(response);
//        Assert.assertEquals(expected.getId(), response.getId());
//        Assert.assertEquals(expected.getName(), response.getName());
//        Assert.assertEquals(expected.getDescription(), response.getDescription());
//        Assert.assertEquals(expected.getIsbn(), response.getIsbn());
//        Assert.assertEquals(expected.getImage(), response.getImage());
//    }
//
//    @Test
//    public void listItinerariosTest() {
//        List<BookEntity> list = usuarioLogic.getBooks(data.get(0).getId());
//        AuthorEntity expected = em.find(AuthorEntity.class, data.get(0).getId());
//
//        Assert.assertNotNull(expected);
//        Assert.assertEquals(expected.getBooks().size(), list.size());
//    }
//
//    @Test
//    public void addBooksTest() {
//        try {
//            AuthorEntity entity = data.get(0);
//            BookEntity bookEntity = booksData.get(1);
//            BookEntity response = authorLogic.addBook(bookEntity.getId(), entity.getId());
//
//            BookEntity expected = getAuthorBook(entity.getId(), bookEntity.getId());
//
//            Assert.assertNotNull(expected);
//            Assert.assertNotNull(response);
//            Assert.assertEquals(expected.getId(), response.getId());
//        } catch (BusinessLogicException ex) {
//            Assert.fail(ex.getLocalizedMessage());
//        }
//    }
//
//
//    @Test(expected = NoResultException.class)
//    public void removeBooksTest() {
//        authorLogic.removeBook(booksData.get(0).getId(), data.get(0).getId());
//        getAuthorBook(data.get(0).getId(), booksData.get(0).getId());
//    }




}