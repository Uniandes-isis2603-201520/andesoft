package AndeSoft.rest.mocks;

import AndeSoft.rest.DB.EventoSimuladorDB;
import AndeSoft.rest.dtos.EventoDTO;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author mm.gomez10
 */
/**
 * Mock del recurso Eventos (Mock del servicio REST)
 */
@Named
@ApplicationScoped
public class EventoLogicMock 
{
    ArrayList <EventoDTO>eventos;
    /**
     * Tiene la lista de los eventos de un itinerario
     */
    public EventoLogicMock() 
    {
         eventos = new ArrayList();  
         
    }
    
    public ArrayList getTodosEventosIdItinerario(long idIt)
    {
        EventoSimuladorDB baseDatos = new EventoSimuladorDB();
        eventos = baseDatos.getEventosDeItinerario(idIt);
        return eventos;
    }
     public EventoDTO getEvento(long idIt, long idEv)
    {
        EventoSimuladorDB baseDatos = new EventoSimuladorDB();
        eventos = baseDatos.getEventosDeItinerario(idIt);
        
        EventoDTO buscado = null;
        
        for(int i=0; i< eventos.size() && buscado==null; i++)
        {
            EventoDTO actual =  eventos.get(i);
            if(actual.getId() == idEv)
            {
                buscado = actual;
            }
        }
        
        return buscado;
    }
     
     public EventoDTO createEvento(EventoDTO evento, long idIt)
     {
         EventoSimuladorDB baseDatos = new EventoSimuladorDB();
        eventos = baseDatos.getEventosDeItinerario(idIt);
         
         EventoDTO existe= getEvento(idIt, evento.getId());
         
         if(existe != null){return null;}
         
         eventos.add(evento);
         
        baseDatos.setEventosDeUsuario(idIt, eventos);
         
         return evento;
         
     }
     
     public EventoDTO updateEvento(long idIt, long idEv, EventoDTO eventoNuevo) //throws Exception
     {
         EventoSimuladorDB baseDatos = new EventoSimuladorDB();
        eventos = baseDatos.getEventosDeItinerario(idIt);
         
         for(int i=0;i< eventos.size();i++)
         {
             EventoDTO actual = eventos.get(i);
             if(actual.getId() == idEv)
             {
                 eventos.remove(actual);
                 eventos.add(eventoNuevo);
                 
                  baseDatos.setEventosDeUsuario(idIt, eventos);
                  
                  return eventoNuevo;
             }
         }
         return null;
         //throw new Exception(" No hay evento con ese id");
     }
     public void deleteEvento(long idIt, long idEv)
     {
         EventoSimuladorDB baseDatos = new EventoSimuladorDB();
        eventos = baseDatos.getEventosDeItinerario(idIt);
         
         for(int i=0;i< eventos.size();i++)
         {
             EventoDTO actual = eventos.get(i);
             if(actual.getId() == idEv)
             {
                 eventos.remove(i);
                 
                  baseDatos.setEventosDeUsuario(idIt, eventos );
                   break;
             }
         }
     }
    
}
