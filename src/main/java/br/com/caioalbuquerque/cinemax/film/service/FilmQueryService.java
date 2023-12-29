package br.com.caioalbuquerque.cinemax.film.service;

import br.com.caioalbuquerque.cinemax.film.model.Film;
import br.com.caioalbuquerque.cinemax.film.repository.FilmRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.caioalbuquerque.cinemax.film.model.Film.*;

@Service
public class FilmQueryService {

    private final FilmRepository repository;

    public FilmQueryService(FilmRepository repository) {
        this.repository = repository;
    }

    public List<Film> findAll() {
        return repository.findAll();
    }

    public Film findById(String filmId) {
        Optional<Film> filmOptional = repository.findById(new ObjectId(filmId));

        if(filmOptional.isEmpty())
            throw new FilmIdNotFoundException();

        return filmOptional.get();
    }
}