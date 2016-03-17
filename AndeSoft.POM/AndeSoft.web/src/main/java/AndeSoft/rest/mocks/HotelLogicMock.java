/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.mocks;

import AndeSoft.rest.DB.HotelSimuladorDB;
import AndeSoft.rest.dtos.HotelDTO;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author AndresFelipe
 */
public class HotelLogicMock 
{
    ArrayList <HotelDTO> hoteles;
    
    public HotelLogicMock()
    {
        hoteles = new ArrayList();
    }
    
    public ArrayList getTodosHotelesIdItinerario(long idIt)
    {
        HotelSimuladorDB baseDatos = new HotelSimuladorDB();
        hoteles = baseDatos.getHotelesDeItinerario(idIt);
        return hoteles;
    }
    
    public HotelDTO getHotel(long id, long idHo)
    {
        HotelSimuladorDB baseDatos = new HotelSimuladorDB();
        hoteles = baseDatos.getHotelesDeItinerario(id);
        
        HotelDTO buscado = null;
        
        for(int i=0; i< hoteles.size() && buscado==null; i++)
        {
            HotelDTO actual =  hoteles.get(i);
            if(actual.getId() == idHo)
            {
                buscado = actual;
            }
        }
        return buscado;
    }
    
     public HotelDTO createHotel(HotelDTO hotel, long idIt)
     {
         HotelSimuladorDB baseDatos = new HotelSimuladorDB();
        hoteles = baseDatos.getHotelesDeItinerario(idIt);
         
         HotelDTO existe= getHotel(idIt, hotel.getId());
         
         if(existe != null){return null;}
         
         hoteles.add(hotel);
         
        baseDatos.setHotelesDeUsuario(idIt, hoteles);
         
         return hotel;
     }
     
     public HotelDTO updateHotel(long idIt, long idHo, HotelDTO hotelNuevo) //throws Exception
     {
         HotelSimuladorDB baseDatos = new HotelSimuladorDB();
        hoteles = baseDatos.getHotelesDeItinerario(idIt);
         
         for(int i=0;i< hoteles.size();i++)
         {
             HotelDTO actual = hoteles.get(i);
             if(actual.getId() == idHo)
             {
                 hoteles.remove(actual);
                 hoteles.add(hotelNuevo);
                 
                  baseDatos.setHotelesDeUsuario(idIt, hoteles);
                  
                  return hotelNuevo;
             }
         }
         return null;
         //throw new Exception(" No hay evento con ese id");
     }
     
     public void deleteHotel(long idIt, long idHo)
     {
         HotelSimuladorDB baseDatos = new HotelSimuladorDB();
        hoteles = baseDatos.getHotelesDeItinerario(idIt);
         
         for(int i=0;i< hoteles.size();i++)
         {
             HotelDTO actual = hoteles.get(i);
             if(actual.getId() == idHo)
             {
                 hoteles.remove(i);
                 
                  baseDatos.setHotelesDeUsuario(idIt, hoteles );
                   break;
             }
         }
     }
    
}
