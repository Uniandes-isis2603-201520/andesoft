package andesoft.logic;


import andesoft.api.IUsarioLogic;
import andesoft.ejbs.UsuarioLogic;
import andesoft.entities.UsuarioEntity;
import andesoft.exceptions.BusinessLogicException;
import andesoft.persistence.UsuarioPersistenceTest;
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
 * @author js.arciniegas10
 */
@RunWith(Arquillian.class)
public class UsuarioLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private IUsarioLogic usuarioLogic;

    @PersistenceContext(unitName = "AndeSoftPU")
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<UsuarioEntity> data = new ArrayList<UsuarioEntity>();

//    private List<ItinerarioEntity> itinerarioData = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                
                .addClass(UsuarioLogic.class)
                .addClass(IUsarioLogic.class)
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioPersistenceTest.class.getPackage())
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
        em.createQuery("delete from UsuarioEntity").executeUpdate();
        
    }

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            UsuarioEntity usuario = factory.manufacturePojo(UsuarioEntity.class);
            em.persist(usuario);
            data.add(usuario);
        }
    }

    @Test
    public void createUsuarioTest() {
        
        // expected es generado -- id en null
        UsuarioEntity expected = factory.manufacturePojo(UsuarioEntity.class);
        
        // created es el que graba -- id es el de la BD
        UsuarioEntity created = usuarioLogic.createUsuario(expected);

        // result es el que se lee de la base de datos
        UsuarioEntity result = em.find(UsuarioEntity.class, created.getId());

        // lo leyó de la BD ?
        Assert.assertNotNull(result);
        
        // coincide el id ?
        Assert.assertEquals(created.getId(), result.getId());

        // coincide los datos
        Assert.assertEquals(expected.getNames(), result.getNames());
        
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
        Assert.assertEquals(expected.getNames(), result.getNames());

    }

    @Test
    public void deleteUsuarioTest() {
        UsuarioEntity entity = data.get(1);
        usuarioLogic.deleteUsuario(entity.getId());
        UsuarioEntity deleted = em.find(UsuarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        UsuarioEntity pojoEntity = factory.manufacturePojo(UsuarioEntity.class);
        pojoEntity.setId(entity.getId());
        usuarioLogic.updateUsuario(pojoEntity);
        UsuarioEntity resp = em.find(UsuarioEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNames(), resp.getNames());
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