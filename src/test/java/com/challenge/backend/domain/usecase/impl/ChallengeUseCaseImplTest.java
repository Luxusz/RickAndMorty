package com.challenge.backend.domain.usecase.impl;

import com.challenge.backend.data.entity.CharacterEntity;
import com.challenge.backend.data.entity.LocationEntity;
import com.challenge.backend.domain.entity.CharacterResponseEntity;
import com.challenge.backend.domain.mapper.ResourceDataMapper;
import com.challenge.backend.domain.repository.CharacterRepository;
import com.challenge.backend.domain.repository.LocationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.challenge.backend.dummyobjects.DummyObjects.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class ChallengeUseCaseImplTest {

    @InjectMocks
    private ChallengeUseCaseImpl useCase;

    @Mock
    private CharacterRepository characterRepository;

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private ResourceDataMapper mapper;

    @Test
    public void getInfo() throws Exception {
        CharacterResponseEntity expected = getResponseEntity();
        Mockito.when(characterRepository.getInfo(anyString())).thenReturn(getCharacterEntity());
        Mockito.when(locationRepository.getLocationInfo(anyString())).thenReturn(getLocation());
        Mockito.when(mapper.convertToRootModel(any(), any())).thenReturn(getResponseEntity());

        CharacterResponseEntity actual = useCase.getInfo(anyString());
        Assert.assertEquals(expected.getOrigin().getName(), actual.getOrigin().getName());
    }
}