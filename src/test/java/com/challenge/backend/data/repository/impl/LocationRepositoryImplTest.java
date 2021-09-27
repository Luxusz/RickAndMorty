package com.challenge.backend.data.repository.impl;


import com.challenge.backend.data.entity.LocationEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class LocationRepositoryImplTest {
    @InjectMocks
    private LocationRepositoryImpl repository;
    @Mock
    private RestTemplate restTemplate;

    @Test
    public void getLocationInfo() throws Exception {
        Mockito.when(restTemplate.exchange(
                anyString(),
                any(HttpMethod.class),
                Mockito.<HttpEntity<MultiValueMap<String, String>>> any(),
                Mockito.<Class<LocationEntity>> any()
        )).thenReturn(ResponseEntity.ok(new LocationEntity()));

        LocationEntity entity = repository.getLocationInfo("null");
        Assert.assertNull(entity.getName());
    }

    @Test(expected = Exception.class)
    public void getException(){
        Mockito.when(restTemplate.exchange(
                anyString(),
                any(HttpMethod.class),
                Mockito.<HttpEntity<MultiValueMap<String, String>>> any(),
                Mockito.<Class<LocationEntity>> any()
        )).thenThrow(new Exception());
    }

}