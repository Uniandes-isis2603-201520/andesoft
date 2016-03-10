/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng)
{
    var mod = ng.module("AppMiPerfil");
    mod.controller('miPerfilCtrl',['$scope', 'miPerfilSVC', function($scope, svc){

            $scope.fotos = svc.darFotos();

            $scope.nuevaFoto = function ()
            {
                $scope.nombreFoto="";
                $scope.rutaFoto="";

                var foto =[$scope.nombreFoto, $scope.rutaFoto];
                svc.agregarFoto(foto);
            };

            $scope.eliminarFoto = function()
            {
                svc.borrarFoto($scope.fotoSeleccionada);
                $scope.fotos = svc.darFotos();
            };

    }]);
})(window.angular);

