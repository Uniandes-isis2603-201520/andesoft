package AndeSoft.converters;

import AndeSoft.rest.dtos.UsuarioDTO;
import AndeSoft.rest.dtos.PuntoInteresDTO;
import andesoft.entities.UsuarioEntity;
import andesoft.entities.PuntoInteresEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class UsuarioConverter
{

    /**
     * Constructor privado para evitar la creación del constructor implícito de Java
     * @generated
     */
    private UsuarioConverter() {
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
    public static UsuarioDTO refEntity2DTO(UsuarioEntity entity)
    {
        if (entity != null)
        {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getNames());
            dto.setApellido(entity.getApellidos());
            dto.setUsuario(entity.getUsuario());
            dto.setCorreo(entity.getCorreo());
            dto.setPassword(entity.getPassword());


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
    public static UsuarioEntity refDTO2Entity(UsuarioDTO dto) {
        if (dto != null) {
            UsuarioEntity entity = new UsuarioEntity();
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
    private static UsuarioDTO basicEntity2DTO(UsuarioEntity entity) {
        if (entity != null) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getNames());
            dto.setApellido(entity.getApellidos());
            dto.setUsuario(entity.getUsuario());
             dto.setCorreo(entity.getCorreo());
              dto.setPassword(entity.getPassword());


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
    private static UsuarioEntity basicDTO2Entity(UsuarioDTO dto) {
        if (dto != null) {
            UsuarioEntity entity = new UsuarioEntity();
            entity.setId(dto.getId());
            entity.setames(dto.getName());
            entity.setApellidos(dto.getApellido());
            entity.setUsuario(dto.getUsuario());
            entity.setCorreo(dto.getCorreo());
            entity.setPassword(dto.getPassword());

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
    public static UsuarioDTO fullEntity2DTO(UsuarioEntity entity) {
        if (entity != null) {
            UsuarioDTO dto = basicEntity2DTO(entity);
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
    public static UsuarioEntity fullDTO2Entity(UsuarioDTO dto) {
        if (dto != null) {
           UsuarioEntity entity = basicDTO2Entity(dto);
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
    public static List<UsuarioDTO> listEntity2DTO(List<UsuarioEntity> entities) {
        List<UsuarioDTO> dtos = new ArrayList<UsuarioDTO>();
        if (entities != null) {
            for (UsuarioEntity entity : entities) {
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
    public static List<UsuarioEntity> listDTO2Entity(List<UsuarioDTO> dtos) {
        List<UsuarioEntity> entities = new ArrayList<UsuarioEntity>();
        if (dtos != null) {
            for (UsuarioDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
