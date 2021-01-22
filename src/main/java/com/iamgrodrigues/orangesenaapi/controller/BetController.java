package com.iamgrodrigues.orangesenaapi.controller;

import com.iamgrodrigues.orangesenaapi.dto.response.MessageResponseDTO;
import com.iamgrodrigues.orangesenaapi.entity.Person;
import com.iamgrodrigues.orangesenaapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BetController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPersont(@RequestBody Person person) {
        return personService.createPersont(person);
    }
}
