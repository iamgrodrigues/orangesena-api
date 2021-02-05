package com.iamgrodrigues.orangesenaapi.service;

import com.iamgrodrigues.orangesenaapi.dto.request.PersonDTO;
import com.iamgrodrigues.orangesenaapi.dto.response.MessageResponseDTO;
import com.iamgrodrigues.orangesenaapi.entity.Bet;
import com.iamgrodrigues.orangesenaapi.entity.Person;
import com.iamgrodrigues.orangesenaapi.exception.PersonNotFoundException;
import com.iamgrodrigues.orangesenaapi.mapper.PersonMapper;
import com.iamgrodrigues.orangesenaapi.repository.BetRepository;
import com.iamgrodrigues.orangesenaapi.repository.PersonRepository;
import com.iamgrodrigues.orangesenaapi.utils.LotteryUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashSet;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;
    private BetRepository betRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Bet bet = new Bet();
        bet.setMoment(Instant.now());
        bet.setNumbers(LotteryUtils.lotteryNumbers());

        Bet savedBet = betRepository.save(bet);

        HashSet<Bet> betsSet = new HashSet<>();
        betsSet.add(savedBet);

        personToSave.setBets(betsSet);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Your numbers are " + savedBet.getNumbers())
                .build();
    }

    @Transactional
    public PersonDTO findByEmail(String email) throws PersonNotFoundException {
        Person foundPerson = personRepository.findByEmail(email)
                .orElseThrow(() -> new PersonNotFoundException(email));
        return personMapper.toDTO(foundPerson);
    }
}
