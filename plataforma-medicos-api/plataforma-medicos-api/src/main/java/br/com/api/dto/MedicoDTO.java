package br.com.api.dto;

import br.com.api.enums.Especialidade;
import br.com.api.enums.Role;
import jakarta.validation.constraints.*;

public class MedicoDTO {

    @Email(message = "O email é obrigatório")
    private String email;
    @NotBlank(message = "Campo senha é obrigatório")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String senha;
    @NotBlank(message = "A confirmação da senha é obrigatório")
    private String confirmacaoSenha;
    @NotNull(message = "A especialidade é obrigatória")
    private Especialidade especialidade;
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido")
    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;
    @NotNull(message = "A data de nascimento é obrigatória")
    private String dataNascimento;
    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Telefone inválido")
    private String telefone;
    @NotNull(message = "O papel (role) é obrigatório")
    private Role role;

    public MedicoDTO(String email, String senha, String confirmacaoSenha, Especialidade especialidade, String cpf, String dataNascimento, String telefone) {
        this.email = email;
        this.senha = senha;
        this.confirmacaoSenha = confirmacaoSenha;
        this.especialidade = especialidade;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public MedicoDTO() {
    }

    public @Email(message = "O email é obrigatório") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "O email é obrigatório") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Campo senha é obrigatório") @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "Campo senha é obrigatório") @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres") String password) {
        this.senha = password;
    }

    public @NotBlank(message = "A confirmação da senha é obrigatório") String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(@NotBlank(message = "A confirmação da senha é obrigatório") String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }

    public @NotNull(message = "A especialidade é obrigatória") Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(@NotNull(message = "A especialidade é obrigatória") Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido") @NotBlank(message = "O CPF é obrigatório") String getCpf() {
        return cpf;
    }

    public void setCpf(@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido") @NotBlank(message = "O CPF é obrigatório") String cpf) {
        this.cpf = cpf;
    }

    public @NotNull(message = "A data de nascimento é obrigatória") String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull(message = "A data de nascimento é obrigatória") String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotBlank(message = "O telefone é obrigatório") @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Telefone inválido") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone é obrigatório") @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Telefone inválido") String telefone) {
        this.telefone = telefone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
