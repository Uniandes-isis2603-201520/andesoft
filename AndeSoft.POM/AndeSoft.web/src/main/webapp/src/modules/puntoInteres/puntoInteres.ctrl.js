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
    
            $scope.currentRecord = {
                id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                nombre: '' /*Tipo String*/,
                fechaSalida: '' /*Tipo String*/,
                fechaLlegada: ''
            };
            
            $scope.records = [];
            $scope.alerts = [];
            
            $scope.salida='Juan';
            
            $scope.today = function () {
                $scope.value = new Date();
            };

            $scope.clear = function () {
                $scope.value = null;
            };

            $scope.open = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.opened = true;
            };

            //Alertas
            this.closeAlert = function (index) {
                $scope.alerts.splice(index, 1);
            };

            function showMessage(msg, type) {
                var types = ["info", "danger", "warning", "success"];
                if (types.some(function (rc) {
                    return type === rc;
                })) {
                    $scope.alerts.push({type: type, msg: msg});
                }
            }

            this.showError = function (msg) {
                showMessage(msg, "danger");
            };

            var self = this;
            function responseError(response) {
                self.showError(response.data);
            }

            //Variables para el controlador
            this.readOnly = false;
            this.editMode = false;

            this.changeTab = function (tab) {
                $scope.tab = tab;
            };

            //Ejemplo alerta
            showMessage("Bienvenido!, Esto es un ejemplo para mostrar un mensaje de atención", "warning");


            this.createRecord = function () {
                this.editMode = true;
                $scope.currentRecord = {};
                $scope.$broadcast("post-create", $scope.currentRecord);
            };

            this.editRecord = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    self.editMode = true;
                    $scope.$broadcast("post-edit", $scope.currentRecord);
                    return response;
                }, responseError);
            };

            this.fetchRecords = function () {
                return svc.fetchRecords().then(function (response) {
                   // console.log("Se recupero el "+response.data[0].nombre);
                    $scope.records = response.data;
                    console.log("Se recupero a "+ $scope.records[0].nombre);
                    $scope.currentRecord = {};
                    self.editMode = false;
                    return response;
                }, responseError);
            };
            
            this.saveRecord = function () {
                return svc.saveRecord($scope.currentRecord).then(function () {
                    self.fetchRecords();
                }, responseError);
            };
            this.deleteRecord = function (record) {
                return svc.deleteRecord(record.id).then(function () {
                    self.fetchRecords();
                }, responseError);
            };

            this.fetchRecords();


//        $scope.data = [{
//        id:1,
//        itinerario: "Itinerario1",
//        ciudades: [{id:'bog',nombre:"Bogota",
//        puntos:["Plaza de Bolivar","Maloca"]
//        },
//        {id:'med',nombre:"Medellin",
//        puntos:["Metro","Estadio Metropolitano"]
//        }
//                  ]},
//        {
//        id:2,
//        itinerario: "Itinerario2",
//        ciudades: [{nombre:"Londres",
//        puntos:["big ben","Teatro de los sueños"]
//        }]}
//
//        ];
    
        $scope.selectedCity = null;
        $scope.selectedItinerario = null;
        $scope.selectedPunto = null;
        
        $scope.puntosInteres=['Machu Pichu'];
        
      //  $scope.ciudades =  svc.darItinerario();
//        $scope.newCiudad = function ()
//        {
//           svc.agregarCiudad({nombre:$scope.nombreCiudad, fechaInicio: $scope.fechaInicio, fechaFinal:$scope.fechaFinal});
//        //$scope.ciudades.push({nombre:$scope.nombreCiudad, fechaInicio: $scope.fechaInicio, fechaFinal:$scope.fechaFinal});
//
//        console.log($scope.ciudades[0].nombre);
//        $scope.nombreCiudad="";
//	$scope.fechaInicio="";
//	$scope.fechaFinal="";
//        $scope.ciudades =  svc.darItinerario();
//        };

//        $scope.nuevoPunto = function ()
//        {
//            if($scope.selectedPunto!=null){
//            $scope.puntosInteres.push($scope.selectedPunto);
//            $scope.selectedCity = null;
//            $scope.selectedItinerario = null;
//            $scope.selectedPunto = null;
//            }
//            
//        };

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

