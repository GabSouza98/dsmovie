package com.devsuperior.dsmovie.entities;

//A relação entre Movies e Users é de ManyToMany, e necessita de uma tabela intermediaria
//para relacionar os dados. O intermediario é o Score, porém, o score necessita de 2 chaves
//estrangeiras, o ID Movie e ID User, portando a classe ScorePK será a chave primária feita
//com base nas 2 chaves estrangeiras

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ScorePK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ScorePK() {

    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
