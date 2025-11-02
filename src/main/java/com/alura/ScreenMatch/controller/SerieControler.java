package com.alura.ScreenMatch.controller;

import com.alura.ScreenMatch.dto.SerieDTO;
import com.alura.ScreenMatch.model.Serie;
import com.alura.ScreenMatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieControler {

    @Autowired
    private SerieService serieService;

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id){
        var result = serieService.getSerie(id);
        return result==null ? "Not Found" : result.toString();
    }

    @GetMapping("/{id}/frases")
    public List<String> getFrases(@PathVariable Long id){
        return serieService.getSerieFrases(id);
    }

    @PostMapping("")
    public String postSerie(@Validated @RequestBody Serie novaSerie){
        try{
            SerieDTO result = serieService.saveSerie(novaSerie);
            return result !=null
                    ? result.toString() : "FAIL!!!!";

        } catch (Exception e) {
            return "Erro!!!"+e.getMessage();
        }
    }

}
