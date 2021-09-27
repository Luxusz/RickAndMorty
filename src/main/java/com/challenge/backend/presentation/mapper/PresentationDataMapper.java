package com.challenge.backend.presentation.mapper;

import com.challenge.backend.domain.entity.CharacterResponseEntity;
import com.challenge.backend.domain.entity.OriginResponseEntity;
import com.challenge.backend.presentation.model.CharacterFullInfo;
import com.challenge.backend.presentation.model.Origin;
import org.springframework.stereotype.Component;
/**
 * @author Francisco
 *
 */
@Component
public class PresentationDataMapper {

    public CharacterFullInfo convertToRootModel(CharacterResponseEntity characterResponseEntity){
        CharacterFullInfo characterFullInfo = new CharacterFullInfo();
        if(characterResponseEntity!=null){
            characterFullInfo.setId(characterResponseEntity.getId());
            characterFullInfo.setName(characterResponseEntity.getName());
            characterFullInfo.setStatus(characterResponseEntity.getStatus());
            characterFullInfo.setSpecies(characterResponseEntity.getSpecies());
            characterFullInfo.setType(characterResponseEntity.getType());
            characterFullInfo.setEpisodeCount(characterResponseEntity.getEpisodeCount());
            characterFullInfo.setOrigin(getOrigin(characterResponseEntity.getOrigin()));
        }
        return characterFullInfo;
    }

    private Origin getOrigin(OriginResponseEntity originResponseEntity){
        Origin origin = new Origin();
        if(originResponseEntity!=null) {
            origin.setDimension(originResponseEntity.getDimension());
            origin.setName(originResponseEntity.getName());
            origin.setUrl(originResponseEntity.getUrl());
            origin.setResidents(originResponseEntity.getResidents());
        }
        return  origin;
    }

}
