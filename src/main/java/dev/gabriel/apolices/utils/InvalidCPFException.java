package dev.gabriel.apolices.utils;

public class InvalidCPFException extends RuntimeException {
    public InvalidCPFException() {
        super("Invalid cpf");
    }
}
