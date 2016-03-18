/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng)
{
var mod = ng.module("AppItinerario");
mod.service('itinerarioSVC', ["$http" ,function ($http)
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
       
    this.darItinerario = function(idPerfil, idItinerario)
    {
        console.log("http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/{idPerfil}/itinerarios/{idIt}");
        //return null;
        
        return $http.get
        ("http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/"+idPerfil +"/itinerarios/"+idItinerario);

       // ctrllIti.$scope.setFechaFin();
        //ctrllIti.$scope.setFechaIni();
        //ctrllIti.$scope.setNombre();
    };
    this.crearActualizarItinerario = function(idDueño, itinerario)
    {
        console.log("http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/0/createIt");
        //devuelve el itinerario creado
        return $http.post("http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/"+idDueño+"/createIt" , itinerario);
    };
    this.borrarItinerario = function(idPerfil , idItEliminar)
    {
        console.log("http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/0/eliminarItinerario/0");
        
        $http.delete("http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/"+idPerfil+"/eliminarItinerario/"+idItEliminar);
    };
    
       
       
        /*this.darCiudades = function(idItinerario)
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
       }*/
       

       
   }
    ]);
})(window.angular);
