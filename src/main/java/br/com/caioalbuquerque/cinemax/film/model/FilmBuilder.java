package br.com.caioalbuquerque.cinemax.film.model;

import java.util.List;
import java.util.UUID;

public class FilmBuilder {

    protected UUID film;
    protected String title;
    protected String date;
    protected String trailer;
    protected List<Genre> genres;
    protected String image;

    public FilmBuilder title(String title){
        this.title = title;
        return this;
    }

    public FilmBuilder date(String date){
        this.date = date;
        return this;
    }

    public FilmBuilder trailer(String trailer){
        this.trailer = trailer;
        return this;
    }

    public FilmBuilder genres(List<Genre> genres){
        this.genres = genres;
        return this;
    }

    public FilmBuilder image(String image){
        this.image = image;
        return this;
    }

    public Film build() {
        film = UUID.randomUUID();
        return new Film(this);
    }
}