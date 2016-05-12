/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @autor jg.tamura10
 */
(function(ng)
{
    var mod = ng.module("AppItinerario");
  mod.controller('itinerarioCtrl', ['$scope','itinerarioSVC', function ($scope,svc){
    //Acordarse que estas variables no son universales, falta implementar
    //un servicio que las vuelvas de este carácter
    
    
        $scope.verCiudades = false;
        $scope.verEventos = false;
        $scope.verPuntos = false;
        $scope.verHoteles = false;
        
        $scope.elementoSeleccionado = {};
        
        $scope.ciudades =  [];
        $scope.eventos =  [];
        $scope.puntos =  [];
        $scope.hoteles =  [];
       
        
        $scope.nombreItinerario = "";
        
	$scope.fechaInicio = "";
	$scope.fechaFinal = "";
       
        
        
        $scope.actualizarItinerario = function()// recuperar itinerario
        {
            console.log("Llegaaaa ");
            
            
            svc.darItinerario(0, $scope.nombreItinerario).
                then(function(response) 
        {
           $scope.nombreItinerario = response.data.nombreIt;
           $scope.fechaInicio = response.data.fechaIni;
           $scope.fechaFinal = response.data.fechaFin;
           
           svc.setIdItActual(response.data.id);
           
           console.log($scope.nombreItinerario + "    "+ $scope.fechaInicio + "    "+ $scope.fechaFinal);
           
            
        }, function myError(response) {
         console.log(response.statusText);
        });
            
           // $scope.ciudades =  svc.darCiudades($scope.idItinerario);
            //$scope.eventos =  svc.darEventos($scope.idItinerario);
            //$scope.puntos =  svc.darPuntos($scope.idItinerario);
            //$scope.hoteles =  svc.darHoteles($scope.idItinerario);


            //$scope.nombreItinerario= svc.darNombreItinerario($scope.idItinerario);
            //$scope.fechaInicio=svc.darFechaInicialItinerario($scope.idItinerario);
            //$scope.fechaFinal=svc.darFechaFinItinerario($scope.idItinerario);
            
        };
        
        
        $scope.borrarItinerario = function()
        {
            svc.borrarItinerario(0, $scope.nombreItinerario);
            //svc.setIdItActual(-1);
        };
        
        $scope.crearItinerario = function()
        {
            console.log("llega a crear itinerario");
            var currentItinerario = {
                nombreItinerario: $scope.nombreItinerario /*Tipo String*/,
                fechaIni : $scope.fechaInicio,
                fechaFin : $scope.fechaFinal
                //,ciudades: [actuales] 
            };
            
           console.log(currentItinerario);
            svc.crearItinerario(0, $scope.nombreItinerario,$scope.fechaInicio,$scope.fechaFinal, currentItinerario).
                then(function(response) 
        {
           $scope.nombreItinerario = response.data.nombreIt;
           console.log("termina de traer el itinerario guardado: "+ $scope.nombreItinerario);
           $scope.actualizarItinerario();
        }, function myError(response) {
         console.log(response.statusText);
        });
        };
        $scope.updateItinerario = function()
        {
            console.log("llega a crear o actualizar itinerario");
            var currentItinerario = {
                nombreItinerario: $scope.nombreItinerario /*Tipo String*/,
                fechaIni : $scope.fechaInicio,
                fechaFin : $scope.fechaFinal
                //,ciudades: [actuales] 
            };
            
           console.log(currentItinerario);
            svc.actualizarItinerario(0, $scope.nombreItinerario,$scope.fechaInicio,$scope.fechaFinal, currentItinerario).
                then(function(response) 
        {
           $scope.nombreItinerario = response.data.nombreIt;
           console.log("termina de traer el itinerario guardado: "+ $scope.nombreItinerario);
           $scope.actualizarItinerario();
        }, function myError(response) {
         console.log(response.statusText);
        });
        };
        
   
        
        
        $scope.mostrarCiudades = function()
        {
            $scope.verCiudades = true;
            $scope.verEventos = false;
            $scope.verPuntos = false;
            $scope.verHoteles = false;
        };
        $scope.mostrarEventos = function()
        {
            $scope.verCiudades = false;
            $scope.verEventos = true;
            $scope.verPuntos = false;
            $scope.verHoteles = false;
        };
        $scope.mostrarHoteles = function()
        {
            $scope.verCiudades = false;
            $scope.verEventos = false;
            $scope.verPuntos = false;
            $scope.verHoteles = true;
        };
        $scope.mostrarPuntos = function()
        {
            $scope.verCiudades = false;
            $scope.verEventos = false;
            $scope.verPuntos = true;
            $scope.verHoteles = false;
        };
        
        

}]);




})(window.angular);

