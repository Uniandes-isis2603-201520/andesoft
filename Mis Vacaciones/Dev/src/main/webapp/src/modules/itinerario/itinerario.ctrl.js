/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng)
{
    var mod = ng.module("AppItinerario");
  mod.controller('itinerarioCtrl', function ($scope){
    //Acordarse que estas variables no son universales, falta implementar
    //un servicio que las vuelvas de este carácter
        $scope.ciudades =  [];
        $scope.newCiudad = function ()
        {

        $scope.ciudades.push({nombre:$scope.nombreCiudad, fechaInicio: $scope.fechaInicio, fechaFinal:$scope.fechaFinal});
           console.log($scope.ciudades[0].value);
        $scope.nombreCiudad="";
	$scope.fechaInicio="";
	$scope.fechaFinal="";

        };



        $scope.borrar = function()
        {
            var indice = $scope.ciudades.indexOf($scope.ciudadSeleccionada);
            $scope.ciudades.splice(indice,1);
        };


});




})(window.angular);

