package AndeSoft.converters;

import AndeSoft.rest.dtos.ItinerarioDTO;
import andesoft.entities.ItinerarioEntity;
import andesoft.entities.UsuarioEntity;
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
            dto.setId(entity.getId());
         //   dto.setIdDueño(UsuarioConverter.fullEntity2DTO(entity.darIdUsuarioDueño()));
            dto.setNombreIt(entity.getNombre());
            dto.setFechaIni(entity.getFechaIni());
            dto.setFechaFin(entity.getFechaFin());
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
            UsuarioEntity user = UsuarioConverter.fullDTO2Entity(dto.getIdUsuarioDueño());
            entity.setUsuario(user);
            entity.setId(dto.getId());
           // entity.setIdUsuarioDueño(    UsuarioConverter.fullDTO2Entity(dto.darIdUsuarioDueño()));
            entity.setNom(dto.getNombreIt());
            entity.setFechaIni(dto.getFechaIni());
            entity.setFechaFin(dto.getFechaFin());
         //   dto.setCiudades(entity.getCiudades());
            entity.setCiudades(CiudadConverter.listDTO2Entity(dto.getCiudades()));

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
    private static ItinerarioDTO basicEntity2DTO(ItinerarioEntity entity) {
        if (entity != null) {
            ItinerarioDTO dto = new ItinerarioDTO();
            dto.setId(entity.getId());
            dto.setNombreIt(entity.getNombre());
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
    private static ItinerarioEntity basicDTO2Entity(ItinerarioDTO dto) {
        if (dto != null) {
            ItinerarioEntity entity = new ItinerarioEntity();
            entity.setId(dto.getId());
            entity.setNom(dto.getNombreIt());
            entity.setFechaFin(dto.getFechaFin());
            entity.setFechaIni(dto.getFechaIni());

            return entity;
        } else {
            return null;
        }
    }
    
    /**
     * Convierte una colecciÃ³n de instancias de AuthorEntity a AuthorDTO. Para cada
     * instancia de AuthorEntity en la lista, invoca basicEntity2DTO y aÃ±ade el
     * nuevo AuthorDTO a una nueva lista
     *
     * @param entities ColecciÃ³n de entidades a convertir
     * @return CollecciÃ³n de instancias de PuntoInteresDTO
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

}
