package com.alura.ScreenMatch.dto;

import com.alura.ScreenMatch.model.Frase;

import java.util.List;

public record SerieDTO(
        String titulo,
        String poster,
        String personagem,

        List<Frase> frase

) {
//    getDados(`/series/frases`)
//      .then(data => {
//        fichaDescricao.innerHTML = `
//              <img src="${data.poster}" alt="${data.titulo}" />
//                <div>
//                <h2>${data.titulo}</h2>
//                <div class="descricao-texto">
//                <p><i>"${data.frase}"</i></p>
//                <p><b>Citado por:</b> ${data.personagem}</p>
//                </div>
//                </div>
//          `;
//    })
}
