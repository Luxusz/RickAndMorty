package com.challenge.backend.mapper;

import com.challenge.backend.model.Character;
import com.challenge.backend.model.Location;
import com.challenge.backend.model.Origin;
import com.challenge.backend.model.Root;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapper {

    public Root convertToRootModel(Character character, Location location){
        Root root = new Root();
        if(character!=null){
            root.setId(character.getId());
            root.setName(character.getName());
            root.setStatus(character.getStatus());
            root.setSpecies(character.getSpecies());
            root.setType(character.getType());
            root.setEpisodeCount(character.getEpisode().size());
            root.setOrigin(convertToRootOriginModel(location));
        }
        return root;
    }

    private Origin convertToRootOriginModel(Location location){
        Origin origin = new Origin();
        origin.setName(location.getName());
        origin.setUrl(location.getUrl());
        origin.setDimension(location.getDimension());
        origin.setResidents(location.getResidents());
        return origin;
    }
}
