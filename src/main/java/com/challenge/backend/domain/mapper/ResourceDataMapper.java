package com.challenge.backend.domain.mapper;

import com.challenge.backend.data.entity.CharacterEntity;
import com.challenge.backend.data.entity.LocationEntity;
import com.challenge.backend.domain.entity.CharacterResponseEntity;
import com.challenge.backend.domain.entity.OriginResponseEntity;
import org.springframework.stereotype.Component;
/**
 * @author Francisco
 *
 */
@Component
public class ResourceDataMapper {

    public CharacterResponseEntity convertToRootModel(CharacterEntity character, LocationEntity location){
        CharacterResponseEntity characterResponseEntity = new CharacterResponseEntity();
        if(character!=null){
            characterResponseEntity.setId(character.getId());
            characterResponseEntity.setName(character.getName());
            characterResponseEntity.setStatus(character.getStatus());
            characterResponseEntity.setSpecies(character.getSpecies());
            characterResponseEntity.setType(character.getType());
            characterResponseEntity.setEpisodeCount(character.getEpisode().size());
            characterResponseEntity.setOrigin(convertToRootOriginModel(location));
        }
        return characterResponseEntity;
    }

    private OriginResponseEntity convertToRootOriginModel(LocationEntity location){
        OriginResponseEntity origin = new OriginResponseEntity();
        if(location!=null) {
            origin.setName(location.getName());
            origin.setUrl(location.getUrl());
            origin.setDimension(location.getDimension());
            origin.setResidents(location.getResidents());
        }
        return origin;
    }
}
