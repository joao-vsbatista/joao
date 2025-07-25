package com.example.dota_api.controller;


import com.example.dota_api.model.Heroi;
import com.example.dota_api.repository.HeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    @Autowired
    private HeroiRepository repository;

    @GetMapping
    public List<Heroi> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Heroi criarHeroi(@RequestBody Heroi heroi){
        return repository.save(heroi);
    }

    @GetMapping("/nome/{nome}")
    public List<Heroi> buscarPorNome(@PathVariable String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/posicao/{posicao}")
    public List<Heroi> buscarPorPosicao(@PathVariable String posicao) {
        return repository.findByPosicoesContainingIgnoreCase(posicao);
    }

    @PutMapping("/{id}")
    public Heroi atualizar(@PathVariable Long id, @RequestBody Heroi atualizado) {
        return repository.findById(id).map(heroi -> {
            heroi.setNome(atualizado.getNome());
            heroi.setPosicoes(atualizado.getPosicoes());
            heroi.setHabilidades(atualizado.getHabilidades());
            return repository.save(heroi);
        }).orElseThrow(() -> new RuntimeException("Herói não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
