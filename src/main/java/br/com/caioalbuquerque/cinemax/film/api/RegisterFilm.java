package br.com.caioalbuquerque.cinemax.film.api;

import br.com.caioalbuquerque.cinemax.film.model.Genre;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class RegisterFilm {

    @NotNull
    String title;

    String date;

    String trailer;

    @NotNull
    List<Genre> genres;

    String image;
}