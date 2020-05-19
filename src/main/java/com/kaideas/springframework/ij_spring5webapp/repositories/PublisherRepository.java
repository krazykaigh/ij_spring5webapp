package com.kaideas.springframework.ij_spring5webapp.repositories;

import com.kaideas.springframework.ij_spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
