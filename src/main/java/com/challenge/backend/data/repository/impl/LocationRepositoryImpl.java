package com.challenge.backend.data.repository.impl;

import com.challenge.backend.data.entity.LocationEntity;
import com.challenge.backend.domain.repository.LocationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static com.challenge.backend.common.enumeration.LogTagEnum.TAG_SUCCESS_LOCATION;
/**
 * @author Francisco
 *
 */
@Repository
@Log4j2
@Qualifier("locationRepository")
public class LocationRepositoryImpl implements LocationRepository {
    private final RestTemplate restTemplate;

    public LocationRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public LocationEntity getLocationInfo(String url) throws Exception {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            LocationEntity locationEntity = restTemplate.exchange(url, HttpMethod.GET, entity, LocationEntity.class).getBody();
            log.info(TAG_SUCCESS_LOCATION.getValue());
            return locationEntity;
        }
        catch (Exception e){
            log.error(e.getMessage());
            throw new Exception();
        }
    }
}
