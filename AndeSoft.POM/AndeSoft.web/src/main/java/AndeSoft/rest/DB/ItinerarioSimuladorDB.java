/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.DB;

import AndeSoft.rest.dtos.ItinerarioDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jg.tamura10
 */
public class ItinerarioSimuladorDB 
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
    private  ArrayList itinerarios;
    
    public ItinerarioSimuladorDB()
    {
         itinerarios  = new ArrayList();
        
        ArrayList ciudades = new ArrayList();
        ArrayList eventos = new ArrayList();
        ArrayList puntos = new ArrayList();
        ArrayList hoteles = new ArrayList();
        
        ItinerarioDTO primero = new ItinerarioDTO(0, 0,  "Itinerario semana santa", "mayo 20 2016", "mayo 27 2016",  ciudades,  eventos, puntos, hoteles);
        
        
        ArrayList ciudades2 = new ArrayList();
        ArrayList eventos2 = new ArrayList();
        ArrayList puntos2 = new ArrayList();
        ArrayList hoteles2 = new ArrayList();
        ItinerarioDTO segundo = new ItinerarioDTO(0, 1,  "Itinerario Vacaciones largas", "junio 23 2016", "julio 30 2016",  ciudades2,  eventos2, puntos2, hoteles2);
        
        itinerarios.add(primero);
        itinerarios.add(segundo);
    }
    public ArrayList getItinerariosDeUsuario(int id)
    {
        ArrayList itinerariosResp = new ArrayList();
        for(int i =0; i< itinerarios.size();i++)
        {
            ItinerarioDTO actual = (ItinerarioDTO) itinerarios.get(i);
            
            if(actual.darIdUsuarioDueño() == id)
            {
                itinerariosResp.add(actual);
            }
        }
        return itinerariosResp;
    }
    
    
    public void setItinerariosDeUsuario(int idP,ArrayList itinerariosN)
    {
        //borra los que tengan ese itinerario
        for(int i =0; i< itinerarios.size();i++)
        {
            ItinerarioDTO actual = (ItinerarioDTO) itinerarios.get(i);
            
            if(actual.darIdUsuarioDueño() == idP)
            {
                itinerarios.remove(actual);
            }
        }
        //agrega los nuevos
        for(int i =0; i< itinerariosN.size();i++)
        {
            ItinerarioDTO actual = (ItinerarioDTO) itinerariosN.get(i);
            
            
            itinerarios.add(actual);
            
        }
    }
}
