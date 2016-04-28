/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package andesoft.entities;


import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

//import andesoft.entities.ItinerarioEntity;
//import andesoft.entities.CiudadEntity;

@Entity
public class HotelEntity extends BaseEntity implements Serializable
{
    //private Long id;
    private String nombre;
    
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaLlegada;
    
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaSalida;
    
    @PodamExclude
    @ManyToOne
    private CiudadEntity ciudad;
    
//	public Long getId()
//	{
//		return id;
//	}
//
//	public void setId(Long id)
//	{
//		this.id = id;
//	}
    
    public String getName()
    {
        return nombre;
    }
    
    public void setName(String nombre)
    {
        this.nombre = nombre;
    }
    
    public Date getFechaLlegada()
    {
        return fechaLlegada;
    }
    
    public void setFechaLlegada(Date fechaLlegada)
    {
        this.fechaLlegada = fechaLlegada;
    }
    
    public Date getFechaSalida()
    {
        return fechaSalida;
    }
    
    public void setFechaSalida(Date fechaSalida)
    {
        this.fechaSalida = fechaSalida;
    }
    
    public CiudadEntity getCiudad()
    {
    return ciudad;
    }
    
    public void setCiudades(CiudadEntity ciudad)
    {
    this.ciudad = ciudad;
    }
}
