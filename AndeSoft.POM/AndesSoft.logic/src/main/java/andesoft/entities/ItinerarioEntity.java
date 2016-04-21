package andesoft.entities;

import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    
    @OneToMany(mappedBy ="itinerario", cascade = CascadeType.ALL, orphanRemoval = true)
   // private ArrayList ciudades;
    private List<CiudadEntity> ciudades = new ArrayList<>();
     
          
     @ManyToOne
     private UsuarioEntity idUsuarioDueño;
     
     
     private String nombreIt;
     
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
     private Date fechaIni;
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
     private Date fechaFin;
     
     /**
     public ItinerarioEntity(UsuarioEntity idD, int idp, String nombreItp, String ini, String fin, ArrayList ciudadesp)
     {
         idUsuarioDueño = idD;
         id = idp;
         nombreIt = nombreItp;
         fechaIni = ini;
         fechaFin = fin;
         ciudades = ciudadesp;
         
         
     }*/
        public Long darId()
        {
            return id;
        }
        public void setId(Long pid)
        {
            id=pid;
        }
        public UsuarioEntity darIdUsuarioDueño()
        {
            return idUsuarioDueño;
        }
       public String darNombre()
       {
           return nombreIt;
       }
        
       
        public Date darFechaIni( )
        {
            return fechaIni;
        }
        public Date darFechaFin( )
        {
            return fechaFin;
        }
        
        
       
       
        public void setFechaIni( Date nuevaC)
        {
            fechaIni = nuevaC;
        }
        public void setFechaFin( Date nuevaC)
        {
            fechaFin = nuevaC;
        }
        public void setNom( String nuevaC)
        {
            nombreIt = nuevaC;
        }
        
        
        public List<CiudadEntity> getCiudades() {
           return ciudades;
       }

       public void setCiudades(List<CiudadEntity> ciudades) {
           this.ciudades = ciudades;
       }
}
