/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.converters;

import AndeSoft.rest.dtos.CiudadDTOf;
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

     public static List<CiudadEntity> listDTO2Entity(List<CiudadDTOf> dtos) {
        List<CiudadEntity> entities = new ArrayList<CiudadEntity>();
        if (dtos != null) {
            for (CiudadDTOf dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

     public static List<CiudadDTOf> listEntity2DTO(List<CiudadEntity> entities) {
        List<CiudadDTOf> dtos = new ArrayList<CiudadDTOf>();
        if (entities != null) {
            for (CiudadEntity entity : entities) {
                dtos.add(fullEntity2DTO(entity));
            }
        }
        return dtos;
    }

     public static CiudadEntity fullDTO2Entity(CiudadDTOf dto) {
        CiudadEntity entity = basicDTO2Entity(dto);
        return entity;
    }

       public static CiudadDTOf fullEntity2DTO(CiudadEntity entity) {
        if (entity != null) {
            CiudadDTOf dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

        public static CiudadDTOf basicEntity2DTO(CiudadEntity entity) {
        if (entity != null) {
            CiudadDTOf dto = new CiudadDTOf();
            dto.setId(entity.getId());
            dto.setNombre(entity.getName());
            dto.setFechaInicio(entity.getFechaInicio());
            dto.setFechaSalida(entity.getFechaFinal());
            

            return dto;
        } else {
            return null;
        }
    }

         public static CiudadEntity refDTO2Entity(CiudadDTOf dto) {
        if (dto != null) {
            CiudadEntity entity = new CiudadEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

         public static CiudadDTOf refEntity2DTO(CiudadEntity entity) {
        if (entity != null) {
            CiudadDTOf dto = new CiudadDTOf();
            dto.setId(entity.getId());
            dto.setNombre(entity.getName());
            dto.setFechaInicio(entity.getFechaInicio());
            dto.setFechaSalida(entity.getFechaFinal());

            return dto;
        } else {
            return null;
        }
    }

     public static CiudadEntity basicDTO2Entity(CiudadDTOf dto) {
        if (dto != null) {
            CiudadEntity entity = new CiudadEntity();
            entity.setId(dto.getId());
            entity.setFechaInicio(dto.getFechaInicio());
            entity.setFechaFinal(dto.getFechaSalida());
            entity.setName(dto.getNombre());

            return entity;
        } else {
            return null;
        }
    }



}



