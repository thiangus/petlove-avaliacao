package com.petlove.avaliacao.petloveavaliacao.service;

import com.petlove.avaliacao.petloveavaliacao.vo.RacaVO;

public interface RacaService {
    RacaVO inserir(RacaVO racaVO);
    RacaVO buscarPorNome(String nome);
}
