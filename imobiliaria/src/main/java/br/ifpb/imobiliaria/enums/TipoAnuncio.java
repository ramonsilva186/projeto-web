package br.ifpb.imobiliaria.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoAnuncio {
    VENDA("VENDA"),
    ALUGUEL("ALUGUEL");

    private final String value;
}
