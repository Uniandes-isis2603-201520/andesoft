package andesoft.api;


import andesoft.entities.PuntoInteresEntity;
import java.util.List;


public interface IPuntoInteresLogic {

    public List<PuntoInteresEntity> getPuntosInteres();
    
    public PuntoInteresEntity getPuntoInteres(Long id) ;

    public PuntoInteresEntity createPuntoInteres(PuntoInteresEntity entity);

    public PuntoInteresEntity updatePuntoInteres(PuntoInteresEntity entity);

    public void deletePuntoInteres(Long id);

    
}
