package com.challenge.backend.presentation.mapper;

import com.challenge.backend.presentation.model.CharacterFullInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.challenge.backend.dummyobjects.DummyObjects.getFullInfo;
import static com.challenge.backend.dummyobjects.DummyObjects.getResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class PresentationDataMapperTest {

    @InjectMocks
    private PresentationDataMapper mapper;

    @Test
    public void convertToRootModel() {
        CharacterFullInfo expected = getFullInfo();
        CharacterFullInfo actual = mapper.convertToRootModel(getResponseEntity());

        Assert.assertEquals(expected.getName(), actual.getName());
    }

}