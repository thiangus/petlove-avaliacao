# Avaliação petlove

Para solução tenter pensar em como escalar o sistema, utilizei spring boot, pois ele abstrai muito bem tecnologias de mercado, JPA, RABBITMQ, KAFKA e etc
  
  - Banco H2 em memória com compatibilidade do postgres
  - JSF de exemplo(acabei focando na estrutura com o tempo que tinha) 2 dias/periodo da noite
  - Utilizo spring data que abstrai o hibernate, e usei method name query para fazer a busca, o spring data ja retorna Optional o que dá segurança
  - Rest utilizei de rest para fazer o crud, está bem simples. O ideal é implementar um openApi
  
  
# Arquitetura

  - Foquei no desacoplamento, não queria que o objeto da entidade ficasse no view, isso facilita criar microservicos
  - Separei os modulos de maneira que fique claro e de facil reutilização, tanto que tem um serviço que é utilizado pelo actin bean e outro rest


# Hospedado Heroku
 
 - Esta automatico o deploy se commitar reflete no pipeline integrado entre o heroku e o git
 url no email

# Como executar

``` sh 
https://thiago-test-petlove.herokuapp.com/raca.xhtml
```

Para castramento gerei collection para facilitar só importar no Postman, entrar no postman e importar pelo link
```
link no email
```

## Questões - Colocar somente as querys

Inclua os trechos com as queries que respondem as perguntas abaixo:

### Quantos agendamentos existem para o Rex do Jhonny Cash?

    select  count(agend.id) from  animal a
    inner join agenda agend on a.id = agend.animal_id
    inner join proprietario p on agend.proprietario_id = p.id
    where p.nome = 'Jhonny Cash'


### Como saber se temos algum Cavalo cadastrado como animal?

    
select a.nome from animal a
    inner join especie e on a.especie_id = e.id
    where e.nome = 'Cavalo

### Buscar todos os agendamentos com dados do animal, serviço e proprietário

    
select agend.* from agenda agend
    inner join animal a on a.id = agend.animal_id
    inner join servico s on agend.servico_id = s.id
    inner join proprietario p on agend.proprietario_id = p.id
    where s.descricao = 'Banho e Tosa'
    and a.nome = 'Bryan'
    and p.nome = 'Jonny Cash'
    

### Se o petshop trabalhar todos os dias com os mesmos agendamentos, quanto ele faturará em 3 meses considerando que 1 mês = 30 dias.

    select sum(s.valor) from agenda agend
        inner join servico s on s.id = agend.servico_id
        where to_timestamp(agend.horario) < NOW() - INTERVAL '30 days' 

### Quanto tempo falta para o agendamento do Rex, do Sid Vicious, considerando que agora são 11h?

    Usar beteween    

### Como incrementar o valor de venda de todos os serviços que foram agendados no mês passado?

    ??
