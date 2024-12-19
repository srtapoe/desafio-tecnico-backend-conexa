package br.com.api.controller;

import br.com.api.dto.MedicoDTO;
import br.com.api.dto.MedicoListaDTO;
import br.com.api.exception.SenhasNaoConferemException;
import br.com.api.service.MedicoService;
import br.com.api.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MedicoController {

    private final MedicoService medicoService;

    private final TokenService tokenService;

    public MedicoController(MedicoService medicoService, TokenService tokenService) {
        this.medicoService = medicoService;
        this.tokenService = tokenService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid MedicoDTO medicoDTO) throws SenhasNaoConferemException {
        medicoService.salvar(medicoDTO);
        return ResponseEntity.ok("Médico cadastrado com sucesso!");
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<MedicoListaDTO>> listarDoctors() {
        var lista = medicoService.listar();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/logoff")
    public ResponseEntity<String> logoff(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Token JWT não fornecido ou inválido.");
        }
        String token = authHeader.substring(7);

        tokenService.revogarToken(token);

        return ResponseEntity.ok("Logoff realizado com sucesso!");
    }

}
