package dev.gabriel.apolices.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Builder
@Data
@Document
public class Apolice {

    @Id
    private String id;
    private Integer numero;
    @NonNull
    private LocalDate inicioVigencia;
    @NonNull
    private LocalDate fimVigencia;
    @NonNull
    private String veiculoPlaca;
    @NonNull
    private Float valor;
    @NonNull
    private String clienteId;

}
