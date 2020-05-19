package com.kaideas.springframework.ij_spring5webapp.repositories;

import com.kaideas.springframework.ij_spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
}
