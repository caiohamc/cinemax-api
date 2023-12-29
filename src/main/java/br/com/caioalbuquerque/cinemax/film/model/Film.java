package br.com.caioalbuquerque.cinemax.film.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Document(collection = "films")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    @Id
    private ObjectId id;

    private UUID film;

    private String title;

    private String date;

    private String trailer;

    private List<Genre> genres;

    private String image;

    public static FilmBuilder builder() {
        return new FilmBuilder();
    }

    public Film(FilmBuilder builder) {
        this.film = requireNonNull(builder.film);
        this.title = builder.title;
        this.date = builder.date;
        this.genres = builder.genres;
        this.trailer = builder.trailer;
        this.image = builder.title;
    }

    public static class FilmIdNotFoundException extends BaseException {
        @Serial private static final long serialVersionUID = -3167237330288013042L;
    }
}