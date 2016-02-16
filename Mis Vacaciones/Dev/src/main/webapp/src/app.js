/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng){

    var mod = ng.module("mainApp",[
        "ui.router"
//        "AndesoftModule",
//        "itinerarioModule",
//        "loginModule"
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
                    .state('itinerario',{
                        url:'/itinerario',
//                        controller: "itinerarioCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/itinerario/misItinerarios.html"
                    });
    }]);
})(window.angular);


