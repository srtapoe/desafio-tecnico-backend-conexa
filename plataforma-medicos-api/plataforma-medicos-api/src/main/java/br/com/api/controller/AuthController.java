package br.com.api.controller;

import br.com.api.dto.LoginDTO;
import br.com.api.exception.SenhaIncorretaException;
import br.com.api.exception.UsuarioNaoEncontradoException;
import br.com.api.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/api/v1/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) throws UsuarioNaoEncontradoException, SenhaIncorretaException {
        String token = authService.login(loginDTO);
        return ResponseEntity.ok(token);
    }
}
