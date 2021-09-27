package com.challenge.backend.domain.mapper;

import com.challenge.backend.domain.entity.CharacterResponseEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.challenge.backend.dummyobjects.DummyObjects.*;

@RunWith(MockitoJUnitRunner.class)
public class ResourceDataMapperTest {

    @InjectMocks
    private ResourceDataMapper mapper;

    @Test
    public void convertToRootModel() {
        CharacterResponseEntity expected = getResponseEntity();
        CharacterResponseEntity actual = mapper.convertToRootModel(getCharacterEntity(), getLocation());

        Assert.assertNotEquals(expected.getId(), actual.getId());
    }
}