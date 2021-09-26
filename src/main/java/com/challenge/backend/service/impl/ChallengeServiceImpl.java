package com.challenge.backend.service.impl;

import com.challenge.backend.mapper.ResourceMapper;
import com.challenge.backend.model.Character;
import com.challenge.backend.model.Location;
import com.challenge.backend.model.Root;
import com.challenge.backend.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
/**
 * @author Francisco
 *
 */
@Service
public class ChallengeServiceImpl implements ChallengeService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ResourceMapper mapper;

    @Value("${baseUrl}")
    private String url;

    @Value("${character}")
    private String action;


    @Override
    public Root getInfo(String id) throws Exception {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            Character character = restTemplate.exchange(url.concat(action + id), HttpMethod.GET, entity, Character.class).getBody();
            return mapper.convertToRootModel(character, getLocationInfo(character.getOrigin().getUrl()));
        }catch (Exception e){
            throw new Exception();
        }
    }

    private Location getLocationInfo(String url) throws Exception {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            return restTemplate.exchange(url, HttpMethod.GET, entity, Location.class).getBody();
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
