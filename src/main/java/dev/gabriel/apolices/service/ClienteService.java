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

    public boolean validateCPF(String cpf){
        //TODO: validate logic
        return true;
    }

    public void save(Cliente cliente) {
        if(validateCPF(cliente.getCpf()))
        //TODO: cpf invalid exception
        clienteRepository.save(cliente);
    }

}
