/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.api;


import andesoft.entities.CiudadEntity;
import andesoft.exceptions.BusinessLogicException;
import java.util.List;

/**
 *
 * @author e.galvis10
 */
public interface ICiudad {

public List<CiudadEntity> getCiudades();

    public CiudadEntity getCiudad(String nombre) throws BusinessLogicException;

    public CiudadEntity createCiudad(CiudadEntity entity);

    public CiudadEntity updateCiudad(CiudadEntity entity);

    public void deleteCiudad(String nombre);
}
