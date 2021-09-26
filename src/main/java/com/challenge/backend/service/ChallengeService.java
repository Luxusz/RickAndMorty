package com.challenge.backend.service;

import com.challenge.backend.model.Root;

public interface ChallengeService {

    Root getInfo(String id) throws Exception;
}
