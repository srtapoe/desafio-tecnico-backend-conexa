package br.com.api.exception;

public class UsuarioNaoEncontradoException extends Exception {
    public UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
