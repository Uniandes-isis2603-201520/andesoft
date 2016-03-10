/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng)
{
var mod = ng.module("AppEvento");
mod.service('eventoSVC', [function ()
   {
       
       var logueado=false;
       
//       var id0 = 0;
//       var nom0 = "Museum of Modern Arts";
//       var fechaIn0 = "01/06/2016";
//       var fechaFin0 = "02/06/2016";
       
//       var id1 = 1;
//       var nom1 = "Torre Eiffel";
//       var fechaIn1 = "03/06/2016";
//       var fechaFin1 = "04/06/2016";
       
//       var id2 = 2;
//       var nom2 = "Disney";
//       var fechaIn2 = "05/06/2016";
//       var fechaFin2 = "10/06/2016";
       
//       var evento0 = {id: id0, nombre: nom0, fechaInicio: fechaIn0, fechaFinal: fechaFin0};
//       var evento1 = {id: id1, nombre: nom1, fechaInicio: fechaIn1, fechaFinal: fechaFin1};
//       var evento2 = {id: id2, nombre: nom2, fechaInicio: fechaIn2, fechaFinal: fechaFin2};
       
//       var listaEventos = [evento0,evento1,evento2];
       var listaEventos = [];
       //-----------------------------------------------------------------------
       
       this.darLog= function()
        {
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
       //-----------------------------------------------------------------------

       this.agregarEvento = function(evento)
       {
           console.log("entra a metodo agregar evento Servicio");

           listaEventos.push(evento);
       };

       this.borrarEvento = function(evento)
       {
             var indice = listaEventos.indexOf(evento);
            listaEventos.splice(indice,1);
       };

       this.darListaEventos= function()
        {
           return listaEventos;
       };

   }
    ]);
})(window.angular);
