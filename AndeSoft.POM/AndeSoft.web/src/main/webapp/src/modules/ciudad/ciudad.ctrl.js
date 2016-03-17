/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng)
{
    var mod = ng.module("AppCiudad");
  mod.controller('ciudadCtrl', ['$scope','ciudadSVC','itinerarioSVC', function ($scope,svc,svcItinerario){
    //Acordarse que estas variables no son universales, falta implementar
    //un servicio que las vuelvas de este carácter
     //   $scope.ciudades =  svc.darItinerario();
 var self = this;
         $scope.ciudad= {};
         $scope.ciudades = [];


       //  console.log(itId);


      /*  $scope.newCiudad = function ()
        {
           svc.agregarCiudad({nombre:$scope.nombreCiudad, fechaInicio: $scope.fechaInicio, fechaFinal:$scope.fechaFinal});
        $scope.ciudades.push({nombre:$scope.nombreCiudad, fechaInicio: $scope.fechaInicio, fechaFinal:$scope.fechaFinal});

        console.log($scope.ciudades[0].nombre);
        $scope.nombreCiudad="";
	$scope.fechaInicio="";
	$scope.fechaFinal="";
        $scope.ciudades =  svc.darItinerario();
        };
          */


        $scope.newCiudad = function () {





            console.log("Entra a new ciudad " +$scope.ciudad.name + "EL ID es " + $scope.ciudad.idd);

                $scope.ciudad.ID =svcItinerario.darIdItinerarioActual();
                return svc.agregarCiudad($scope.ciudad).then(function () {

                    self.fetchRecords();
                }, "responseError");

                $scope.ciudad={};
            };


this.fetchRecords = function () {
    console.log("Entro a fetchrecords ctrl");
                return svc.fetchRecords().then(function (response) {
                    console.log("llamo a svc.fetch "+ response.data);
                    $scope.ciudades = response.data;
                    $scope.ciudad = {};

                    return response;
                }, responseError);
            };


        $scope.borrar = function()
        {
            console.log("ciudad seleccionada " + $scope.ciudadSeleccionada.name );
            //var temp = $scope.ciudadSeleccionada;
            svc.borrarCity($scope.ciudadSeleccionada.name);
            //var indice = $scope.ciudades.indexOf($scope.ciudadSeleccionada);
            //$scope.ciudades.splice(indice,1);
            self.fetchRecords();
        };

          function responseError(response) {
                self.showError(response.data);
            }

this.fetchRecords();
}]);




})(window.angular);

