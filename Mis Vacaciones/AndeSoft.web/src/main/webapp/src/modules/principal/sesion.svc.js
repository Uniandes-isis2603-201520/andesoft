/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) 
{
    var mod = ng.module("SesionModule");

    mod.service("sesionService", [ function () {

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

       
    }]);
})(window.angular);
