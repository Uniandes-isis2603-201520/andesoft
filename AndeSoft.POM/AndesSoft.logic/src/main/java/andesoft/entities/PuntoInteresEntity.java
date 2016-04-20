/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.entities;

import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author Johan
 */
@Entity
public class PuntoInteresEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaLLegada;
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaSalida;
    
    @ManyToOne
    @PodamExclude
    private CiudadEntity ciudadPunto;
  
     public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    
     public Date getFechaLlegada() {
        return fechaLLegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLLegada = fechaLlegada;
    }
  
    public Long getId() {
        return id;
    }

    public void setId(Long idN) {
        id=idN;
    }

    public String getNombre() {
       return nombre;
    }

    public void setNombre(String name) {
       this.nombre=name;
    }
    
     public CiudadEntity getCiudad() {
        return ciudadPunto;
    }

    public void setCiudad(CiudadEntity book) {
        this.ciudadPunto = ciudadPunto;
    }

  
}
