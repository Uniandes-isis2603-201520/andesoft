/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.DB;

import AndeSoft.rest.dtos.UsuarioDTO;
import java.util.ArrayList;

/**
 *
 * @author js.arciniegas10
 */
public class UsuarioSimuladorDB {
private ArrayList<UsuarioDTO> usuarios;

    public UsuarioSimuladorDB()
    {
        usuarios = new ArrayList();

        UsuarioDTO u1 = new UsuarioDTO(Long.parseLong(""+0), "andres", "Moreno", "a.moreno","a@moreno","123");
        UsuarioDTO u2 = new UsuarioDTO(Long.parseLong(""+1), "sebastian", "Arciniegas", "s.arciniegas","s@arciniegas","456");
        UsuarioDTO u3 = new UsuarioDTO(Long.parseLong(""+2), "esteban", "Galvis", "e.galvis","e@galvis","789");
        UsuarioDTO u4 = new UsuarioDTO(Long.parseLong(""+3), "andres", "johan", "j.velasquez","j@velasquez","987");
        UsuarioDTO u5 = new UsuarioDTO(Long.parseLong(""+4), "andres", "Tamura", "a.tamura","a@tamura","654");

        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        usuarios.add(u4);
        usuarios.add(u5);
    }

        public ArrayList getUsuarios(long idIt)
    {
        ArrayList UsuariosResp = new ArrayList();
        for(int i =0; i< usuarios.size();i++)
        {
            UsuarioDTO actual = (UsuarioDTO) usuarios.get(i);

            if(actual.getId() == idIt)
            {
                UsuariosResp.add(actual);
            }
        }
        return UsuariosResp;
    }

         public void setUsuario(long idIt,ArrayList pUsuarios)
    {
        //borra los que tengan ese usuario
        for(int i =0; i< usuarios.size();i++)
        {
            UsuarioDTO actual = (UsuarioDTO) usuarios.get(i);

            if(actual.getId()== idIt)
            {
                usuarios.remove(actual);
            }
        }
        //agrega los nuevos
        for(int i =0; i< pUsuarios.size();i++)
        {
            UsuarioDTO actual = (UsuarioDTO) pUsuarios.get(i);


            usuarios.add(actual);

        }
    }
}

