package com.challenge.backend.data.repository.impl;

import com.challenge.backend.data.entity.CharacterEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class ChallengeRepositoryImplTest {

    @InjectMocks
    private ChallengeRepositoryImpl repository;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(repository, "url","", String.class);
        ReflectionTestUtils.setField(repository, "action","", String.class);
    }

    @Test
    public void getInfo() throws Exception {
        Mockito.when(restTemplate.exchange(
                anyString(),
                any(HttpMethod.class),
                Mockito.<HttpEntity<MultiValueMap<String, String>>> any(),
                Mockito.<Class<CharacterEntity>> any()
        )).thenReturn(ResponseEntity.ok(new CharacterEntity()));

        CharacterEntity entity = repository.getInfo(null);
        Assert.assertNull(entity.getName());
    }

    @Test(expected = Exception.class)
    public void getException(){
        Mockito.when(restTemplate.exchange(
                anyString(),
                any(HttpMethod.class),
                Mockito.<HttpEntity<MultiValueMap<String, String>>> any(),
                Mockito.<Class<CharacterEntity>> any()
        )).thenThrow(new Exception());
    }


}