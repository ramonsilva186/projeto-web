package br.ifpb.imobiliaria.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusImovel {
    DISPONIVEL("DISPONIVEL"),
    INDISPONIVEL("INDISPONIVEL");

    private final String value;
}
