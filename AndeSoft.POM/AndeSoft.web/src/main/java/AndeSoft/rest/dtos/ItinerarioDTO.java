/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jg.tamura10
 * 
 */
@XmlRootElement
public class ItinerarioDTO
{
    
     private ArrayList ciudades;
     private ArrayList eventos;
     private ArrayList puntosI;
     private ArrayList hoteles;
     
     private int id;
     private int idUsuarioDueño;
     private String nombreIt;
     
     private String fechaIni;
     private String fechaFin;
     
     
     public ItinerarioDTO(int idD, int idp, String nombreItp, String ini, String fin, ArrayList ciudadesp, ArrayList eventosp, ArrayList puntosp, ArrayList hotelesp)
     {
         idUsuarioDueño = idD;
         id = idp;
         nombreIt = nombreItp;
         fechaIni = ini;
         fechaFin = fin;
         ciudades = ciudadesp;
         eventos = eventosp;
         puntosI = puntosp;
         hoteles = hotelesp;
         
         
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
        public ArrayList darEventos( )
        {
            return eventos;
        }
        public ArrayList darPuntos( )
        {
            return puntosI;
        }
        public ArrayList darHoteles( )
        {
            return hoteles;
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
        public void setEventos( ArrayList nuevaC)
        {
            eventos = nuevaC;
        }
        public void setPuntos( ArrayList nuevaC)
        {
            puntosI = nuevaC;
        }
        public void setHoteles( ArrayList nuevaC)
        {
            hoteles = nuevaC;
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
        }
        
      

}
