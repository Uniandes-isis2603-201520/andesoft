/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.entities;

import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author e.galvis10
 */
@Entity
public class CiudadEntity extends BaseEntity implements Serializable
{
    //private Long ID;
    private String name;
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaInicio; 
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaFinal;
    
    @ManyToOne
    @PodamExclude
    private ItinerarioEntity itinerario;
    
     @OneToMany(mappedBy = "ciudadPunto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PuntoInteresEntity> puntosInteres = new ArrayList<>();
    


    public String getName ()
    {
        return name;
    }

    public void setName(String nme)
    {
        name = nme;
    }

    public Date getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(Date fI)
    {
        fechaInicio = fI;
    }

    public Date getFechaFinal()
    {
        return fechaFinal;
    }

    public void setFechaFinal(Date fF)
    {
        fechaFinal = fF;
    }
    
    public ItinerarioEntity getBook() {
        return itinerario;
    }

    public void setItinerario(ItinerarioEntity itinerario) {
        this.itinerario = itinerario;
    }
    
     public List<PuntoInteresEntity> getPuntosInteres() {
        return puntosInteres;
    }

    public void setPuntosInteres(List<PuntoInteresEntity> puntosInteres) {
        this.puntosInteres = puntosInteres;
    }

}
