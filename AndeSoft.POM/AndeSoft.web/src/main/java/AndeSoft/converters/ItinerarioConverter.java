package AndeSoft.converters;

import AndeSoft.rest.dtos.ItinerarioDTO;
import AndeSoft.rest.dtos.PuntoInteresDTO;
import andesoft.entities.ItinerarioEntity;
import andesoft.entities.PuntoInteresEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class ItinerarioConverter 
{

    /**
     * Constructor privado para evitar la creación del constructor implícito de Java
     * @generated
     */
    private ItinerarioConverter() {
    }

    /**
     * Realiza la conversión de AuthorEntity a AuthorDTO.
     * Se invoca cuando otra entidad tiene una referencia a AuthorEntity.
     * Entrega únicamente los atributos proprios de la entidad.
     *
     * @param entity instancia de AuthorEntity a convertir
     * @return instancia de AuthorDTO con los datos recibidos por parámetro
     * @generated
     */
    public static ItinerarioDTO refEntity2DTO(ItinerarioEntity entity)
    {
        if (entity != null)
        {
            ItinerarioDTO dto = new ItinerarioDTO();
            dto.setId(entity.darId());
            dto.setIdDueño(UsuarioConverter.fullEntity2DTO(entity.darIdUsuarioDueño()));
            dto.setNom(entity.darNombre());
            dto.setFechaIni(entity.darFechaIni());
            dto.setFechaFin(entity.darFechaFin());
         //   dto.setCiudades(entity.getCiudades());
            dto.setCiudades(CiudadConverter.listEntity2DTO(entity.getCiudades()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Realiza la conversión de AuthorDTO a AuthorEntity Se invoca cuando otro DTO
     * tiene una referencia a AuthorDTO Convierte únicamente el ID ya que es el
     * único atributo necesario para guardar la relación en la base de datos
     *
     * @param dto instancia de AuthorDTO a convertir
     * @return instancia de AuthorEntity con los datos recibidos por parámetro
     * @generated
     */
    public static ItinerarioEntity refDTO2Entity(ItinerarioDTO dto) {
        if (dto != null) 
        {
            
            ItinerarioEntity entity = new ItinerarioEntity();
            entity.setId(dto.darId());
            entity.setIdUsuarioDueño(    UsuarioConverter.fullDTO2Entity(dto.darIdUsuarioDueño()));
            entity.setNom(entity.darNombre());
            entity.setFechaIni(entity.darFechaIni());
            entity.setFechaFin(entity.darFechaFin());
         //   dto.setCiudades(entity.getCiudades());
            entity.setCiudades(CiudadConverter.listDTO2Entity(dto.darCiudades()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de AuthorEntity a AuthorDTO Se invoca cuando se desea
     * consultar la entidad y sus relaciones muchos a uno o uno a uno
     *
     * @param entity instancia de AuthorEntity a convertir
     * @return Instancia de AuthorDTO con los datos recibidos por parámetro
     * @generated
     */
    private static PuntoInteresDTO basicEntity2DTO(PuntoInteresEntity entity) {
        if (entity != null) {
            PuntoInteresDTO dto = new PuntoInteresDTO();
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setFechaLlegada(entity.getFechaLlegada());
            dto.setFechaSalida(entity.getFechaSalida());


            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de AuthorDTO a AuthorEntity Se invoca cuando se
     * necesita convertir una instancia de AuthorDTO con los atributos propios de
     * la entidad y con las relaciones uno a uno o muchos a uno
     *
     * @param dto instancia de AuthorDTO a convertir
     * @return Instancia de AuthorEntity creada a partir de los datos de dto
     * @generated
     */
    private static PuntoInteresEntity basicDTO2Entity(PuntoInteresDTO dto) {
        if (dto != null) {
            PuntoInteresEntity entity = new PuntoInteresEntity();
            entity.setId(dto.getId());
            entity.setNombre(dto.getNombre());
            entity.setFechaLlegada(dto.getFechaLlegada());
            entity.setFechaSalida(dto.getFechaSalida());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte instancias de AuthorEntity a AuthorDTO incluyendo sus relaciones
     * Uno a muchos y Muchos a muchos
     *
     * @param entity Instancia de AuthorEntity a convertir
     * @return Instancia de AuthorDTO con los datos recibidos por parámetro
     * @generated
     */
    public static PuntoInteresDTO fullEntity2DTO(PuntoInteresEntity entity) {
        if (entity != null) {
            PuntoInteresDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de AuthorDTO a AuthorEntity.
     * Incluye todos los atributos de AuthorEntity.
     *
     * @param dto Instancia de AuthorDTO a convertir
     * @return Instancia de AuthorEntity con los datos recibidos por parámetro
     * @generated
     */
    public static PuntoInteresEntity fullDTO2Entity(PuntoInteresDTO dto) {
        if (dto != null) {
            PuntoInteresEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una colección de instancias de AuthorEntity a AuthorDTO. Para cada
     * instancia de AuthorEntity en la lista, invoca basicEntity2DTO y añade el
     * nuevo AuthorDTO a una nueva lista
     *
     * @param entities Colección de entidades a convertir
     * @return Collección de instancias de PuntoInteresDTO
     * @generated
     */
    public static List<ItinerarioDTO> listEntity2DTO(List<ItinerarioEntity> entities) {
        
        List<ItinerarioDTO> itinerarioL = new ArrayList<ItinerarioDTO>();
        if (entities != null) {
                for(int i=0;i< entities.size();i++)
                {
                     itinerarioL.add(ItinerarioConverter.refEntity2DTO(entities.get(i)));
                }
        }
        //System.out.println("dto: "+dtos.get(0).getNombre());
        return itinerarioL;
    }

    /**
     * Convierte una colección de instancias de AuthorDTO a instancias de
     * AuthorEntity Para cada instancia se invoca el método basicDTO2Entity
     *
     * @param dtos entities Colección de AuthorDTO a convertir
     * @return Collección de instancias de AuthorEntity
     * @generated
     */
    public static List<PuntoInteresEntity> listDTO2Entity(List<PuntoInteresDTO> dtos) {
        List<PuntoInteresEntity> entities = new ArrayList<PuntoInteresEntity>();
        if (dtos != null) {
            for (PuntoInteresDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
