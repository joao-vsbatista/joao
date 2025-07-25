package com.example.dota_api.repository;

import com.example.dota_api.model.Heroi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long> {
    List<Heroi> findByNomeContainingIgnoreCase(String nome);
    List<Heroi> findByPosicoesContainingIgnoreCase(String posicao);
}
