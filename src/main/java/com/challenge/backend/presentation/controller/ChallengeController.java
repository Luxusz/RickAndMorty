package com.challenge.backend.presentation.controller;

import com.challenge.backend.domain.entity.CharacterResponseEntity;
import com.challenge.backend.presentation.mapper.PresentationDataMapper;
import com.challenge.backend.presentation.model.CharacterFullInfo;
import com.challenge.backend.domain.usecase.ChallengeUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.challenge.backend.common.enumeration.LogTagEnum.TAG_SUCCESS_FULL;
import static com.challenge.backend.common.enumeration.LogTagEnum.TAG_SUCCESS_LOCATION;

/**
 * @author Francisco
 *
 */
@RestController
@RequestMapping("/challenge")
@Log4j2
@CrossOrigin(origins = "*")
public class ChallengeController {


    private final ChallengeUseCase challengeUseCase;
    private final PresentationDataMapper mapper;

    public ChallengeController(ChallengeUseCase challengeUseCase, PresentationDataMapper mapper) {
        this.challengeUseCase = challengeUseCase;
        this.mapper = mapper;
    }

    @GetMapping(value = "/getCharacterInfo/{id}", produces = "application/json")
    public ResponseEntity<CharacterFullInfo> getInfo(@PathVariable("id") String id) throws Exception {
        CharacterFullInfo characterFullInfo = null;
        try{
            if(!id.isEmpty()){
                CharacterResponseEntity characterResponseEntity = challengeUseCase.getInfo(id);
                characterFullInfo = mapper.convertToRootModel(characterResponseEntity);
            }
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception();
        }
        log.info(TAG_SUCCESS_FULL.getValue());
        return new ResponseEntity<>(characterFullInfo, HttpStatus.OK);
    }

}