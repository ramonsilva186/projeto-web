package br.ifpb.imobiliaria.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum TipoImovel {
    CASA("CASA"),
    APARTAMENTO("APARTAMENTO"),
    TERRENO("TERRENO"),
    COMERCIAL("COMERCIAL");

    private final String value;

}
