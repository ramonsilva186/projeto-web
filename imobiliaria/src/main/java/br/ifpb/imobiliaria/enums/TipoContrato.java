package br.ifpb.imobiliaria.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoContrato {
    COMPRA("COMPRA", 1),
    ALUGUEL("ALUGUEL", 2),
    FINANCIAMENTO("FINANCIAMENTO", 3);

    private final String value;
    private final Integer id;
}
