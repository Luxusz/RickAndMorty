package com.challenge.backend.controller;

import com.challenge.backend.model.Root;
import com.challenge.backend.service.impl.ChallengeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Francisco
 *
 */
@RestController
@RequestMapping("/challenge")
@CrossOrigin(origins = "*")
public class ChallengeController {

    @Autowired
    private ChallengeServiceImpl service;

    @GetMapping(value = "/getCharacterInfo/{id}", produces = "application/json")
    public ResponseEntity<Root> getInfo(@PathVariable("id") String id) throws Exception {
        Root mensaje = null;
        try{
            if(!id.isEmpty()){
                mensaje = service.getInfo(id);
            }
        }catch (Exception e) {
            throw new Exception();
        }
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final String exceptionHandlerIllegalArgumentException(final IllegalArgumentException e) {
        return '"' + e.getMessage() + '"';
    }

}
