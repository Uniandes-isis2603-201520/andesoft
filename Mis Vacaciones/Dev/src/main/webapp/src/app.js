
(function (ng){

    var mod = ng.module("mainApp",[
        "ui.router",
        "AppItinerario",
        "AppCiudad",
        "AppEvento",
        "AppHotel",
        "AppPuntoInteres"
//        "AndesoftModule",
//        "itinerarioModule",
//        "loginModule"
    ]);

//    var headerController = function($scope){
//    $scope.scopeHeader = "Itinerario";
//    var vm = this;
//    $scope.log = true;
//    };

    mod.controller("headerCtrl", ["$scope","itinerarioSVC",
           function($scope,svc) {
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


    mod.config(['$logProvider', function($logProvider){
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$stateProvider','$urlRouterProvider', function($stateProvider,$urlRouterProvider) {
            $urlRouterProvider.otherwise("/misVacaciones");
            $stateProvider
                    .state('misVacaciones',{
                        url:'/misVacaciones',
//                        controller: "AndesoftCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/principal/principal.tpl.html"
                    })
                    .state('equipo',{
                        url:'/equipo',
//                        controller: "AndesoftCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/Andesoft/Equipo.html"
                    })
                     .state('login',{
                        url:'/login',
//                        controller: "AndesoftCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/login/login.html"
                    })
                     .state('registro',{
                        url:'/registro',
//                        controller: "AndesoftCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/login/Registro.html"
                    })
                     .state('miPerfil',{
                        url:'/miPerfil',
//                        controller: "AndesoftCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/login/miPerfil.html"
                    })
                     .state('nuevoItinerario',{
                        url:'/nuevoItinerario',
//                        controller: "AndesoftCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/itinerario/nuevo.html"
                    })
                    .state('hotel',{
                        url:'/hotel',
//                        controller: "AndesoftCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/hotel/nuevo.html"
                    })
                     .state('evento',{
                        url:'/evento',
//                        controller: "AndesoftCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/evento/nuevo.html"
                    })
                    .state('ciudad',{
                        url:'/ciudad',
//                        controller: "AndesoftCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/ciudad/nuevo.html"
                    })
                    .state('puntoInteres',{
                        url:'/puntoInteres',
//                        controller: "AndesoftCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/puntoInteres/nuevo.html"
                    })
                    ;
    }]);
})(window.angular);


