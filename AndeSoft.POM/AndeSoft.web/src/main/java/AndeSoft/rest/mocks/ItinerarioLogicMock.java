/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.mocks;

import AndeSoft.rest.dtos.ItinerarioDTO;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author jg.tamura10
 */
/**
 * Mock del recurso Ciudades (Mock del servicio REST)
 */
@Named
@ApplicationScoped
public class ItinerarioLogicMock 
{
    ArrayList itinerarios;
    /**
     * Tiene la lista de los itinerarios de un usuario
     */
    public ItinerarioLogicMock() 
    {
         itinerarios = new ArrayList();  
         
    }
    public void agregarDatos()
    {
        
    }
    public ArrayList getTodosItinerariosIDPerfil(long id)
    {
        itinerarios = UsuarioLogicMock.getItinerariosDeUsuario(id);
        return itinerarios;
    }
     public ItinerarioDTO getItinerario(long idP, long idI)
    {
        itinerarios = UsuarioLogicMock.getItinerariosDeUsuario(idP);
        
        ItinerarioDTO buscado = null;
        
        for(int i=0; i< itinerarios.size(); i++)
        {
            ItinerarioDTO actual =  (ItinerarioDTO) itinerarios.get(i);
            if(actual.darId() == idI)
            {
                buscado = actual;
                break;
            }
        }
        
        return buscado;
    }
     
     public ItinerarioDTO createItinerario(ItinerarioDTO it, long id)
     {
         itinerarios = UsuarioLogicMock.getItinerariosDeUsuario(id);
         
         if(itinerarios.contains(it))
         {
             return null;
         }
         
         itinerarios.add(it);
         
         UsuarioLogicMock.setItinerariosDeUsuario(id, itinerarios);
         
         return it;
         
     }
     
     public ItinerarioDTO updateItinerario(long idP, long idI, ItinerarioDTO itN) //throws Exception
     {
         itinerarios = UsuarioLogicMock.getItinerariosDeUsuario(idP);
         
         for(int i=0;i< itinerarios.size();i++)
         {
             ItinerarioDTO actual = ( ItinerarioDTO)itinerarios.get(i);
             if(actual.darId() == idI)
             {
                 itinerarios.remove(i);
                 itinerarios.add(itN);
                 
                  UsuarioLogicMock.setItinerariosDeUsuario(idP, itinerarios);
                  
                  return itN;
             }
         }
         return null;
         //throw new Exception(" No hay itinerario con ese id");
     }
     public void deleteItinerario(long idP, long idI)
     {

         itinerarios = UsuarioLogicMock.getItinerariosDeUsuario(idP);
         
         for(int i=0;i< itinerarios.size();i++)
         {
             ItinerarioDTO actual = ( ItinerarioDTO)itinerarios.get(i);
             if(actual.darId() == idI)
             {
                 itinerarios.remove(i);
                 
                  UsuarioLogicMock.setItinerariosDeUsuario(idP, itinerarios );
                   
             }
         }
     }
    
}
