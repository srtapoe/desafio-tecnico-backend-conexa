package br.com.api.exception;

public class SenhaIncorretaException extends Exception {
    public SenhaIncorretaException(String mensagem) {
        super(mensagem);
    }
}
