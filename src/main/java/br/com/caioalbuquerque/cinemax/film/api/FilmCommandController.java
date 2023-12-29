package br.com.caioalbuquerque.cinemax.film.api;

import br.com.caioalbuquerque.cinemax.film.service.FilmCommandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(FilmQueryController.PATH)
@Validated
@Tag(name = "film-command-controller")
public class FilmCommandController {

    public static final String PATH = "api/v1/films";

    private final FilmCommandService service;

    public FilmCommandController(FilmCommandService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterFilm dto) {
        ObjectId id = service.register(dto);

        URI uri = fromCurrentRequest()
                .path("/")
                .path(id.toString())
                .build()
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}