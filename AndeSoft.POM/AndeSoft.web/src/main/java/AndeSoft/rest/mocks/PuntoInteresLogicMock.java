package AndeSoft.rest.mocks;


import AndeSoft.rest.DB.PuntoInteresSimuladorDB;
import AndeSoft.rest.dtos.PuntoInteresDTO;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @authorjs.velasquez2463
 */
/**
 * Mock del recurso Puntos de interes (Mock del servicio REST)
 */
@Named
@ApplicationScoped
public class PuntoInteresLogicMock 
{
    ArrayList <PuntoInteresDTO>puntosInteres;
    /**
     * Tiene la lista de los puntos de interes de un itinerario
     */
    public PuntoInteresLogicMock() 
    {
         puntosInteres = new ArrayList();  
         
    }
    
    public ArrayList getTodosPuntosInteresIdItinerario(long idIt)
    {
        PuntoInteresSimuladorDB baseDatos = new PuntoInteresSimuladorDB();
        puntosInteres = baseDatos.getPuntosInteresDeItinerario(idIt);
        return puntosInteres;
    }
     public PuntoInteresDTO getPuntoInteres(long idIt, long idEv)
    {
        PuntoInteresSimuladorDB baseDatos = new PuntoInteresSimuladorDB();
        puntosInteres = baseDatos.getPuntosInteresDeItinerario(idIt);
        
        PuntoInteresDTO buscado = null;
        
        for(int i=0; i< puntosInteres.size() && buscado==null; i++)
        {
            PuntoInteresDTO actual =  puntosInteres.get(i);
            if(actual.getId() == idEv)
            {
                buscado = actual;
            }
        }
        
        return buscado;
    }
     
     public PuntoInteresDTO createPuntoInteres(PuntoInteresDTO punto, long idIt)
     {
         PuntoInteresSimuladorDB baseDatos = new PuntoInteresSimuladorDB();
        puntosInteres = baseDatos.getPuntosInteresDeItinerario(idIt);
         
         PuntoInteresDTO existe= getPuntoInteres(idIt, punto.getId());
         
         if(existe != null){return null;}
         
         puntosInteres.add(punto);
         
        baseDatos.setPuntosInteresDeUsuario(idIt, puntosInteres);
         
         return punto;
         
     }
     
     public PuntoInteresDTO updatePuntoInteres(long idIt, long idEv, PuntoInteresDTO puntoNuevo) //throws Exception
     {
         PuntoInteresSimuladorDB baseDatos = new PuntoInteresSimuladorDB();
        puntosInteres = baseDatos.getPuntosInteresDeItinerario(idIt);
         
         for(int i=0;i< puntosInteres.size();i++)
         {
             PuntoInteresDTO actual = puntosInteres.get(i);
             if(actual.getId() == idEv)
             {
                 puntosInteres.remove(actual);
                 puntosInteres.add(puntoNuevo);
                 
                  baseDatos.setPuntosInteresDeUsuario(idIt, puntosInteres);
                  
                  return puntoNuevo;
             }
         }
         return null;
         //throw new Exception(" No hay evento con ese id");
     }
     public void deletePuntoInteres(long idIt, long idEv)
     {
         PuntoInteresSimuladorDB baseDatos = new PuntoInteresSimuladorDB();
        puntosInteres = baseDatos.getPuntosInteresDeItinerario(idIt);
         
         for(int i=0;i< puntosInteres.size();i++)
         {
             PuntoInteresDTO actual = puntosInteres.get(i);
             if(actual.getId() == idEv)
             {
                 puntosInteres.remove(i);
                 
                  baseDatos.setPuntosInteresDeUsuario(idIt, puntosInteres );
                   break;
             }
         }
     }
    
}
