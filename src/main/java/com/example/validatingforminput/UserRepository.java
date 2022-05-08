package com.example.validatingforminput;

import com.example.validatingforminput.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Person, Integer>
{
    Optional<Person> findByUsername(String email);
}
