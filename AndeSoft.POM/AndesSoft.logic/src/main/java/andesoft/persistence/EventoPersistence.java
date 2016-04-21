package andesoft.persistence;


import andesoft.entities.EventoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EventoPersistence {

    private static final Logger logger = Logger.getLogger(PuntoInteresPersistence.class.getName());

    @PersistenceContext(unitName = "AndeSoftPU")
    protected EntityManager em;

    public EventoEntity create(EventoEntity entity) {
        logger.info("Creando un evento nuevo");
        em.persist(entity);
        logger.info("Evento creado");
        return entity;
    }

    public EventoEntity update(EventoEntity entity) {
        logger.log(Level.INFO, "Actualizando evento con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        logger.log(Level.INFO, "Borrando evento con id={0}", id);
        EventoEntity entity = em.find(EventoEntity.class, id);
        em.remove(entity);
    }

    public EventoEntity find(Long id) {
        logger.log(Level.INFO, "Consultando evento con id={0}", id);
        return em.find(EventoEntity.class, id);
    }

    public List<EventoEntity> findAll() {
        logger.info("Consultando todos los eventos");
        Query q = em.createQuery("select u from EventoEntity u");
        return q.getResultList();
    }
}

