package andesoft.persistence;


import andesoft.entities.ItinerarioEntity;
import andesoft.entities.PuntoInteresEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ItinerarioPersistence {

    private static final Logger logger = Logger.getLogger(PuntoInteresPersistence.class.getName());

    @PersistenceContext(unitName = "AndeSoftPU")
    protected EntityManager em;

    public ItinerarioEntity create(ItinerarioEntity entity) {
        logger.info("Creando un itinerario nuevo");
        em.persist(entity);
        logger.info("Itineario creado");
        return entity;
    }

    public ItinerarioEntity update(ItinerarioEntity entity) {
        logger.log(Level.INFO, "Actualizando itinerario ", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        logger.log(Level.INFO, "Borrandoitinerario ", id);
        ItinerarioEntity entity = em.find(ItinerarioEntity.class, id);
        em.remove(entity);
    }

    public ItinerarioEntity find(Long id) 
    {
        logger.log(Level.INFO, "Consultando Itinerario ", id);
        return em.find(ItinerarioEntity.class, id);
    }

    public List<ItinerarioEntity> findAll(Long idUsuario)
    {
        logger.info("Consultando todos los Itinerarios");
        Query q = em.createQuery("select u from ItinerarioEntity u ");
        return q.getResultList();
    }
}
