package com.alura.ScreenMatch.service;

import com.alura.ScreenMatch.dto.SerieDTO;
import com.alura.ScreenMatch.model.Serie;
import com.alura.ScreenMatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {


    @Autowired
    private SerieRepository serieRepository;

    public Serie getSerie(Long id){
        //return serieRepository.findById(id).map(this::toDTO).orElse(null);

        return serieRepository.findById(id)
                .orElse(null);
    }

    public List<String> getSerieFrases(Long id){
        return serieRepository.getSerieFrase(id);
    }

    public Serie saveSerie(Serie serie){
        try{
            return serieRepository.save(serie);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private SerieDTO toDTO(Serie serie){
        return new SerieDTO(
                serie.getTitulo(),
                serie.getPoster(),
                serie.getPersonagem(),

                serie.getFrase()
        );
    }
}
