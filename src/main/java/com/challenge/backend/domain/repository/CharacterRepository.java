package com.challenge.backend.domain.repository;

import com.challenge.backend.domain.entity.CharacterEntity;

public interface CharacterRepository {

    CharacterEntity getInfo(String id) throws Exception;
}
