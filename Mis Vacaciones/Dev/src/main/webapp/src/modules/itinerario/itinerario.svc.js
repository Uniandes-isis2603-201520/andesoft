/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng)
{
var mod = ng.module("AppItinerario");
mod.service('itinerarioSVC', [function ()
   {
       var itinerario = [];
       this.agregarCiudad = function(ciudad)
       {
           console.log("entra a metodo agregar ciudad Servicio");

           itinerario.push(ciudad);
       };

       this.borrarCity = function(ciudad)
       {
             var indice = itinerario.indexOf(ciudad);
            itinerario.splice(indice,1);
       };

       this.darItinerario= function()
        {
           return itinerario;
       };

   }
    ]);
})(window.angular);
