package andesoft.ejbs;

import andesoft.api.IBookLogic;
import andesoft.api.IEditorialLogic;
import andesoft.entities.BookEntity;
import andesoft.entities.EditorialEntity;
import andesoft.persistence.EditorialPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EditorialLogic implements IEditorialLogic {

    private static final Logger logger = Logger.getLogger(EditorialLogic.class.getName());

    @Inject
    private EditorialPersistence persistence;

    @Inject
    private IBookLogic bookLogic;

    @Override
    public List<EditorialEntity> getEditorials() {
        logger.info("Inicia proceso de consultar todas las editoriales");
        List<EditorialEntity> editorials = persistence.findAll();
        logger.info("Termina proceso de consultar todas las editoriales");
        return editorials;
    }

    @Override
    public EditorialEntity getEditorial(Long id)  {
        logger.log(Level.INFO, "Inicia proceso de consultar editorial con id={0}", id);
        EditorialEntity editorial = persistence.find(id);
        if (editorial == null) {
            logger.log(Level.SEVERE, "La editorial con el id {0} no existe", id);
            throw new IllegalArgumentException("La editorial solicitada no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar editorial con id={0}", id);
        return editorial;
    }

    @Override
    public EditorialEntity createEditorial(EditorialEntity entity) {
        logger.info("Inicia proceso de creación de editorial");
        persistence.create(entity);
        logger.info("Termina proceso de creación de editorial");
        return entity;
    }

    @Override
    public EditorialEntity updateEditorial(EditorialEntity entity) {
        logger.log(Level.INFO, "Inicia proceso de actualizar editorial con id={0}", entity.getId());
        EditorialEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar editorial con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deleteEditorial(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar editorial con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar editorial con id={0}", id);
    }

    @Override
    public BookEntity addBook(Long bookId, Long editorialId) {
        EditorialEntity editorialEntity = getEditorial(editorialId);
        BookEntity bookEntity = bookLogic.getBook(bookId);
        bookEntity.setEditorial(editorialEntity);
        return bookEntity;
    }

    @Override
    public void removeBook(Long bookId, Long editorialId) {
        EditorialEntity editorialEntity = getEditorial(editorialId);
        BookEntity book = bookLogic.getBook(bookId);
        book.setEditorial(null);
        editorialEntity.getBooks().remove(book);
    }

    @Override
    public List<BookEntity> replaceBooks(List<BookEntity> books, Long editorialId) {
        EditorialEntity editorial = getEditorial(editorialId);
        List<BookEntity> bookList = bookLogic.getBooks();
        for (BookEntity book : bookList) {
            if (books.contains(book)) {
                book.setEditorial(editorial);
            } else if (book.getEditorial() != null && book.getEditorial().equals(editorial)) {
                book.setEditorial(null);
            }
        }
        return books;
    }

    @Override
    public List<BookEntity> getBooks(Long editorialId) {
        return getEditorial(editorialId).getBooks();
    }

    @Override
    public BookEntity getBook(Long editorialId, Long bookId) {
        List<BookEntity> books = getEditorial(editorialId).getBooks();
        BookEntity book = bookLogic.getBook(bookId);
        int index = books.indexOf(book);
        if (index >= 0) {
            return books.get(index);
        }
        throw new IllegalArgumentException("El libro no está asociado a la editorial");
    }
}
