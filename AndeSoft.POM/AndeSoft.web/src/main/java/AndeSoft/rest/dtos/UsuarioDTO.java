/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author js.arciniegas10
 * UsuarioDTO
 * Objeto de transferencia de datos de Usuarios.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 */
public class UsuarioDTO {

    private Long id;
    private String name;
    private String apellido;
    private String usuario;
    private String correo;
    private String password;
    private List<ItinerarioDTO> itinerarios;
    private List<FotoDTO> fotos;


    /**
     * Constructor por defecto
     */
    public UsuarioDTO() {
	}

    /**
     * Constructor con parámetros.
     * @param id identificador de la ciudad
     * @param name nombre de la ciudad
     * @param apellido
     * @param usuario
     * @param correo
     * @param password
     */
    public UsuarioDTO(Long id, String name, String apellido, String usuario, String correo, String password ,List itinerarios) {
		super();
		this.id = id;
		this.name = name;
                this.apellido = apellido;
		this.usuario = usuario;
                this.correo = correo;
		this.password = password;
                this.itinerarios = null;
                this.fotos = null;
	}

	/**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
     public String getApellido(){
        return apellido;
    }

    public void setApellido(String pApellidos) {
        this.apellido = pApellidos;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String cedula) {
        this.correo = correo;
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

    public List<ItinerarioDTO> getItinerario() {
        return itinerarios;
    }
    
    public List<FotoDTO> getFotos(){
        return fotos;
    }

    public void setCitas(List<ItinerarioDTO> itinerarios) {
        this.itinerarios = itinerarios;
    }

    public void agregarItinerario(ItinerarioDTO itinerario)
    {
        if(itinerarios == null)
            itinerarios = new ArrayList<ItinerarioDTO>();
        itinerarios.add(itinerario);
    }
    
    public void agregarFoto(FotoDTO foto)
    {
        if(fotos == null)
            fotos = new ArrayList<FotoDTO>();
        fotos.add(foto);
    }

    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
    	return "{ id : " + getId() + ", name : \"" + getName() + "\" }" ;
    }
}
