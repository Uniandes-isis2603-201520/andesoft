/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

import java.util.Date;

/**
 * Objeto de transferencia de datos de Fotos
 * @author AndresFelipe
 */
public class FotoDTO {
    private Long id;
    private String ruta;
    private String comentario;
    private Date fecha;
    
        /**
         * Constructor por defecto
         */
         public FotoDTO(){
    
        }
         
         /**
          * Constructor con parametros
          * @param id identificador de la foto
          * @param ruta ruta de localizaci[on de la foto
          * @param comentario comentario de la foto
          */
         public FotoDTO(Long id, String ruta, String comentario, Date fecha){
             this.id = id;
             this.ruta = ruta;
             this.comentario = comentario;
             this.fecha = fecha;
         }
         
         /**
          * Retorna el id de la foto
          */
         public Long getId(){
             return id;
         }
         
         /**
          * Retorna la ruta de la foto
          */
         public String getRuta(){
             return ruta;
         }
         
         /**
          * Retorna el comentario de la foto
          */
         public String getComentario(){
             return comentario;
         }
         
         /**
          * Retorna la fecha de la foto
          */
         public Date getFecha(){
             return fecha;
         }
         
         /**
          * Modifica el comentario de la foto
          * @param comentario nuevo comentario
          */
         public void setComentario(String comentario){
             this.comentario = comentario;
         }
         
         /**
          * Convierte el objeto a una cadena
          */
         @Override
         public String toString(){
             return "{id:" + getId() + ", ruta : \"" + getRuta() + "\"}"; 
         }
    
}
