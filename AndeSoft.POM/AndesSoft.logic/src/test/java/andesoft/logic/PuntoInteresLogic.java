package andesoft.ejbs;


import andesoft.api.IPuntoInteresLogic;
import andesoft.entities.PuntoInteresEntity;
import andesoft.persistence.PuntoInteresPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PuntoInteresLogic implements IPuntoInteresLogic {

    private static final Logger logger = Logger.getLogger(PuntoInteresLogic.class.getName());

   // @Inject
    //private AuthorPersistence persistence;
    
    @Inject
    private PuntoInteresPersistence persistence;
    
    
    public PuntoInteresEntity getPuntoInteres(Long id) {
        logger.log(Level.INFO, "Inicia proceso de consultar punto de interes con id={0}", id);
        PuntoInteresEntity puntoInteres = persistence.find(id);
        if (puntoInteres == null) {
            logger.log(Level.SEVERE, "El punto de interes con el id {0} no existe", id);
            throw new IllegalArgumentException("El punto de interes solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar punto de interes con id={0}", id);
        return puntoInteres;
    }

    public PuntoInteresEntity createPuntoInteres(PuntoInteresEntity entity) {
        logger.info("Inicia proceso de creación de punto de interes");
        persistence.create(entity);
        logger.info("Termina proceso de creación de punto de interes");
        return entity;
    }

    
    public PuntoInteresEntity updatePuntoInteres(PuntoInteresEntity entity) {
        logger.log(Level.INFO, "Inicia proceso de actualizar punto de interes con id={0}", entity.getId());
        PuntoInteresEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar el punto de interes con id={0}", entity.getId());
        return newEntity;
    }

    
    public void deletePuntoInteres(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar punto de interes con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar punto de interes con id={0}", id);
    }

      
    public List<PuntoInteresEntity> getPuntosInteres() {
        logger.info("Inicia proceso de consultar todos los puntos de interes");
        List<PuntoInteresEntity> puntosInteres = persistence.findAll();
        logger.info("Termina proceso de consultar todos los puntos de interes");
        return puntosInteres;
    }
   

}
