package br.ifpb.imobiliaria.model;

import br.ifpb.imobiliaria.enums.TipoContrato;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.Date;
@EqualsAndHashCode(of = "idContrato")
@Entity
@Table(name = "contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrato;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Imovel imovel;
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    private Date dataFim;
    @Enumerated(EnumType.STRING)
    private TipoContrato tipoContrato;

    public Contrato() { }

    public Contrato(Long idContrato, Cliente cliente, Imovel imovel, Date dataInicio, Date dataFim, TipoContrato tipoContrato) {
        this.idContrato = idContrato;
        this.cliente = cliente;
        this.imovel = imovel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tipoContrato = tipoContrato;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}
