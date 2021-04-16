package dev.gabriel.apolices.repository;

import dev.gabriel.apolices.entity.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

    Cliente getById(String clienteId);

    Cliente getByCpf(String cpf);
}
