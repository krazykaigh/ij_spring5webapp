package com.kaideas.springframework.ij_spring5webapp.repositories;

import com.kaideas.springframework.ij_spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
