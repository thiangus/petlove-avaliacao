package com.petlove.avaliacao.petloveavaliacao.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RacaVO {

    private Integer code;
    private String nome;

    @Override
    public String toString() {
        return "RacaVO{" +
                "code='" + code + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
