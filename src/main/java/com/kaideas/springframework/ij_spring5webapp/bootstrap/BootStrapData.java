package com.kaideas.springframework.ij_spring5webapp.bootstrap;

import com.kaideas.springframework.ij_spring5webapp.domain.Author;
import com.kaideas.springframework.ij_spring5webapp.domain.Book;
import com.kaideas.springframework.ij_spring5webapp.domain.Publisher;
import com.kaideas.springframework.ij_spring5webapp.repositories.AuthorRepository;
import com.kaideas.springframework.ij_spring5webapp.repositories.BookRepository;
import com.kaideas.springframework.ij_spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/**
 * Created by kt on 05/16/2020
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1233221447");
        Publisher wiley = new Publisher  ("Wiley", "Hoboken", "New Jersey",  "07030-5774");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(wiley);
        wiley.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(wiley);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3235488851");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(wiley);
        wiley.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Wiley Number of Books: " + wiley.getBooks().size());

    }
}
