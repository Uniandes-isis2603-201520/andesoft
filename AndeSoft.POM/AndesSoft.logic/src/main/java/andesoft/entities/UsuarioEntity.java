/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author js.arciniegas10
 */
@Entity
public class UsuarioEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String apellido;
    private String usuario;
    private String correo;
    private String password;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private ItinerarioEntity itinerario;
//    private List<ItinerarioDTO> itinerarios;
//    private List<FotoDTO> fotos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

       public String getNames(){
        return name;
    }

    public void setames(String pNomb) {
        this.name = pNomb;
    }

       public String getApellidos(){
        return apellido;
    }

    public void setApellidos(String pApellidos) {
        this.apellido = pApellidos;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getPassword(){
        return password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
//    public ItinerarioEntity getItinerario() {
//        return itinerario;
//    }
//
//    public void setItinerario(ItinerarioEntity itinerario) {
//        this.itinerario = itinerario;
//    }

}

