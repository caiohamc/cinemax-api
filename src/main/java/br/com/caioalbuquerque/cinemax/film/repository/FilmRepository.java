package br.com.caioalbuquerque.cinemax.film.repository;

import br.com.caioalbuquerque.cinemax.film.model.Film;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends MongoRepository<Film, ObjectId> { }