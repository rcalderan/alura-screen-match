package com.alura.ScreenMatch.controller;

import com.alura.ScreenMatch.dto.SerieDTO;
import com.alura.ScreenMatch.model.Serie;
import com.alura.ScreenMatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieControler {

    @Autowired
    private SerieService serieService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id){
        try {
            var response = serieService.getSerie(id);
            return response != null
                    ? ResponseEntity.ok().body(response.toString())
                    :ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
        catch (Exception e){
            System.out.println(e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro no servidor. Contate o administrador!");
        }
    }

    @GetMapping("/{id}/frases")
    public ResponseEntity<List<String>> getFrases(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(serieService.getSerieFrases(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonList("Erro no servidor. Contate o administrador!"));
        }
    }

    @PostMapping("")
    public ResponseEntity<String> postSerie(@Validated @RequestBody Serie novaSerie){
        try{
            var result = serieService.saveSerie(novaSerie);
            return result != null
                    ? ResponseEntity
                        .status(HttpStatus.CREATED)
                    .body(result.toString())
                    : ResponseEntity
                        .status(HttpStatus.UNPROCESSABLE_ENTITY)
                        .build();

        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro no servidor. Contate o administrador!");
        }
    }

}
