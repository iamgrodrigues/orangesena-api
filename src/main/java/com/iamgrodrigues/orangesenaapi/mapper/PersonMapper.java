package com.iamgrodrigues.orangesenaapi.mapper;

import com.iamgrodrigues.orangesenaapi.dto.request.PersonDTO;
import com.iamgrodrigues.orangesenaapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.validation.Valid;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toModel(@Valid PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}