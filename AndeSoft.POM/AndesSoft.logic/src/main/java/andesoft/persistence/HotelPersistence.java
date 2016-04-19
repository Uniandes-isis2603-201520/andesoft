/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import andesoft.entities.HotelEntity;


@Stateless
public class HotelPersistence
{

	private static final Logger logger = Logger.getLogger(HotelPersistence.class.getName());

	// Revisar que se debe poner en UnitName --> @PersistenceContext(unitName = " ");

	protected EntityManager em;


	public HotelEntity create(HotelEntity entity)
	{
		logger.info("Creando un hotel nuevo");
		em.persist(entity);
		logger.info("Hotel creado");
		return entity;
	}

	public HotelEntity update(HotelEntity entity)
	{
		logger.log(Level.INFO, "Actualizando hotel con id={0}", entity.getId());
		return em.merge(entity);
	}

	public void delete(Long id)
	{
		logger.log(Level.INFO, "Borrando autor con id={0}", id);
		HotelEntity entity = em.find(HotelEntity.class, id);
		em.remove(entity);
	}

	public HotelEntity find(Long id)
	{
		logger.log(Level.INFO, "Consultando hotel con id={0}", id);
		return em.find(HotelEntity.class, id);
	}

	public List<HotelEntity> findAll()
	{
		logger.info("Consultando todos los hoteles");
		Query q = em.createQuery("SELECT U FROM HoteEntity U");
		return q.getResultList();
	}
}
