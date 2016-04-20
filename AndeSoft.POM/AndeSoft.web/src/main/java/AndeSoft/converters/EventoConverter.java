package AndeSoft.converters;

import AndeSoft.rest.dtos.EventoDTO;
import andesoft.entities.EventoEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class EventoConverter {

    /**
     * Constructor privado para evitar la creación del constructor implícito de Java
     * @generated
     */
    private EventoConverter() {
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
    public static EventoDTO refEntity2DTO(EventoEntity entity) {
        if (entity != null) {
            EventoDTO dto = new EventoDTO();
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setFechaInicio(entity.getFechaInicio());
            dto.setFechaFinal(entity.getFechaFinal());
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
    public static EventoEntity refDTO2Entity(EventoDTO dto) {
        if (dto != null) {
            EventoEntity entity = new EventoEntity();
            entity.setId(dto.getId());

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
    private static EventoDTO basicEntity2DTO(EventoEntity entity) {
        if (entity != null) {
            EventoDTO dto = new EventoDTO();
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setFechaInicio(entity.getFechaInicio());
            dto.setFechaFinal(entity.getFechaFinal());


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
    private static EventoEntity basicDTO2Entity(EventoDTO dto) {
        if (dto != null) {
            EventoEntity entity = new EventoEntity();
            entity.setId(dto.getId());
            entity.setNombre(dto.getNombre());
            entity.setFechaInicio(dto.getFechaInicio());
            entity.setFechaFinal(dto.getFechaFinal());

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
    public static EventoDTO fullEntity2DTO(EventoEntity entity) {
        if (entity != null) {
            EventoDTO dto = basicEntity2DTO(entity);
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
    public static EventoEntity fullDTO2Entity(EventoDTO dto) {
        if (dto != null) {
            EventoEntity entity = basicDTO2Entity(dto);
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
    public static List<EventoDTO> listEntity2DTO(List<EventoEntity> entities) {
        List<EventoDTO> dtos = new ArrayList<EventoDTO>();
        if (entities != null) {
            for (EventoEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        //System.out.println("dto: "+dtos.get(0).getNombre());
        return dtos;
    }

    /**
     * Convierte una colección de instancias de AuthorDTO a instancias de
     * AuthorEntity Para cada instancia se invoca el método basicDTO2Entity
     *
     * @param dtos entities Colección de AuthorDTO a convertir
     * @return Collección de instancias de AuthorEntity
     * @generated
     */
    public static List<EventoEntity> listDTO2Entity(List<EventoDTO> dtos) {
        List<EventoEntity> entities = new ArrayList<EventoEntity>();
        if (dtos != null) {
            for (EventoDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
