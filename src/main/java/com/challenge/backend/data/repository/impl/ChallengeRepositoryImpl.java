package com.challenge.backend.data.repository.impl;

import com.challenge.backend.data.entity.CharacterEntity;
import com.challenge.backend.domain.repository.CharacterRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static com.challenge.backend.common.enumeration.LogTagEnum.TAG_SUCCESS_CHARACTER;

/**
 * @author Francisco
 *
 */
@Repository
@Log4j2
@Qualifier("challengeRepository")
public class ChallengeRepositoryImpl implements CharacterRepository {

    private final RestTemplate restTemplate;

    @Value("${baseUrl}")
    private String url;

    @Value("${character}")
    private String action;

    public ChallengeRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CharacterEntity getInfo(String id) throws Exception {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            CharacterEntity character = restTemplate.exchange(url.concat(action + id), HttpMethod.GET, entity, CharacterEntity.class).getBody();
            log.info(TAG_SUCCESS_CHARACTER.getValue());
            return  character;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new Exception();
        }
    }
}
