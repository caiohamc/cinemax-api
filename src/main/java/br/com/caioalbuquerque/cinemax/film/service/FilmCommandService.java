package br.com.caioalbuquerque.cinemax.film.service;

import br.com.caioalbuquerque.cinemax.film.api.RegisterFilm;
import br.com.caioalbuquerque.cinemax.film.model.Film;
import br.com.caioalbuquerque.cinemax.film.repository.FilmRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class FilmCommandService {

    private final FilmRepository repository;

    public FilmCommandService(FilmRepository repository) {
        this.repository = repository;
    }

    public ObjectId register(RegisterFilm dto) {

        Film film = Film.builder()
            .title(dto.getTitle())
            .date(dto.getDate())
            .genres(dto.getGenres())
            .trailer(dto.getTrailer())
            .image(dto.getImage())
            .build();

        this.repository.save(film);

        return film.getId();
    }
}
