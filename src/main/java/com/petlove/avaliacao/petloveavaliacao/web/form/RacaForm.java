package com.petlove.avaliacao.petloveavaliacao.web.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
@Data
@Getter
@Setter
public class RacaForm implements Serializable {
   private Integer code;
   private String nome;

   @Override
   public String toString() {
      return "RacaForm{" +
              "code=" + code +
              ", nome='" + nome + '\'' +
              '}';
   }
}
