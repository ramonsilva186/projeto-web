package br.ifpb.imobiliaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
@EqualsAndHashCode(of = "idCliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @NotBlank
    private String nome;
    @NotBlank
    @Column(length = 14, unique = true, nullable = false)
    private String cpf;
    @NotBlank
    private String endereco;
    private String telefone;
    @Email
    private String email;
}
