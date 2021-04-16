package dev.gabriel.apolices.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.gabriel.apolices.entity.Apolice;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Builder
@Data
public class ApoliceBO {

    public static final LocalDate NOW = LocalDate.now();

    private Integer numero;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private String veiculoPlaca;
    private Float valor;
    private String clienteId;

    private Boolean vencida;

    private long diasVencimento;

    public void setVencida() {
        this.vencida = !this.getFimVigencia().isAfter(NOW);
    }

    public void setDiasVencimento() {
        this.diasVencimento = DAYS.between(NOW, this.getFimVigencia());
    }

    public static ApoliceBO fromApolice(Apolice apolice) {
        return ApoliceBO.builder().
                clienteId(apolice.getClienteId()).
                numero(apolice.getNumero()).
                fimVigencia(apolice.getFimVigencia()).
                inicioVigencia(apolice.getInicioVigencia()).
                valor(apolice.getValor()).
                veiculoPlaca(apolice.getVeiculoPlaca()).
                vencida(!apolice.getFimVigencia().isAfter(NOW)).
                diasVencimento(DAYS.between(NOW, apolice.getFimVigencia())).
                build();
    }
}
