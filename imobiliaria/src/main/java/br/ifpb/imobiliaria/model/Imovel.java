package br.ifpb.imobiliaria.model;

import br.ifpb.imobiliaria.enums.StatusImovel;
import br.ifpb.imobiliaria.enums.TipoImovel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@EqualsAndHashCode(of = "idImovel")
@Entity
@Table(name = "imovel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImovel;

    @NotNull
    @NotBlank
    private String endereco;

    @Min(value = 0, message = "O número de quartos não pode ser negativo")
    private Integer numeroQuartos;

    @Min(value = 0, message = "O número de banheiros não pode ser negativo")
    private Integer numeroBanheiros;

    @Min(value = 0, message = "O número de suites não pode ser negativo")
    private Integer numeroSuites;

    @Min(value = 0, message = "O número de garagens não pode ser negativo")
    private Integer numeroGaragem;

    @Min(value = 0, message = "O preco não pode ser negativo")
    private Double preco;

    @NotNull(message = "O status do imovel não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private StatusImovel status;

    @NotNull(message = "O tipo do imovel não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private TipoImovel tipo;
}
