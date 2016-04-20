/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jg.tamura10
 * 
 */
@XmlRootElement
public class ItinerarioDTO
{
    
     private List<CiudadDTOf> ciudades;
     
     private Long id;
     private Long idUsuarioDueño;
     private String nombreIt;
     
     private Date fechaIni;
     private Date fechaFin;
     
     public ItinerarioDTO()
     {
         
     }
     
     public ItinerarioDTO(Long idD, int idp, String nombreItp, Date ini, Date fin, ArrayList ciudadesp)
     {
         idUsuarioDueño = idD;
         id = idD;
         nombreIt = nombreItp;
         fechaIni = ini;
         fechaFin = fin;
         ciudades = ciudadesp;
         
         
     }
        public Long darId()
        {
            return id;
        }
        public Long darIdUsuarioDueño()
        {
            return idUsuarioDueño;
        }
       public String darNombre()
       {
           return nombreIt;
       }
        public List<CiudadDTOf> darCiudades( )
        {
            return ciudades;
        }
       
        public Date darFechaIni( )
        {
            return fechaIni;
        }
        public Date darFechaFin( )
        {
            return fechaFin;
        }
        
        
        
        public void setCiudades( List<CiudadDTOf> nuevaC)
        {
            ciudades = nuevaC;
        }
       
        public void setFechaIni( Date nuevaC)
        {
            fechaIni = nuevaC;
        }
        public void setFechaFin( Date nuevaC)
        {
            fechaFin = nuevaC;
        }
        public void setId(Long idN)
        {
            id = idN;
        }
        public void setIdDueño(Long idN)
        {
            idUsuarioDueño = idN;
        }
        public void setNom( String nuevaC)
        {
            nombreIt = nuevaC;
        }
        /**
        public String toString()
        {
           String eventosString = "[";
           for(int i=0;i< eventos.size();i++)
           {
               EventoDTO actual = (EventoDTO) eventos.get(i);
               eventosString +=  "{\"evento\":\""+actual.getNombre()+"\"}"+ (i+1 == eventos.size()? "" : ",");
               
           }
           eventosString += "]";
           
           String puntosString = "[";
           for(int i=0;i< puntosI.size();i++)
           {
               PuntoInteresDTO actual = (PuntoInteresDTO) puntosI.get(i);
               puntosString +=  "{\"punto\":\""+actual.getNombre()+"\"}"+ (i+1 == puntosI.size()? "" : ",");
           }
           puntosString += "]";
           
           String hotelesString = "[";
           for(int i=0;i< hoteles.size();i++)
           {
               HotelDTO actual = (HotelDTO) hoteles.get(i);
               hotelesString +=  "{\"hotel\":\""+actual.getNombre()+"\"}"+ (i+1 == hoteles.size()? "" : ",");
           }
           hotelesString += "]";
           
           String ciudadesString = "[";
           for(int i=0;i< ciudades.size();i++)
           {
               CiudadDTOf actual = (CiudadDTOf) ciudades.get(i);
               ciudadesString +=  "{\"ciudad\":\""+actual.getNombre()+"\"}"+ (i+1 == ciudades.size()? "" : ",");
           }
           ciudadesString += "]";
           
           
           
            String resp= "{\"idUsuario\":"+idUsuarioDueño+",\"id\":"+id+",\"nombreIt\":\""+nombreIt+"\",\"fechaIni\":\""+fechaIni+"\",\"fechaFin\":\""+fechaFin
                    +"\",\"eventos\":"+eventosString+",\"ciudades\":"+ciudadesString+"}";//,\"hoteles\":"+hotelesString+",\"puntos\":"+puntosString+"}";
            
            System.out.println(resp);
            return resp;
        }*/
        
      

}
