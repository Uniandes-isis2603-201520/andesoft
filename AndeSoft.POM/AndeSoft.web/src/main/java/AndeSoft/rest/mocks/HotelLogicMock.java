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

    public ArrayList getTodosHotelesIdCiudad(long idCity)
    {
        HotelSimuladorDB baseDatos = new HotelSimuladorDB();
        hoteles = baseDatos.getHotelesDeCiudad(idCity);
        return hoteles;
    }

    public HotelDTO getHotel(long idCity, long idHo)
    {
        HotelSimuladorDB baseDatos = new HotelSimuladorDB();
        hoteles = baseDatos.getHotelesDeCiudad(idCity);

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

     public HotelDTO createHotel(HotelDTO hotel, long idCity)
     {
         HotelSimuladorDB baseDatos = new HotelSimuladorDB();
        hoteles = baseDatos.getHotelesDeCiudad(idCity);

         HotelDTO existe= getHotel(idCity, hotel.getId());

         if(existe != null){return null;}

         hoteles.add(hotel);

        baseDatos.setHotelesDeUsuario(idCity, hoteles);

         return hotel;
     }

     public HotelDTO updateHotel(long idCity, long idHo, HotelDTO hotelNuevo) //throws Exception
     {
         HotelSimuladorDB baseDatos = new HotelSimuladorDB();
        hoteles = baseDatos.getHotelesDeCiudad(idCity);

         for(int i=0;i< hoteles.size();i++)
         {
             HotelDTO actual = hoteles.get(i);
             if(actual.getId() == idHo)
             {
                 hoteles.remove(actual);
                 hoteles.add(hotelNuevo);

                  baseDatos.setHotelesDeUsuario(idCity, hoteles);

                  return hotelNuevo;
             }
         }
         return null;
         //throw new Exception(" No hay evento con ese id");
     }

     public void deleteHotel(long idCity, long idHo)
     {
         HotelSimuladorDB baseDatos = new HotelSimuladorDB();
        hoteles = baseDatos.getHotelesDeCiudad(idCity);

         for(int i=0;i< hoteles.size();i++)
         {
             HotelDTO actual = hoteles.get(i);
             if(actual.getId() == idHo)
             {
                 hoteles.remove(i);

                  baseDatos.setHotelesDeUsuario(idCity, hoteles );
                   break;
             }
         }
     }

}
