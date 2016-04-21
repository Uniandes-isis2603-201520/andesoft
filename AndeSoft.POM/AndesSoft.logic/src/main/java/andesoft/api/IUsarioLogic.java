/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andesoft.api;

import java.util.List;
import andesoft.entities.UsuarioEntity;

/**
 *
 * @author js.arciniegas10
 */
public interface IUsarioLogic {
    
    public UsuarioEntity  getUsuario(Long id);
    public List<UsuarioEntity> getUsuarios();
    public UsuarioEntity createUsuario(UsuarioEntity dto);
    public UsuarioEntity updateUsuario(UsuarioEntity entity);
    public void deleteUsuario(Long id);
    
}
