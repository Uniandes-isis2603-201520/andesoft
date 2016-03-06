/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.factory('api', ['$http', function($http) {
  return $http.get('http://terminal2.expedia.com/x/hotels?location=47.6063889,-122.3308333&radius=5km&dates=2016-05-19,2016-05-22&apikey=GOMDS6FdBGOEvT2WtlHeWJhusi4bvlHJ')
            .success(function(data) {
              return data;
            })
            .error(function(err) {
              return err;
            });
}]);
