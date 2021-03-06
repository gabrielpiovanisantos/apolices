package dev.gabriel.apolices.repository;


import dev.gabriel.apolices.entity.Apolice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoliceRepository extends MongoRepository<Apolice, String> {
    Apolice getByNumero(Integer numero);
}
