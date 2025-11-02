package com.alura.ScreenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SerieJSON(
        @JsonAlias Long id,
        @JsonAlias String titulo,
        @JsonAlias String poster,
        @JsonAlias String personagem,

        @JsonAlias List<Frase> frase
) {
}
