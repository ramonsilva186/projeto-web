package br.ifpb.imobiliaria.model;

import br.ifpb.imobiliaria.enums.StatusAnuncio;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "anuncio")
@EqualsAndHashCode(of = "idAnuncio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @ElementCollection
    private List<String> fotos;

    @NotNull
    private Date anunciadoEm;

    @NotNull
    private StatusAnuncio status;

    @NotNull
    private Integer visualizacoes;

}
