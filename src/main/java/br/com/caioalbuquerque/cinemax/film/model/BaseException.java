package br.com.caioalbuquerque.cinemax.film.model;

import java.io.Serializable;

public class BaseException extends RuntimeException implements Serializable {

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }
}