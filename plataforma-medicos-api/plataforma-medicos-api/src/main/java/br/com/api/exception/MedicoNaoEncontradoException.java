package br.com.api.exception;

public class MedicoNaoEncontradoException extends Exception {
    public MedicoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
