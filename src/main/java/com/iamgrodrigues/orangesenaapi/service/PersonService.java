package com.iamgrodrigues.orangesenaapi.service;

import com.iamgrodrigues.orangesenaapi.dto.response.MessageResponseDTO;
import com.iamgrodrigues.orangesenaapi.entity.Person;
import com.iamgrodrigues.orangesenaapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    public MessageResponseDTO createPersont(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
