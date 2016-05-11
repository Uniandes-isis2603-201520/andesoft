(function(ng)
{
var mod = ng.module("AppEvento");
mod.service('eventoSVC', ["$http", "contextoEvento",function ($http, context)
   {
       
       this.darLog= function()
        {
           return this.logueado;
       };

       this.cambiarLog=function(){
           this.logueado=true;
          console.log("hola"+this.logueado);
       };

       this.logout=function(){
           this.logueado=false;
          console.log("hola"+this.logueado);
       };
       //-----------------------------------------------------------------------
       
       
       this.fetchRecords = function () 
       {
           return $http.get(context);
       };
        
       this.fetchRecord = function (id)   
       {
            return $http.get(context + "/" + id);
       };
       
       this.saveRecord = function(currentRecord)
       {
            if (currentRecord.id) {
                    return $http.put(context + "/" + currentRecord.id, currentRecord);
                } else {
                    return $http.post(context, currentRecord);
                }
       };

       this.deleteRecord = function (id) {
                return $http.delete(context + "/" + id);
            };

   }
    ]);
})(window.angular);

