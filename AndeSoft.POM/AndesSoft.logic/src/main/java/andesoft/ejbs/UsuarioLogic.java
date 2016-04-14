/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.ejbs;

import java.util.logging.Logger;
import javax.inject.Inject;
import andesoft.api.IUsarioLogic;
import andesoft.entities.UsuarioEntity;
import andesoft.exceptions.BusinessLogicException;
import andesoft.persistence.UsuarioPersistence;
import java.util.List;
import java.util.logging.Level;
/**
 *
 * @author js.arciniegas10
 */
public class UsuarioLogic implements IUsarioLogic {
 private static final Logger logger = Logger.getLogger(UsuarioLogic.class.getName());

    @Inject
    private UsuarioPersistence persistence;

    @Inject
    IUsarioLogic UsuarioLogic;

    @Override
    public List<UsuarioEntity> getUsuarios() {
        logger.info("Inicia proceso de consultar todos los usuarios");
        List<UsuarioEntity> usuarios = persistence.findAll();
        logger.info("Termina proceso de consultar todos los usuarios");
        return usuarios;
    }

    @Override
    public UsuarioEntity getUsuario(Long id) {
        logger.log(Level.INFO, "Inicia proceso de consultar usuario r con id={0}", id);
        UsuarioEntity usuario = persistence.find(id);
        if (usuario == null) {
            logger.log(Level.SEVERE, "El usuario con el id {0} no existe", id);
            throw new IllegalArgumentException("El usuario solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar usuario con id={0}", id);
        return usuario;
    }

    @Override
    public UsuarioEntity createUsuario(UsuarioEntity entity) {
        logger.info("Inicia proceso de creación de usuario");
        persistence.create(entity);
        logger.info("Termina proceso de creación de autor");
        return entity;
    }

    @Override
    public UsuarioEntity updateUsuario(UsuarioEntity entity) {
        logger.log(Level.INFO, "Inicia proceso de actualizar usuario con id={0}", entity.getId());
        UsuarioEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar usuario con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deleteUsuario(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar autor con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar autor con id={0}", id);
    }

//    @Override
//    public ItinerarioEntity addItinerario(Long bookId, Long authorId) throws BusinessLogicException {
//        ItinerarioLogic.addAuthor(authorId, bookId);
//        return ItinerarioLogic.getBook(bookId);
//    }
//
//    @Override
//    public void removeItinerario(Long bookId, Long authorId) {
//        ItinerarioLogic.removeUsuarior(authorId, bookId);
//    }
//
//
//    @Override
//    public List<ItinerarioEntity> getItinerarios(Long authorId) {
//        return getUsuarios(authorId).getBooks();
//    }
//
//    @Override
//    public ItinerarioEntity getItinerario(Long authorId, Long bookId) {
//        List<ItinerarioEntity> itinerario = getUsuarios(authorId).getBooks();
//        ItinerarioEntity book = ItinerarioLogic.getBook(bookId);
//        int index = books.indexOf(book);
//        if (index >= 0) {
//            return books.get(index);
//        }
//        throw new IllegalArgumentException("El libro no está asociado al autor");
//    }
}
