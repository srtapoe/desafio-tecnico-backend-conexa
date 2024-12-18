package br.com.api.dto;

import br.com.api.enums.Especialidade;
import jakarta.validation.constraints.*;

public class MedicoDTO {

    @Email(message = "O email é obrigatório")
    private String email;
    @NotBlank(message = "Campo senha é obrigatório")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String password;
    @NotBlank(message = "A confirmação da senha é obrigatório")
    private String confirmacaoPassword;
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

    public MedicoDTO(String email, String password, String confirmacaoPassword, Especialidade especialidade, String cpf, String dataNascimento, String telefone) {
        this.email = email;
        this.password = password;
        this.confirmacaoPassword = confirmacaoPassword;
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

    public @NotBlank(message = "Campo senha é obrigatório") @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Campo senha é obrigatório") @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres") String password) {
        this.password = password;
    }

    public @NotBlank(message = "A confirmação da senha é obrigatório") String getConfirmacaoPassword() {
        return confirmacaoPassword;
    }

    public void setConfirmacaoPassword(@NotBlank(message = "A confirmação da senha é obrigatório") String confirmacaoPassword) {
        this.confirmacaoPassword = confirmacaoPassword;
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
}
