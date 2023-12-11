package br.ifpb.imobiliaria.model;

import br.ifpb.imobiliaria.enums.StatusAnuncio;
import br.ifpb.imobiliaria.enums.TipoAnuncio;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "anuncio")
@EqualsAndHashCode(of = "idAnuncio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnuncio;

    @NotNull
    @OneToOne
    private Imovel imovel;

    @NotNull
    @ManyToOne
    private Usuario usuario;

    @NotNull
    private String titulo;

    @NotNull
    private String descricao;

    @NotNull
    @ElementCollection
    @CollectionTable
    private List<String> fotos;

    @NotNull
    private Date anunciadoEm;

    @NotNull
    private StatusAnuncio status;

    @NotNull
    private TipoAnuncio tipo;

}
