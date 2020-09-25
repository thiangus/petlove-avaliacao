package com.petlove.avaliacao.petloveavaliacao.web.action;

import com.petlove.avaliacao.petloveavaliacao.vo.RacaVO;
import com.petlove.avaliacao.petloveavaliacao.service.RacaService;
import com.petlove.avaliacao.petloveavaliacao.web.form.RacaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.io.Serializable;

@Component
@RequestScope
public class RacaAction implements Serializable
{
    private final RacaForm racaForm;
    private  RacaService racaService;

    public RacaAction(@Autowired RacaForm racaForm,
                      @Autowired RacaService racaService) {
        this.racaForm = racaForm;
        this.racaService = racaService;
    }

    public void buscarPorNomeRaca(String nome) {
        RacaVO racaVO = racaService.buscarPorNome(nome);
        racaForm.setCode(racaVO.getCode());
        racaForm.setNome(racaVO.getNome());
    }
}