package dev.gabriel.apolices.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Builder
@Data
@Document
public class Apolice {

    @Id
    private String id;
    @GeneratedValue(strategy = GenerationType.AUTO)
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
