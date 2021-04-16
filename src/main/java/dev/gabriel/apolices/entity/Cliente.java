package dev.gabriel.apolices.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document
public class Cliente {

    @Id
    private String id;
    @NonNull
    private String nome;
    @NonNull
    private String cpf;
    @NonNull
    private String cidade;
    @NonNull
    private String uf;
}
