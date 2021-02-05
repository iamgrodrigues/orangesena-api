package com.iamgrodrigues.orangesenaapi.controller;

import com.iamgrodrigues.orangesenaapi.dto.request.PersonDTO;
import com.iamgrodrigues.orangesenaapi.dto.response.MessageResponseDTO;
import com.iamgrodrigues.orangesenaapi.exception.PersonNotFoundException;
import com.iamgrodrigues.orangesenaapi.repository.PersonRepository;
import com.iamgrodrigues.orangesenaapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;
    private PersonRepository personRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping("/{email}")
    public PersonDTO findByEmail(@PathVariable String email) throws PersonNotFoundException {
        return personService.findByEmail(email);
    }
}
