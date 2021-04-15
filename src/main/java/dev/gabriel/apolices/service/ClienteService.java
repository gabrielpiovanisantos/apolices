package dev.gabriel.apolices.service;

import dev.gabriel.apolices.entity.Cliente;
import dev.gabriel.apolices.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

}
