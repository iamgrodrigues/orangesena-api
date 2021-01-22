package com.iamgrodrigues.orangesenaapi.service;

import com.iamgrodrigues.orangesenaapi.dto.request.PersonDTO;
import com.iamgrodrigues.orangesenaapi.dto.response.MessageResponseDTO;
import com.iamgrodrigues.orangesenaapi.entity.Person;
import com.iamgrodrigues.orangesenaapi.mapper.PersonMapper;
import com.iamgrodrigues.orangesenaapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
