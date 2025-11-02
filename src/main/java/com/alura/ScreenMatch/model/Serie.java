package com.alura.ScreenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table()
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String titulo;
    @NonNull
    private String poster;

    @NonNull
    private String personagem;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Frase> frase= new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NonNull String titulo) {
        this.titulo = titulo;
    }

    @NonNull
    public String getPoster() {
        return poster;
    }

    public void setPoster(@NonNull String poster) {
        this.poster = poster;
    }

    @NonNull
    public List<Frase> getFrase() {
        return frase;
    }

    public void setFrase(@NonNull List<Frase> frase) {
        frase.forEach(f->f.setSerie(this));
        this.frase = frase;
    }

    @NonNull
    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(@NonNull String personagem) {
        this.personagem = personagem;
    }

    public Serie() {
        titulo = "";
        poster = "";
        frase = new ArrayList<>();
        personagem = "";
    }
    public Serie(@NonNull String titulo, @NonNull String poster, @NonNull String personagem) {
        try{
            this.titulo = titulo;
            this.poster = poster;
            this.frase = new ArrayList<>();
            this.personagem = personagem;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Serie(@NonNull String titulo, @NonNull String poster, @NonNull String personagem, List<Frase> frase) {
        try{
            this.titulo = titulo;
            this.poster = poster;
            this.frase = frase;
            this.personagem = personagem;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SerieJSON toJson(){
        return new SerieJSON(
                this.getId(),
                this.getTitulo(),
                this.getPoster(),
                this.getPersonagem(),
                this.getFrase()
                );
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id + "," +
                "\"titulo\":\"" + titulo + "\"," +
                "\"poster\":\"" + poster + "\"," +
                "\"personagem\":\"" + personagem + "\"," +
                "\"frases\":[" + frase.stream()
                .map(f -> "\"" + f.getMessage() + "\"")
                .reduce((a, b) -> a + "," + b).orElse("") + "]" +
                "}";
    }

}
