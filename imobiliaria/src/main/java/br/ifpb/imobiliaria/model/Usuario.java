package br.ifpb.imobiliaria.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotEmpty
    private String nome;

    @NotNull
    @Column(unique = true)
    @Email
    private String email;

    @NotEmpty
    @NotNull
//    @Pattern(regexp="\\(\\d{2}\\)\\s\\d{5}-\\d{4}", message="Formato de telefone inválido")
    private String telefone;

    @NotEmpty
    @Pattern(regexp="\\d{11}", message="CPF inválido")
    private String cpf;

    @NotEmpty
    @NotNull
    @Length(min = 8)
    private String senha;

    private boolean isAdmin;
}
