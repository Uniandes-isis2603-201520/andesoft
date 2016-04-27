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
import javax.persistence.OneToMany;

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
    
  //  @OneToMany(cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItinerarioEntity> itinerarios;
//    private ItinerarioEntity itinerario;
//    private List<FotoDTO> fotos;
    public UsuarioEntity()
    {
        
    }
    public UsuarioEntity(long idn)
    {
        id = idn;
    }

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
      public void setnuevoItinerario(ItinerarioEntity itinerario) {
         this.itinerarios.add( itinerario);
    }
      
      public void setborrarItinerario(ItinerarioEntity itinerario) 
      {
         this.itinerarios.remove(itinerario);
    }

}

