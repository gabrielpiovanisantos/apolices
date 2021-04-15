package dev.gabriel.apolices.service;

import dev.gabriel.apolices.entity.Apolice;
import dev.gabriel.apolices.repository.ApoliceRepository;
import org.springframework.stereotype.Service;

@Service
public class ApoliceService {

    private final ApoliceRepository apoliceRepository;

    public ApoliceService(ApoliceRepository apoliceRepository) {
        this.apoliceRepository = apoliceRepository;
    }

    public void save(Apolice cliente) {
        apoliceRepository.save(cliente);
    }

    public ApoliceBO getByNumber(String numero) {
        return null;
    }
}
