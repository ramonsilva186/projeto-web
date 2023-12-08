package br.ifpb.imobiliaria.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum StatusAnuncio {
    ATIVO("ATIVO"),
    INATIVO("INATIVO");

    private final String value;
}
