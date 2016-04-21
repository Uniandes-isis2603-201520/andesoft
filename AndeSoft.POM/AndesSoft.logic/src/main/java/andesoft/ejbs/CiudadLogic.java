/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.ejbs;


import andesoft.api.ICiudad;
import andesoft.entities.CiudadEntity;
import andesoft.entities.PuntoInteresEntity;
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
    public CiudadEntity getCiudad(String nombre) {
       return persistence.find(nombre);
    }
    
    @Override
    public CiudadEntity getCiudad(Long id) {
       return persistence.find(id);
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
    public void deleteCiudad(Long id) {
      persistence.delete(id);
    }

    @Override
    public List<PuntoInteresEntity> getPuntosInteres(Long ciudadId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PuntoInteresEntity getPuntoInteres(Long ciudadId, Long puntoInteresId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     @Override
    public PuntoInteresEntity createPuntoInteres(Long ciudadId, PuntoInteresEntity puntoInteresEntity) throws BusinessLogicException {
        CiudadEntity ciudadEntity = getCiudad(ciudadId);
        //PuntoInteresEntity puntoInteresEntity = puntoInteresPersistence.find(authorId);
        PuntoInteresLogic puntoLogic= new PuntoInteresLogic();
        PuntoInteresEntity puntoEntity =puntoLogic.createPuntoInteres(puntoInteresEntity);
        ciudadEntity.getPuntosInteres().add(puntoEntity);
        return puntoEntity;
    }

    @Override
    public void removePuntoInteres(Long ciudadId, Long puntoInteresId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PuntoInteresEntity> replaceAuthors(List<PuntoInteresEntity> puntosInteres, Long ciudadId) throws BusinessLogicException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
