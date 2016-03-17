/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.DB;

import AndeSoft.rest.dtos.EventoDTO;
import java.util.ArrayList;

/**
 *
 * @author mm.gomez10
 */
public class EventoSimuladorDB 
{
    
    private   ArrayList < EventoDTO>  eventos;
    
    public EventoSimuladorDB()
    {
        eventos = new ArrayList ();
        
        EventoDTO evento1 = new EventoDTO ( Long.parseLong(""+0), Long.parseLong(1+""), 
                "Ir a la feria", "25/12/2016", "05/01/2017", "Cali");
        EventoDTO evento2 = new EventoDTO ( Long.parseLong(""+1), Long.parseLong(""+5),
                "Ir a la playa", "06/07/2016", "06/07/2016", "Cartagena");
        EventoDTO evento3 = new EventoDTO ( Long.parseLong(""+2), Long.parseLong(""+4),
                "Ir a Andrés Carne de Res", "08/10/2017", "06/10/2017", "Bogotá");
        EventoDTO evento4 = new EventoDTO ( Long.parseLong(""+3), Long.parseLong(""+2),
                "Ir a Disney", "04/05/2018", "10/05/2018", "Orlando");
        EventoDTO evento5 = new EventoDTO ( Long.parseLong(""+4), Long.parseLong(""+2),
                "Ir a Sea World", "11/05/2018", "13/05/2018", "Orlando");
        
        eventos.add(evento1);
        eventos.add(evento2);
        eventos.add(evento3);
        eventos.add(evento4);
        eventos.add(evento5);
        
    }
    public ArrayList getEventosDeItinerario(long idIt)
    {
        ArrayList eventosResp = new ArrayList();
        for(int i =0; i< eventos.size();i++)
        {
            EventoDTO actual = (EventoDTO) eventos.get(i);
            
            if(actual.getIdItinerario() == idIt)
            {
                eventosResp.add(actual);
            }
        }
        return eventosResp;
    }
    
    
    public void setEventosDeUsuario(long idIt,ArrayList pEventos)
    {
        //borra los que tengan ese itinerario
        for(int i =0; i< eventos.size();i++)
        {
            EventoDTO actual = (EventoDTO) eventos.get(i);
            
            if(actual.getIdItinerario()== idIt)
            {
                eventos.remove(actual);
            }
        }
        //agrega los nuevos
        for(int i =0; i< pEventos.size();i++)
        {
            EventoDTO actual = (EventoDTO) pEventos.get(i);
            
            
            eventos.add(actual);
            
        }
    }
}
