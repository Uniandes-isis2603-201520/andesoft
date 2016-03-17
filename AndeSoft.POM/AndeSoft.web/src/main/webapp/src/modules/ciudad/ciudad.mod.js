/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng){

var appCiudad = ng.module('AppCiudad',["ui.bootstrap"]);
appCiudad.constant("contextoCiudad", "http://localhost:8080/AndeSoft.web/api/ciudades");

})(window.angular);