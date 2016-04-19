/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.entities;

import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author e.galvis10
 */
@Entity
public class CiudadEntity extends BaseEntity implements Serializable
{
      private Long ID;
    private String name;
    private String fechaInicio;
    private String fechaFinal;

    public Long getID()
    {
        return ID;
    }

    public void setID(Long id)
    {
        ID = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName(String nme)
    {
        name = nme;
    }

    public String getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(String fI)
    {
        fechaInicio = fI;
    }

    public String getFechaFinal()
    {
        return fechaFinal;
    }

    public void setFechaFinal(String fF)
    {
        fechaFinal = fF;
    }

}
