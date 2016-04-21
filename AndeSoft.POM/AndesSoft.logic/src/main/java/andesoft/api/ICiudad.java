/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.api;


import andesoft.entities.CiudadEntity;
import andesoft.entities.PuntoInteresEntity;
import andesoft.exceptions.BusinessLogicException;
import java.util.List;

/**
 *
 * @author e.galvis10
 */
public interface ICiudad {

public List<CiudadEntity> getCiudades();

    public CiudadEntity getCiudad(String nombre);
    
    public CiudadEntity getCiudad(Long id);


    public CiudadEntity createCiudad(CiudadEntity entity);

    public CiudadEntity updateCiudad(CiudadEntity entity);

    public void deleteCiudad(Long id);
    
    public List<PuntoInteresEntity> getPuntosInteres(Long ciudadId);

    public PuntoInteresEntity getPuntoInteres(Long ciudadId, Long puntoInteresId);

    public PuntoInteresEntity createPuntoInteres(Long ciudadId, PuntoInteresEntity puntoEntity) throws BusinessLogicException;

    public void removePuntoInteres(Long ciudadId, Long puntoInteresId);

    public List<PuntoInteresEntity> replaceAuthors(List<PuntoInteresEntity> puntosInteres, Long ciudadId) throws BusinessLogicException;

}
