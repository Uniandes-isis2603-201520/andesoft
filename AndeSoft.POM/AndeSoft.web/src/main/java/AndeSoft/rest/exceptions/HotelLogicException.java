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
public class HotelLogicException extends Exception {
    
        /**
     * Constructor por defecto
     */
    public HotelLogicException(){
        
    }
    
    /**
     * COnstructor con mensaje
     * @param msg mensaje de la excepción
     * 
     */
    public HotelLogicException(String msg){
        super(msg);
    }
    
    /**
     * Constructor con causa
     * @param cause causa de la excepción. Usada para generar la traza.
     */
    public HotelLogicException(Throwable cause){
        super(cause);
    }
    
    /**
     * Constructor con mensaje y causa
     * @param msg mensaje de la excepción
     * @param cause causa de la excepción. Usada para generar la traza.
     */
    public HotelLogicException(String msg, Throwable cause){
        super(msg, cause);
    }
}