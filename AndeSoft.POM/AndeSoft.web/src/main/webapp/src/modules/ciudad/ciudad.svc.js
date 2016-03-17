/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng)
{
var mod = ng.module("AppCiudad");
mod.service('ciudadSVC', ["$http", "contextoCiudad",function ($http, context)
   {
       var itinerario = [];

       /*
        var logueado=false;

       this.darLog= function()
        {
          // console.log("hola"+logueado);
           return this.logueado;
       };

       this.cambiarLog=function(){
           this.logueado=true;
          console.log("hola"+this.logueado);
       };

       this.logout=function(){
           this.logueado=false;
          console.log("hola"+this.logueado);
       };
       */

        this.fetchRecords = function () {
            console.log("Entro a fetch records service");
                return $http.get(context);
            };

       this.agregarCiudad = function (ciudad) {

           /*if (ciudad.nombre) {
                   return $http.post(context, ciudad);
                } else {
                    return $http.post(context, ciudad);
                }
           */
          console.log("El contexto es " + context);
          return $http.post(context,ciudad);
            };

/*
       this.agregarCiudad = function(ciudad)
       {
           console.log("entra a metodo agregar ciudad Servicio");

           itinerario.push(ciudad);
       };
       */

       this.borrarCity = function(ciudad)
       {
           console.log(ciudad + "que e es es o "+ ciudad.nombre)

                return $http.delete(context + "/" + ciudad);
       };

       this.darItinerario= function()
        {
           return itinerario;
       };

   }
    ]);
})(window.angular);
