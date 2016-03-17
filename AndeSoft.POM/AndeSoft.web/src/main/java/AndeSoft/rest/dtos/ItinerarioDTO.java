/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jg.tamura10
 * 
 * FUNCIONA AHORA COMO BD
 */
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
        
      

}
