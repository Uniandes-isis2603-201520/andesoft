/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng)
{
    var mod = ng.module("AppItinerario");
  mod.controller('itinerarioCtrl', ['$scope','itinerarioSVC', function ($scope,svc){
    //Acordarse que estas variables no son universales, falta implementar
    //un servicio que las vuelvas de este carácter
        $scope.idItinerario = 0;
    
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
        
        
        
        $scope.actualizarItinerario = function()
        {
            
            $scope.ciudades =  svc.darCiudades($scope.idItinerario);
            $scope.eventos =  svc.darEventos($scope.idItinerario);
            $scope.puntos =  svc.darPuntos($scope.idItinerario);
            $scope.hoteles =  svc.darHoteles($scope.idItinerario);


            $scope.nombreItinerario= svc.darNombreItinerario($scope.idItinerario);
            $scope.fechaInicio=svc.darFechaInicialItinerario($scope.idItinerario);
            $scope.fechaFinal=svc.darFechaFinItinerario($scope.idItinerario);
            
        };
        
        $scope.borrarItinerario = function()
        {
            svc.borrarItinerario($scope.idItinerario);
            
        };
        
        $scope.guardarItinerario = function()
        {
            svc.guardarItineario(
                    $scope.idItinerario,
                    $scope.ciudades,
                    $scope.eventos,
                    $scope.puntos ,
                    $scope.hoteles,
                    $scope.nombreItinerario,
                    $scope.fechaInicio,
                    $scope.fechaFinal);
            
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

