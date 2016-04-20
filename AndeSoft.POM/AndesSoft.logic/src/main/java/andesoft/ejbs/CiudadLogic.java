/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.ejbs;


import andesoft.api.ICiudad;
import andesoft.entities.CiudadEntity;
import andesoft.exceptions.BusinessLogicException;
import andesoft.persistence.CiudadPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author e.galvis10
 */
@Stateless
public class CiudadLogic  implements ICiudad
{

    @Inject
    private CiudadPersistence persistence;
    @Override
    public List<CiudadEntity> getCiudades() {
        return persistence.findAll();
    }

    @Override
    public CiudadEntity getCiudad(String nombre) throws BusinessLogicException {
       return persistence.find(nombre);
    }

    @Override
    public CiudadEntity createCiudad(CiudadEntity entity) {
        persistence.create(entity);
        return entity;
    }

    @Override
    public CiudadEntity updateCiudad(CiudadEntity entity) {
        CiudadEntity newEntity = entity;
        return persistence.update(newEntity);
    }

    @Override
    public void deleteCiudad(String nombre) {
      persistence.delete(nombre);
    }

}
