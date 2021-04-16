package dev.gabriel.apolices.service;

import dev.gabriel.apolices.entity.Apolice;
import dev.gabriel.apolices.repository.ApoliceRepository;
import dev.gabriel.apolices.repository.ClienteRepository;
import dev.gabriel.apolices.utils.ClientNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApoliceService {

    private final ApoliceRepository apoliceRepository;
    private final ClienteRepository clienteRepository;

    public ApoliceService(ApoliceRepository apoliceRepository, ClienteRepository clienteRepository) {
        this.apoliceRepository = apoliceRepository;
        this.clienteRepository = clienteRepository;
    }

    public void save(Apolice apolice) {
        if (clienteRepository.getById(apolice.getClienteId()) == null) {
            throw new ClientNotFoundException(apolice.getClienteId());
        }
        apolice.setNumero(UUID.randomUUID().hashCode());
        apoliceRepository.save(apolice);
    }

    public ApoliceBO getByNumber(Integer numero) {
        return new ApoliceBO(apoliceRepository.getByNumero(numero));
    }
}
