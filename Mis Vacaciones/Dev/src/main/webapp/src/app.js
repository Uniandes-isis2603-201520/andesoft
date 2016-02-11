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
            $urlRouterProvider.otherwise("/Andesoft");
            $stateProvider
                    .state('Andesoft',{
                        url:'/Andesoft',
//                        controller: "AndesoftCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/Andesoft/index.html"
                    })
                    .state('itinerario',{
                        url:'/itinerario',
//                        controller: "itinerarioCtrl",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/itinerario/misItinerarios.html"
                    });
    }]);
})(window.angular);


