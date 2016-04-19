package andesoft.entities;

import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author Jose
 */
@Entity
public class ItinerarioEntity implements Serializable
{
    @OneToMany(mappedBy = "")
    private ArrayList ciudades;
     
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private int idUsuarioDueño;
     private String nombreIt;
     
     private String fechaIni;
     private String fechaFin;
     
     
     public ItinerarioEntity(int idD, int idp, String nombreItp, String ini, String fin, ArrayList ciudadesp)
     {
         idUsuarioDueño = idD;
         id = idp;
         nombreIt = nombreItp;
         fechaIni = ini;
         fechaFin = fin;
         ciudades = ciudadesp;
         
         
     }
        public int darId()
        {
            return id;
        }
        public int darIdUsuarioDueño()
        {
            return idUsuarioDueño;
        }
       public String darNombre()
       {
           return nombreIt;
       }
        public ArrayList darCiudades( )
        {
            return ciudades;
        }
       
        public String darFechaIni( )
        {
            return fechaIni;
        }
        public String darFechaFin( )
        {
            return fechaFin;
        }
        
        
        
        public void setCiudades( ArrayList nuevaC)
        {
            ciudades = nuevaC;
        }
       
        public void setFechaIni( String nuevaC)
        {
            fechaIni = nuevaC;
        }
        public void setFechaFin( String nuevaC)
        {
            fechaFin = nuevaC;
        }
        public void setNom( String nuevaC)
        {
            nombreIt = nuevaC;
        }
}
