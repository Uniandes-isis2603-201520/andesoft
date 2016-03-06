/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('MainController', ['$scope', 'api', function($scope, api) {

  api.success(function(data){
    $scope.datos = data;});


}]);

