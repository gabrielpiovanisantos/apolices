package dev.gabriel.apolices.service;

import dev.gabriel.apolices.entity.Cliente;
import dev.gabriel.apolices.repository.ClienteRepository;
import dev.gabriel.apolices.utils.CPFValidator;
import dev.gabriel.apolices.utils.InvalidCPFException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente save(Cliente cliente) {
        if (!CPFValidator.validate(cliente.getCpf()) || clienteRepository.getByCpf(cliente.getCpf()) != null)
            throw new InvalidCPFException();
        return clienteRepository.save(cliente);
    }

}
