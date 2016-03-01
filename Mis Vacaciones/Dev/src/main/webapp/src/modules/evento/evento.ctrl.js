/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng)
{
    var mod = ng.module("AppEvento");
  mod.controller('eventoCtrl', ['$scope','eventoSVC', function ($scope,svc){
    //Acordarse que estas variables no son universales, falta implementar
    //un servicio que las vuelvas de este carácter
        $scope.ciudades =  svc.darItinerario();
        $scope.newCiudad = function ()
        {
           svc.agregarCiudad({nombre:$scope.nombreCiudad, fechaInicio: $scope.fechaInicio, fechaFinal:$scope.fechaFinal});
        //$scope.ciudades.push({nombre:$scope.nombreCiudad, fechaInicio: $scope.fechaInicio, fechaFinal:$scope.fechaFinal});

        console.log($scope.ciudades[0].nombre);
        $scope.nombreCiudad="";
	$scope.fechaInicio="";
	$scope.fechaFinal="";
        $scope.ciudades =  svc.darItinerario();
        };



        $scope.borrar = function()
        {
            //var temp = $scope.ciudadSeleccionada;
            svc.borrarCity($scope.ciudadSeleccionada);
            //var indice = $scope.ciudades.indexOf($scope.ciudadSeleccionada);
            //$scope.ciudades.splice(indice,1);
            $scope.ciudades =  svc.darItinerario();
        };


}]);




})(window.angular);

