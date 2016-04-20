/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.ejbs;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

import andesoft.api.IHotelLogic;
import andesoft.persistence.HotelPersistence;
import andesoft.entities.HotelEntity;


@Stateless
public class HotelLogic implements IHotelLogic
{

	@Inject
	private HotelPersistence persistence;



	@Override
	public List<HotelEntity> getHoteles()
	{
		return persistence.findAll();
	}

	@Override
	public HotelEntity getHotel(Long id)
	{
		return persistence.find(id);
	}

	@Override
	public HotelEntity createHotel(HotelEntity entity)
	{
		persistence.create(entity);
		return entity;
	}

	@Override
	public HotelEntity updateHotel (HotelEntity entity)
	{
		HotelEntity newEntity = entity;
		HotelEntity oldEntity = persistence.find(entity.getid());

            //Se deben actualizar las fechas?

		return persistence.update(newEntity);
	}

	@Override
	public void deleteHotel(Long id)
	{
		persistence.delete(id);
	}

}