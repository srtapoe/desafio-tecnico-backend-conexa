package br.com.api.dto;

import jakarta.validation.constraints.*;

public class LoginDTO {

    @Email(message = "O email é obrigatório")
    @NotBlank(message = "O email não pode ser vazio")
    private String email;

    @NotBlank(message = "A senha não pode ser vazia")
    private String senha;

    public LoginDTO() {
    }

    public LoginDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public @Email(message = "O email é obrigatório") @NotBlank(message = "O email não pode ser vazio") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "O email é obrigatório") @NotBlank(message = "O email não pode ser vazio") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha não pode ser vazia") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha não pode ser vazia") String senha) {
        this.senha = senha;
    }
}
