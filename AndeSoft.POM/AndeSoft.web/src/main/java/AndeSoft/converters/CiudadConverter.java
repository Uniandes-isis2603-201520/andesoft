/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.converters;

import AndeSoft.rest.dtos.ciudadDTO;
import andesoft.entities.CiudadEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e.galvis10
 */
public abstract class CiudadConverter {

    private CiudadConverter() {

    }

     public static List<CiudadEntity> listDTO2Entity(List<ciudadDTO> dtos) {
        List<CiudadEntity> entities = new ArrayList<CiudadEntity>();
        if (dtos != null) {
            for (ciudadDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

     public static List<ciudadDTO> listEntity2DTO(List<CiudadEntity> entities) {
        List<ciudadDTO> dtos = new ArrayList<ciudadDTO>();
        if (entities != null) {
            for (CiudadEntity entity : entities) {
                dtos.add(fullEntity2DTO(entity));
            }
        }
        return dtos;
    }

     public static CiudadEntity fullDTO2Entity(ciudadDTO dto) {
        CiudadEntity entity = basicDTO2Entity(dto);
        return entity;
    }

       public static ciudadDTO fullEntity2DTO(CiudadEntity entity) {
        ciudadDTO dto = basicEntity2DTO(entity);
        return dto;
    }

        public static ciudadDTO basicEntity2DTO(CiudadEntity entity) {
        if (entity != null) {
            ciudadDTO dto = refEntity2DTO(entity);

            return dto;
        } else {
            return null;
        }
    }

         public static CiudadEntity refDTO2Entity(ciudadDTO dto) {
        if (dto != null) {
            CiudadEntity entity = new CiudadEntity();
            entity.setId(dto.getID());

            return entity;
        } else {
            return null;
        }
    }

         public static ciudadDTO refEntity2DTO(CiudadEntity entity) {
        if (entity != null) {
            ciudadDTO dto = new ciudadDTO();
            dto.setID(entity.getID());
            dto.setName(entity.getName());
            dto.setFechaInicio(entity.getFechaInicio());
            dto.setFechaFinal(entity.getFechaFinal());

            return dto;
        } else {
            return null;
        }
    }

     public static CiudadEntity basicDTO2Entity(ciudadDTO dto) {
        if (dto != null) {
            CiudadEntity entity = new CiudadEntity();
            entity.setID(dto.getID());
            entity.setFechaInicio(dto.getFechaFinal());
            entity.setFechaFinal(dto.getFechaFinal());
            entity.setName(dto.getName());

            return entity;
        } else {
            return null;
        }
    }



}



