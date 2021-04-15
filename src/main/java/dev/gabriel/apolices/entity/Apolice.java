package dev.gabriel.apolices.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Builder
@Data
@Document
public class Apolice {

    @Id
    private String id;
    @Setter
    private Integer numero = UUID.randomUUID().hashCode();
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
