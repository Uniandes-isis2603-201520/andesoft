(function (ng) {
    var mod = ng.module("AppEvento",["ui.bootstrap","ngMessages"]);
    
    mod.constant("contextoEvento", "api/eventos");
})(window.angular);