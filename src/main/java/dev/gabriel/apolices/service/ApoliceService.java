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

    public Apolice save(Apolice apolice) {
        if (clienteRepository.getById(apolice.getClienteId()) == null) {
            throw new ClientNotFoundException(apolice.getClienteId());
        }

        do {
            setApoliceNumero(apolice);
        } while (apoliceRepository.getByNumero(apolice.getNumero()) != null);

        return apoliceRepository.save(apolice);
    }

    private void setApoliceNumero(Apolice apolice) {
        int numero = Math.abs(UUID.randomUUID().hashCode());
        apolice.setNumero(numero);
    }

    public ApoliceBO getByNumber(Integer numero) {
        ApoliceBO apoliceBO = ApoliceBO.fromApolice(apoliceRepository.getByNumero(numero));
        return apoliceBO;
    }
}
