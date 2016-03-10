/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.exceptions;

/**
 *
 * @author AndresFelipe
 */
public class UsuarioLogicException extends Exception {
    
        /**
     * Constructor por defecto
     */
    public UsuarioLogicException(){
        
    }
    
    /**
     * COnstructor con mensaje
     * @param msg mensaje de la excepción
     * 
     */
    public UsuarioLogicException(String msg){
        super(msg);
    }
    
    /**
     * Constructor con causa
     * @param cause causa de la excepción. Usada para generar la traza.
     */
    public UsuarioLogicException(Throwable cause){
        super(cause);
    }
    
    /**
     * Constructor con mensaje y causa
     * @param msg mensaje de la excepción
     * @param cause causa de la excepción. Usada para generar la traza.
     */
    public UsuarioLogicException(String msg, Throwable cause){
        super(msg, cause);
    }
}
