package com.iamgrodrigues.orangesenaapi.repository;

import com.iamgrodrigues.orangesenaapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
