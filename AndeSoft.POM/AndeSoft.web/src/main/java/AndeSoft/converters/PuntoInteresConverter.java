package AndeSoft.converters;

import AndeSoft.rest.dtos.PuntoInteresDTO;
import andesoft.entities.PuntoInteresEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class PuntoInteresConverter {

    /**
     * Constructor privado para evitar la creación del constructor implícito de Java
     * @generated
     */
    private PuntoInteresConverter() {
    }

    /**
     * Realiza la conversión de PuntoInteresEntity a PuntoInteresDTO.
     * Se invoca cuando otra entidad tiene una referencia a PuntoInteresEntity.
     * Entrega únicamente los atributos proprios de la entidad.
     *
     * @param entity instancia de PuntoInteresEntity a convertir
     * @return instancia de PuntoInteresDTO con los datos recibidos por parámetro
     * @generated
     */
    public static PuntoInteresDTO refEntity2DTO(PuntoInteresEntity entity) {
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
     * Realiza la conversión de PuntoInteresDTO a PuntoInteresEntity Se invoca cuando otro DTO
     * tiene una referencia a PuntoInteresDTO Convierte únicamente el ID ya que es el
     * único atributo necesario para guardar la relación en la base de datos
     *
     * @param dto instancia de PuntoInteresDTO a convertir
     * @return instancia de PuntoInteresEntity con los datos recibidos por parámetro
     * @generated
     */
    public static PuntoInteresEntity refDTO2Entity(PuntoInteresDTO dto) {
        if (dto != null) {
            PuntoInteresEntity entity = new PuntoInteresEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de PuntoInteresEntity a PuntoInteresDTO Se invoca cuando se desea
     * consultar la entidad y sus relaciones muchos a uno o uno a uno
     *
     * @param entity instancia de PuntoInteresEntity a convertir
     * @return Instancia de PuntoInteresDTO con los datos recibidos por parámetro
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
     * Convierte una instancia de PuntoInteresDTO a PuntoInteresEntity Se invoca cuando se
     * necesita convertir una instancia de PuntoInteresDTO con los atributos propios de
     * la entidad y con las relaciones uno a uno o muchos a uno
     *
     * @param dto instancia de PuntoInteresDTO a convertir
     * @return Instancia de PuntoInteresEntity creada a partir de los datos de dto
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
     * Convierte instancias de PuntoInteresEntity a PuntoInteresDTO incluyendo sus relaciones
     * Uno a muchos y Muchos a muchos
     *
     * @param entity Instancia de PuntoInteresEntity a convertir
     * @return Instancia de PuntoInteresDTO con los datos recibidos por parámetro
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
     * Convierte una instancia de PuntoInteresDTO a PuntoInteresEntity.
     * Incluye todos los atributos de PuntoInteresEntity.
     *
     * @param dto Instancia de PuntoInteresDTO a convertir
     * @return Instancia de PuntoInteresEntity con los datos recibidos por parámetro
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
     * Convierte una colección de instancias de PuntoInteresEntity a PuntoInteresDTO. Para cada
     * instancia de PuntoInteresEntity en la lista, invoca basicEntity2DTO y añade el
     * nuevo PuntoInteresDTO a una nueva lista
     *
     * @param entities Colección de entidades a convertir
     * @return Collección de instancias de PuntoInteresDTO
     * @generated
     */
    public static List<PuntoInteresDTO> listEntity2DTO(List<PuntoInteresEntity> entities) {
        List<PuntoInteresDTO> dtos = new ArrayList<PuntoInteresDTO>();
        if (entities != null) {
            for (PuntoInteresEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * Convierte una colección de instancias de PuntoInteresDTO a instancias de
     * PuntoInteresEntity Para cada instancia se invoca el método basicDTO2Entity
     *
     * @param dtos entities Colección de PuntoInteresDTO a convertir
     * @return Collección de instancias de PuntoInteresEntity
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
