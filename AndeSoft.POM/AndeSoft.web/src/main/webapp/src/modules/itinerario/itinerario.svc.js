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
       var idItinerarioActual = 0;
       
       this.darIdItinerarioActual = function()
       {
           return idItinerarioActual;
       };
       this.setItinerarioActual = function( idN)
       {
           idItinerarioActual = idN;
       };
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
       
   
       var hotel0 = {id: 0, nombre: "hotel Radisson"};
       var hotel1 = {id: 1, nombre: "hotel welcome"};
       var hotel2 = {id: 2, nombre: "hotel bienvenido"};
       var hotel3 = {id: 3, nombre: "hotel konichiwa"};
       
       var ciudad0 = {id: 0, nombre: "Cali"};
       var ciudad1 = {id: 1, nombre: "Palmira"};
       var ciudad2 = {id: 2, nombre: "Londres"};
       var ciudad3 = {id: 3, nombre: "Madrid"};
       var ciudad4 = {id: 4, nombre: "Tokio"};
       
       var evento0 = {id: 0, nombre: "Rumba en Menga"};
       var punto0 = {id: 0, nombre: "estatua: Sebastian de belalcazar"};
       
       var evento1 = {id: 0, nombre: "Excursion a las ruinas abandonadas"};
       var evento2 = {id: 0, nombre: "Concierto de Ed sheeran"};
       var evento3 = {id: 0, nombre: "Entrada al palacio imperial"};
       var punto1 = {id: 0, nombre: "Puente de la victoria"};
       var punto2 = {id: 0, nombre: "Mar blanco"};
       var punto3 = {id: 0, nombre: "Ciclo ruta en las montañas y vista a la estatua"};
       
       var itinerario0 = {id:0, nombre: "Itinerario semana santa", fechaIni:"mayo 20 2016", fechaFin:"mayo 27 2016", ciudades:[ciudad0, ciudad1], eventos:[evento0], hoteles:[hotel0],puntos: [punto0]};
       var itinerario1 = {id:1, nombre: "Itinerario Vacaciones largas", fechaIni:"junio 23 2016", fechaFin:"julio 30 2016", ciudades:[ciudad2, ciudad3, ciudad4], eventos:[evento1, evento2, evento3], hoteles:[hotel1, hotel2, hotel3],puntos: [punto1, punto2,punto3]};
       var itinerarios = [itinerario0, itinerario1];
       
       
       
       
        this.darCiudades = function(idItinerario)
        {
            console.log("Recupera ciudades");
            for(var i=0;i< itinerarios.length;i++)
            {
                if(  itinerarios[i].id ==   idItinerario  )
                {
                    return itinerarios[i].ciudades;
                }
            }
        };
        this.darEventos = function(idItinerario)
        {
            console.log("Recupera eventos");
             for(var i=0;i< itinerarios.length;i++)
            {
                if(  itinerarios[i].id ==   idItinerario  )
                {
                    return itinerarios[i].eventos;
                }
            }
        };
        this.darPuntos = function(idItinerario)
        {
            
            console.log("Recupera puntos");
             for(var i=0;i< itinerarios.length;i++)
            {
                if(  itinerarios[i].id ==   idItinerario  )
                {
                    return itinerarios[i].puntos;
                }
            }
        };
        this.darHoteles = function(idItinerario)
        {
            
            console.log("Recupera hoteles");
             for(var i=0;i< itinerarios.length;i++)
            {
                if(  itinerarios[i].id ==  idItinerario  )
                {
                    return itinerarios[i].hoteles;
                }
            }
        };
        this.darNombreItinerario= function(idItinerario)
        {
         
            console.log("Recupera nombre");   
             for(var i=0;i< itinerarios.length;i++)
            {
                if(  itinerarios[i].id ==   idItinerario  )
                {
                    return itinerarios[i].nombre;
                }
            }
        };
        this.darFechaInicialItinerario = function(idItinerario)
        {
            
            console.log("Fecha inicial ");
            
             for(var i=0;i< itinerarios.length;i++)
            {
                if(  itinerarios[i].id ==   idItinerario  )
                {
                    
                    console.log(": "+ itinerarios[i].fechaIni);
                    return itinerarios[i].fechaIni;
                }
            }
        };
        this.darFechaFinItinerario = function(idItinerario)
        {
            console.log("Fecha Fin ");
             for(var i=0;i< itinerarios.length;i++)
            {
                if(  itinerarios[i].id ==   idItinerario  )
                {
                    console.log(": "+ itinerarios[i].fechaFin);
                    return itinerarios[i].fechaFin;
                }
            }
        };
      

       this.borrarItinerario = function(idItinerario)
       {
           console.log(" BORRA EL ITINERARIO  p");
             for(var i=0;i< itinerarios.length;i++)
            {
                if(  itinerarios[i].id ==   idItinerario  )
                {
                    console.log(" BORRA EL ITINERARIO "+ idItinerario);
                    itinerarios.splice(i,1);
                }
            }
       };
       
       this.guardarItineario = function(idItinerario,ciudades,eventos,puntos ,hoteles,nombreItinerario,fechaInicio,fechaFinal)
       {
           console.log("Entraaaaaaaaaaaaaaaaaaaaaaaaaaaa GUardar");
           var entro = false;
           
           for(var i=0;i< itinerarios.length && entro == false ;i++)
            {
                if(  itinerarios[i].id ==   idItinerario  )
                {
                    entro = true;
                    console.log("Entraaaaaaaaaaaaaaaaaaaaaaaaaaaa GUardar YA EXISTIA");
                    
                    var itin = {id: idItinerario, nombre: nombreItinerario, fechaIni:fechaInicio,
                                        fechaFin: fechaFinal, ciudades:ciudades, 
                                        eventos:eventos, hoteles:hoteles,puntos: puntos};
                    itinerarios.splice(i,1)
                    itinerarios.splice(i,0,itin);
                }
            }
            if(entro == false)
            {
                    var itin = {id: idItinerario, nombre: nombreItinerario, fechaIni:fechaInicio,
                                        fechaFin: fechaFinal, ciudades:ciudades, 
                                        eventos:eventos, hoteles:hoteles,puntos: puntos};
                    itinerarios.splice(itinerarios.length,0, itin);
            }
       }


       
   }
    ]);
})(window.angular);
