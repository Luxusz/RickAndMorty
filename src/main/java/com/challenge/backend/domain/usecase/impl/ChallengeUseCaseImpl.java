package com.challenge.backend.domain.usecase.impl;

import com.challenge.backend.domain.entity.CharacterEntity;
import com.challenge.backend.domain.entity.CharacterResponseEntity;
import com.challenge.backend.domain.entity.LocationEntity;
import com.challenge.backend.domain.mapper.ResourceDataMapper;
import com.challenge.backend.domain.repository.CharacterRepository;
import com.challenge.backend.domain.repository.LocationRepository;
import com.challenge.backend.domain.usecase.ChallengeUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.challenge.backend.common.enumeration.LogTagEnum.TAG_SUCCESS_ENTITY;

@Service
@Log4j2
@Qualifier("challengeUseCase")
public class ChallengeUseCaseImpl implements ChallengeUseCase {

    private final CharacterRepository challengeRepository;
    private final LocationRepository locationRepository;
    private final ResourceDataMapper mapper;

    public ChallengeUseCaseImpl(CharacterRepository challengeRepository, LocationRepository locationRepository, ResourceDataMapper mapper) {
        this.challengeRepository = challengeRepository;
        this.locationRepository = locationRepository;
        this.mapper = mapper;
    }


    @Override
    public CharacterResponseEntity getInfo(String id) throws Exception {
        LocationEntity location;
        try{
            CharacterEntity character = challengeRepository.getInfo(id);
            if (!character.getOrigin().getUrl().isEmpty()) {
                location = locationRepository.getLocationInfo(character.getOrigin().getUrl());
            } else {
                location = new LocationEntity();
                location.setName(character.getOrigin().getName());
            }
            log.info(TAG_SUCCESS_ENTITY.getValue());
            return mapper.convertToRootModel(character, location);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new Exception();
        }

    }
}
