package br.edu.universidade.primeiraapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaMundoController {
    @GetMapping("/ola")
    public String dizerOla() {
        return "Ola Mundo! Meu servidor está rodando.";
    }
}
