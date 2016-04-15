package andesoft.persistence;


import andesoft.entities.PuntoInteresEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PuntoInteresPersistence {

    private static final Logger logger = Logger.getLogger(PuntoInteresPersistence.class.getName());

    @PersistenceContext(unitName = "AndeSoftPU")
    protected EntityManager em;

    public PuntoInteresEntity create(PuntoInteresEntity entity) {
        logger.info("Creando un punto de interes nuevo");
        em.persist(entity);
        logger.info("Punto de Interes creado");
        return entity;
    }

    public PuntoInteresEntity update(PuntoInteresEntity entity) {
        logger.log(Level.INFO, "Actualizando punto de interes con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        logger.log(Level.INFO, "Borrando punto de interes con id={0}", id);
        PuntoInteresEntity entity = em.find(PuntoInteresEntity.class, id);
        em.remove(entity);
    }

    public PuntoInteresEntity find(Long id) {
        logger.log(Level.INFO, "Consultando punto de interes con id={0}", id);
        return em.find(PuntoInteresEntity.class, id);
    }

    public List<PuntoInteresEntity> findAll() {
        logger.info("Consultando todos los puntos de interes");
        Query q = em.createQuery("select u from PuntoInteresEntity u");
        return q.getResultList();
    }
}
