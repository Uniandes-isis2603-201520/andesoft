/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng)
{
    var mod = ng.module("SesionModule");
  mod.controller('sesionCtrl', ['$scope','sesionService',
      function ($scope,svc){
    //Acordarse que estas variables no son universales, falta implementar
    //un servicio que las vuelvas de este carácter
        $scope.scopeHeader = "Itinerario";
            var vm = this;
            $scope.login;
            $scope.log = false;

            $scope.darLogin= function(){
                //console.log("dar"+$scope.login);
               return svc.darLog();
            };
            $scope.cambiarLog=function() {
            // reset login status

            svc.cambiarLog();
           // console.log($scope.login);
            };

             $scope.logout=function() {
            // reset login status

            svc.logout();
           // console.log($scope.login);
            };

           }
        
        

]);




})(window.angular);

