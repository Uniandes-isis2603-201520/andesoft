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
    /**
     *  var hotel0 = {id: 0, nombre: "hotel Radisson"};
       var hotel1 = {id: 1, nombre: "hotel welcome"};
       var hotel2 = {id: 2, nombre: "hotel bienvenido"};
       var hotel3 = {id: 3, nombre: "hotel konichiwa"};
       
       var ciudad0 = {id: 0, nombre: "Cali"};
       var ciudad1 = {id: 1, nombre: "Palmira"};
       var ciudad2 = {id: 2, nombre: "Londres"};
       var ciudad3 = {id: 3, nombre: "Madrid"};
       var ciudad4 = {id: 4, nombre: "Tokio"};
       
       var evento0 = {id: 0, nombre: "Rumba en Menga"};
       var punto0 = {id: 0, nombre: "estatua: Sebastian de belalcazar"};
       
       var evento1 = {id: 0, nombre: "Excursion a las ruinas abandonadas"};
       var evento2 = {id: 0, nombre: "Concierto de Ed sheeran"};
       var evento3 = {id: 0, nombre: "Entrada al palacio imperial"};
       var punto1 = {id: 0, nombre: "Puente de la victoria"};
       var punto2 = {id: 0, nombre: "Mar blanco"};
       var punto3 = {id: 0, nombre: "Ciclo ruta en las montañas y vista a la estatua"};
       
       var itinerario0 = {id:0, nombre: "Itinerario semana santa", fechaIni:"mayo 20 2016", fechaFin:"mayo 27 2016", ciudades:[ciudad0, ciudad1], eventos:[evento0], hoteles:[hotel0],puntos: [punto0]};
       var itinerario1 = {id:1, nombre: "Itinerario Vacaciones largas", fechaIni:"junio 23 2016", fechaFin:"julio 30 2016", ciudades:[ciudad2, ciudad3, ciudad4], eventos:[evento1, evento2, evento3], hoteles:[hotel1, hotel2, hotel3],puntos: [punto1, punto2,punto3]};
       var itinerarios = [itinerario0, itinerario1];
       
       */
     private ArrayList ciudades;
     private ArrayList eventos;
     private ArrayList puntosI;
     private ArrayList hoteles;
     
     private long id;
     private String nombreIt;
     
     private Date fechaIni;
     private Date fechaFin;
     
     
     public ItinerarioDTO(Long idp, String nombreItp, Date ini, Date fin, ArrayList ciudadesp, ArrayList eventosp, ArrayList puntosp, ArrayList hotelesp)
     {
         id = idp;
         nombreIt = nombreItp;
         fechaIni = ini;
         fechaFin = fin;
         ciudades = ciudadesp;
         eventos = eventosp;
         puntosI = puntosp;
         hoteles = hotelesp;
         
         
     }
        public long darId()
        {
            return id;
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
        public Date darFechaIni( )
        {
            return fechaIni;
        }
        public Date darFechaFin( )
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
        
      

}
