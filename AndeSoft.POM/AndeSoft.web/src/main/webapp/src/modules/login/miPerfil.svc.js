/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng)
{
    var mod = ng.module("AppMiPerfil");
    mod.service('miPerfilSVC', [function ()
        {
           
            var fotos = [];

           
            this.agregarFoto = function(foto)
            {
                console.log("Entra a agregar foto");
                fotos.push(foto);
            };

            this.borrarFoto = function(foto)
            {
                var indice = fotos.indexOf(foto);
                fotos.splice(indice,1);
            };

            this.darFotos = function()
            {
                return fotos;
            };

        }]);
})(window.angular);
