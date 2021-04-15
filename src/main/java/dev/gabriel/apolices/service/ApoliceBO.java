package dev.gabriel.apolices.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.gabriel.apolices.entity.Apolice;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;


public class ApoliceBO {

    public static final LocalDate NOW = LocalDate.now();

    private final Apolice apolice;

    private Boolean vencida;
    @JsonProperty("dias_para_vencimento")
    private long diasVencimento;

    public ApoliceBO(Apolice apolice) {
        this.apolice = apolice;
        this.setVencida();
        this.setDiasVencimento();
    }

    public void setVencida() {
        this.vencida = !this.apolice.getFimVigencia().isAfter(NOW);
    }

    public void setDiasVencimento() {
        this.diasVencimento = DAYS.between(NOW, apolice.getFimVigencia());
    }
}
