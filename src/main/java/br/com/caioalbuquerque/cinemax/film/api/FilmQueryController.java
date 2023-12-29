package br.com.caioalbuquerque.cinemax.film.api;

import br.com.caioalbuquerque.cinemax.film.model.Film;
import br.com.caioalbuquerque.cinemax.film.service.FilmQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(FilmQueryController.PATH)
@Tag(name = "film-query-controller")
public class FilmQueryController {

    public static final String PATH = "api/v1/films";

    private final FilmQueryService service;

    public FilmQueryController(FilmQueryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Film>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }
}