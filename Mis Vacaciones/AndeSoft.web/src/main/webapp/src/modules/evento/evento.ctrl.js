/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng)
{
    var mod = ng.module("AppEvento");
  mod.controller('eventoCtrl', ['$scope','eventoSVC','itinerarioSVC', function ($scope,svc, svcItinerario){
        $scope.eventos =  svc.darListaEventos();
        $scope.newEvento = function ()
        {
           svc.agregarEvento({id:$scope.id,nombre:$scope.nombreEvento, fechaInicio: $scope.fechaInicio, fechaFinal:$scope.fechaFinal
           });
           //svcItinerario.agregarEventoaItinerario();
        console.log($scope.eventos[0].nombre);
        $scope.id="";
        $scope.nombreEvento="";
	$scope.fechaInicio="";
	$scope.fechaFinal="";
        $scope.eventos =  svc.darListaEventos();
        };



        $scope.borrar = function()
        {
            svc.borrarEvento($scope.eventoSeleccionada);
            $scope.eventos =  svc.darItinerario();
        };


}]);




})(window.angular);

