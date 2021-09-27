package com.challenge.backend.dummyobjects;

import com.challenge.backend.data.entity.CharacterEntity;
import com.challenge.backend.data.entity.LocationEntity;
import com.challenge.backend.data.entity.OriginCharacterEntity;
import com.challenge.backend.domain.entity.CharacterResponseEntity;
import com.challenge.backend.domain.entity.OriginResponseEntity;
import com.challenge.backend.presentation.model.CharacterFullInfo;
import com.challenge.backend.presentation.model.Origin;

import java.util.ArrayList;

public class DummyObjects {

    public static CharacterEntity getCharacterEntity(){
        CharacterEntity entity = new CharacterEntity();
        entity.setCreated("");
        entity.setEpisode(new ArrayList());
        entity.setName("");
        entity.setId(1);
        entity.setSpecies("");
        entity.setUrl("");
        entity.setGender("");
        entity.setImage("");
        entity.setType("");
        entity.setOrigin(getOrigin());
        entity.setLocation(getOrigin());
        return entity;
    }

    public static OriginCharacterEntity getOrigin(){
        OriginCharacterEntity originCharacterEntity = new OriginCharacterEntity();
        originCharacterEntity.setName("unknown");
        originCharacterEntity.setUrl("http://localhost:8080");
        return originCharacterEntity;
    }

    public static LocationEntity getLocation(){
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setName("unknown");
        locationEntity.setId(2);
        locationEntity.setCreated("");
        locationEntity.setUrl("");
        locationEntity.setDimension("");
        locationEntity.setResidents(new ArrayList());
        return locationEntity;
    }

    public static CharacterResponseEntity getResponseEntity(){
        CharacterResponseEntity responseEntity = new CharacterResponseEntity();
        OriginResponseEntity originResponseEntity = new OriginResponseEntity();
        originResponseEntity.setName("unknown");
        responseEntity.setName("Rick Sanchez");
        responseEntity.setOrigin(originResponseEntity);
        return responseEntity;
    }

    public static CharacterFullInfo getFullInfo(){
        CharacterFullInfo fullInfo = new CharacterFullInfo();
        fullInfo.setId(1);
        fullInfo.setName("Rick Sanchez");
        fullInfo.setSpecies("");
        fullInfo.setEpisodeCount(5);
        fullInfo.setOrigin(new Origin());
        fullInfo.setStatus("");
        fullInfo.setType("");
        return fullInfo;

    }
}
