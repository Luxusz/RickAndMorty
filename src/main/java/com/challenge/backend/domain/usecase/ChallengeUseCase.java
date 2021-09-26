package com.challenge.backend.domain.usecase;

import com.challenge.backend.domain.entity.CharacterResponseEntity;

public interface ChallengeUseCase {

    CharacterResponseEntity getInfo(String id) throws Exception;
}
