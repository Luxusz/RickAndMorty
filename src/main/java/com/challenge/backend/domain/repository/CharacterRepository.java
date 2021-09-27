package com.challenge.backend.domain.repository;

import com.challenge.backend.data.entity.CharacterEntity;

public interface CharacterRepository {

    CharacterEntity getInfo(String id) throws Exception;
}
