package br.ifpb.imobiliaria.model;

import br.ifpb.imobiliaria.enums.StatusImovel;
import br.ifpb.imobiliaria.enums.TipoImovel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = "idImovel")
@Entity
@Table(name = "imovel")
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImovel;
    @NotBlank
    private String endereco;
    private Integer numeroQuartos;
    private Integer numeroBanheiros;
    private Integer numeroGaragem;
    private Double preco;
    @Enumerated(EnumType.STRING)
    private StatusImovel status;
    @Enumerated(EnumType.STRING)
    private TipoImovel tipo;

    public Imovel() { }

    public Imovel(Long idImovel, String endereco, Integer numeroQuartos, Integer numeroBanheiros, Integer numeroGaragem, Double preco, StatusImovel status, TipoImovel tipo) {
        this.idImovel = idImovel;
        this.endereco = endereco;
        this.numeroQuartos = numeroQuartos;
        this.numeroBanheiros = numeroBanheiros;
        this.numeroGaragem = numeroGaragem;
        this.preco = preco;
        this.status = status;
        this.tipo = tipo;
    }

    public Long getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Long idImovel) {
        this.idImovel = idImovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(Integer numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public Integer getNumeroBanheiros() {
        return numeroBanheiros;
    }

    public void setNumeroBanheiros(Integer numeroBanheiros) {
        this.numeroBanheiros = numeroBanheiros;
    }

    public Integer getNumeroGaragem() {
        return numeroGaragem;
    }

    public void setNumeroGaragem(Integer numeroGaragem) {
        this.numeroGaragem = numeroGaragem;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public StatusImovel getStatus() {
        return status;
    }

    public void setStatus(StatusImovel status) {
        this.status = status;
    }

    public TipoImovel getTipo() {
        return tipo;
    }

    public void setTipo(TipoImovel tipo) {
        this.tipo = tipo;
    }
}
