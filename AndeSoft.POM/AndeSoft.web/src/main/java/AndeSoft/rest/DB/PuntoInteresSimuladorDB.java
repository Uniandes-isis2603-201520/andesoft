/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.DB;

import AndeSoft.rest.dtos.PuntoInteresDTO;
import java.util.ArrayList;

/**
 *
 * @author mm.gomez10
 */
public class PuntoInteresSimuladorDB 
{
    
    private   ArrayList < PuntoInteresDTO>  puntosInteres;
    
    public PuntoInteresSimuladorDB()
    {
        puntosInteres = new ArrayList ();
        
       /* PuntoInteresDTO punto1 = new PuntoInteresDTO ( Long.parseLong(""+0), 
                "feria", "25/12/2016", "05/01/2017");
        PuntoInteresDTO punto2 = new PuntoInteresDTO ( Long.parseLong(""+1),
                "playa", "06/07/2016", "06/07/2016");
        PuntoInteresDTO punto3 = new PuntoInteresDTO ( Long.parseLong(""+2),
                "Ir a Andrés Carne de Res", "08/10/2017", "06/10/2017");
        PuntoInteresDTO punto4 = new PuntoInteresDTO ( Long.parseLong(""+3),
                "Ir a Disney", "04/05/2018", "10/05/2018");
        PuntoInteresDTO punto5 = new PuntoInteresDTO ( Long.parseLong(""+4),
                "Ir a Sea World", "11/05/2018", "13/05/2018");
        
        puntosInteres.add(punto1);
        puntosInteres.add(punto2);
        puntosInteres.add(punto3);
        puntosInteres.add(punto4);
        puntosInteres.add(punto5);*/
        
    }
    public ArrayList getPuntosInteresDeItinerario(long idIt)
    {
        ArrayList eventosResp = new ArrayList();
        for(int i =0; i< puntosInteres.size();i++)
        {
            PuntoInteresDTO actual = (PuntoInteresDTO) puntosInteres.get(i);
            if(actual.getIdItinerario()== idIt)
            {
                puntosInteres.add(actual);
            }
            
        }
        return eventosResp;
    }
    
    
    public void setPuntosInteresDeUsuario(long idIt,ArrayList pEventos)
    {
        //borra los que tengan ese itinerario
        for(int i =0; i< puntosInteres.size();i++)
        {
            PuntoInteresDTO actual = (PuntoInteresDTO) puntosInteres.get(i);
            
            if(actual.getIdItinerario()== idIt)
            {
                puntosInteres.remove(actual);
            }
        }
        //agrega los nuevos
        for(int i =0; i< pEventos.size();i++)
        {
            PuntoInteresDTO actual = (PuntoInteresDTO) pEventos.get(i);
            
            
            puntosInteres.add(actual);
            
        }
    }
}
