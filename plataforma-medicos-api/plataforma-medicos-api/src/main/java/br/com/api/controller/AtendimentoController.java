package br.com.api.controller;

import br.com.api.dto.AtendimentoDTO;
import br.com.api.exception.AgendamentoForaDasNormasException;
import br.com.api.exception.MedicoNaoEncontradoException;
import br.com.api.service.AtendimentoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attendance")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;;

    public AtendimentoController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<String> criarAtendimento(@RequestBody @Valid AtendimentoDTO atendimentoDTO, HttpServletRequest request) throws MedicoNaoEncontradoException, AgendamentoForaDasNormasException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token JWT não fornecido ou inválido.");
        }

        String token = authHeader.substring(7);
        atendimentoService.criarAtendimento(atendimentoDTO, token);

        return ResponseEntity.ok("Atendimento criado com sucesso!");
    }
}
