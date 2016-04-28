(function(ng)
{
var mod = ng.module("AppCiudad");
mod.service("hotelSVC", ["$http", "contextoHotel",function ($http, context)
   {
       var hotel = [];

        this.fetchRecords = function () {
               console.log("Se recupero"+$http.get(context));
                return $http.get(context);
            };

            /**
             * Obtener un registro de authors.
             * Hace una petición GET a /authors/:id para obtener
             * el objeto de un registro específico de authors
             * @param {number} id del registro a obtener
             * @returns {promise} promise para leer la respuesta del servidor.
             * Se recibe un objeto instancia de authors.
             */
            this.fetchRecord = function (id) {
                return $http.get(context + "/" + id);
            };

            /**
             * Guardar un registro de authors.
             * Si currentRecord tiene la propiedad id, hace un PUT a /authors/:id con los
             * nuevos datos de la instancia de authors.
             * Si currentRecord no tiene la propiedad id, se hace un POST a /authors
             * para crear el nuevo registro de authors
             * @param {object} currentRecord instancia de authors a guardar/actualizar
             * @returns {promise} promise para leer la respuesta del servidor.
             * Se recibe un objeto de authors con su nuevo id
             */
            this.saveRecord = function (currentRecord) {
                if (currentRecord.id) {
                    return $http.put(context + "/" + currentRecord.id, currentRecord);
                } else {
                    return $http.post(context, currentRecord);
                }
            };

            /**
             * Hace una petición DELETE a /authors/:id para eliminar un author
             * @param {number} id identificador de la instancia de author a eliminar
             * @returns {promise} promise para leer la respuesta del servidor.
             * No se recibe cuerpo en la respuesta.
             */
            this.deleteRecord = function (id) {
                return $http.delete(context + "/" + id);
            };


//        this.fetchRecords = function () {
//            console.log("Entro a fetch records service");
//                return $http.get(context);
//            };

       this.agregarHotel = function (hotel) {

           /*if (ciudad.nombre) {
                   return $http.post(context, ciudad);
                } else {
                    return $http.post(context, ciudad);
                }
           */
          console.log("El contexto es " + context);
          return $http.post(context,hotel);
            };

/*
       this.agregarCiudad = function(ciudad)
       {
           console.log("entra a metodo agregar ciudad Servicio");

           itinerario.push(ciudad);
       };
       */

       this.borrarHotel = function(hotel)
       {
           console.log(ciudad + "que e es es o "+ hotel.nombre)

                return $http.delete(context + "/" + hotel);
       };

       this.darHotel= function()
        {
           return hotel;
       };

   }
    ]);
})(window.angular);

