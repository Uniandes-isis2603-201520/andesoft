
(function(ng)
{
    var mod = ng.module("AppEvento");
    
    mod.controller('eventoCtrl', ['$scope','eventoSVC','itinerarioSVC', function ($scope,svc, svcItinerario){
            
        $scope.alerts =[];
        
        $scope.currentRecord = {
            id: undefined,
            nombre: '',
            fechaInicio: '',
            fechaFinal: '',
            ciudad:{}
        };
        
        $scope.records = [];
        
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

        // Función showMessage: Recibe el mensaje en String y su tipo con el fin de almacenarlo en el array $scope.alerts.
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

            this.showSuccess = function (msg) {
                showMessage(msg, "success");
            };

            var self = this;
            function responseError(response) {
                self.showError(response.data);
            }

            //Variables para el controlador
            this.readOnly = false;
            this.editMode = false;
            
        
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
                    $scope.records = response.data;
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
            
            function updateCiudad(event, args) {
                $scope.currentRecord.ciudad = args;
            }
            ;

            $scope.$on('updateCiudad', updateCiudad);

}]);




})(window.angular);

