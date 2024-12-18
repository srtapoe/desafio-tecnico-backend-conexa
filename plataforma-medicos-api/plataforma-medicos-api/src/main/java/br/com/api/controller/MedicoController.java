package br.com.api.controller;

import br.com.api.dto.MedicoDTO;
import br.com.api.exception.SenhasNaoConferemException;
import br.com.api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid MedicoDTO medicoDTO) throws SenhasNaoConferemException {
        medicoService.salvar(medicoDTO);
        return ResponseEntity.ok("Médico cadastrado com sucesso!");
    }
}
