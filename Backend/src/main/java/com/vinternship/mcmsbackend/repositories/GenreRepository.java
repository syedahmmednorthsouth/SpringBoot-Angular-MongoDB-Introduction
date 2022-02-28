package com.vinternship.mcmsbackend.repositories;

import com.vinternship.mcmsbackend.models.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GenreRepository extends MongoRepository<Genre, String> {
    List<Genre> findGenreByNameContaining(String name);
}
