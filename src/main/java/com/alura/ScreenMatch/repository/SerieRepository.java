package com.alura.ScreenMatch.repository;

import com.alura.ScreenMatch.model.Frase;
import com.alura.ScreenMatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    @Query("SELECT f.message FROM Frase f WHERE f.serie.id = :serieId")
    List<String> getSerieFrase(@Param("serieId") Long serieId);

}
