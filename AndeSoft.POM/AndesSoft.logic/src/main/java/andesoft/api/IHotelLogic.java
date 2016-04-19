/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.api;

import andesoft.entities.HotelEntity;
import java.util.List;
import andesoft.exceptions.BusinessLogicException;

public interface IHotelLogic
{
	public List<HotelEntity> getHoteles();

	public HotelEntity getHotel(Long id) throws BusinessLogicException;

	public HotelEntity createHotel(HotelEntity entity);

	public HotelEntity updateHotel(HotelEntity entity);

	public void deleteHotel(Long id);
}
