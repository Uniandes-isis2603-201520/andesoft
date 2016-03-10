/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng)
{
    var mod = ng.module("AppPuntoInteres");
  mod.controller('puntoInteresCtrl', ['$scope','puntoInteresSVC', function ($scope,svc){
    //Acordarse que estas variables no son universales, falta implementar
    //un servicio que las vuelvas de este carácter
    
//    $scope.items = [{
//        id: 1,
//        label: 'aLabel',
//        subItem: { name: 'aSubItem' }
//      }, {
//        id: 2,
//        label: 'bLabel',
//        subItem: { name: 'bSubItem' }
//      }];

        $scope.data = [{
        id:1,
        itinerario: "Itinerario1",
        ciudades: [{id:'bog',nombre:"Bogota",
        puntos:["Plaza de Bolivar","Maloca"]
        },
        {id:'med',nombre:"Medellin",
        puntos:["Metro","Estadio Metropolitano"]
        }
                  ]},
        {
        id:2,
        itinerario: "Itinerario2",
        ciudades: [{nombre:"Londres",
        puntos:["big ben","Teatro de los sueños"]
        }]}

        ];
    
        $scope.selectedCity = null;
        $scope.selectedItinerario = null;
        $scope.selectedPunto = null;
        
        $scope.puntosInteres=['Machu Pichu'];
        
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

        $scope.nuevoPunto = function ()
        {
            if($scope.selectedPunto!=null){
            $scope.puntosInteres.push($scope.selectedPunto);
            $scope.selectedCity = null;
            $scope.selectedItinerario = null;
            $scope.selectedPunto = null;
            }
            
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

