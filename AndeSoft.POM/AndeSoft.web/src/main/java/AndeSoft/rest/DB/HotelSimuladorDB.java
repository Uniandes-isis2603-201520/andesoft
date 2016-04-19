/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.DB;

import AndeSoft.rest.dtos.HotelDTO;
import java.util.ArrayList;

/**
 *
 * @author AndresFelipe
 */
public class HotelSimuladorDB
{
    private ArrayList<HotelDTO> hoteles;

    public HotelSimuladorDB()
    {
        hoteles = new ArrayList();

        HotelDTO h1 = new HotelDTO(Long.parseLong(""+0), "aaa", "25/12/2016", "05/01/2017");
        HotelDTO h2 = new HotelDTO(Long.parseLong(""+1), "bbb", "06/07/2016", "06/07/2016");
        HotelDTO h3 = new HotelDTO(Long.parseLong(""+2), "ccc", "08/10/2017", "06/10/2017");
        HotelDTO h4 = new HotelDTO(Long.parseLong(""+3), "ddd", "04/05/2018", "10/05/2018");
        HotelDTO h5 = new HotelDTO(Long.parseLong(""+4), "eee", "11/05/2018", "13/05/2018");

        hoteles.add(h1);
        hoteles.add(h2);
        hoteles.add(h3);
        hoteles.add(h4);
        hoteles.add(h5);
    }

        public ArrayList getHotelesDeCiudad(long idIt)
    {
        ArrayList hotelesResp = new ArrayList();
        for(int i =0; i< hoteles.size();i++)
        {
            HotelDTO actual = (HotelDTO) hoteles.get(i);

            if(actual.getId() == idIt)
            {
                hotelesResp.add(actual);
            }
        }
        return hotelesResp;
    }

         public void setHotelesDeUsuario(long idIt,ArrayList pHoteles)
    {
        //borra los que tengan ese hotel
        for(int i =0; i< hoteles.size();i++)
        {
            HotelDTO actual = (HotelDTO) hoteles.get(i);

            if(actual.getId()== idIt)
            {
                hoteles.remove(actual);
            }
        }
        //agrega los nuevos
        for(int i =0; i< pHoteles.size();i++)
        {
            HotelDTO actual = (HotelDTO) pHoteles.get(i);


            hoteles.add(actual);

        }
    }
}
