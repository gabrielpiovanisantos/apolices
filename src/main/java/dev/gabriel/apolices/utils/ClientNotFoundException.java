package dev.gabriel.apolices.utils;

import lombok.NonNull;

import static java.lang.String.format;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(@NonNull String clienteId) {
        super(format("Client with id %s not found", clienteId));
    }
}
