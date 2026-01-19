@ConsultaUsuarioIndividual
Feature: Consultar Usuário Individual


  Scenario Outline: CT01: Consultar Usuário Individual
    Given que realize requisição GET de usuário com id "<id>"
    Then retorna status code 200 com usuário válido

    Examples:
    | id                |
    | 0uxuPY0cbmQhpEz1  |


  Scenario Outline: : CT02: Consultar Usuário Inexistente
    Given que realize requisição GET de usuário com id "<inexiste>"
    Then retorna status code 400 com erro de "Usuário não encontrado"

    Examples:
      |  inexiste         |
      | 0uxuPY0cbmQhpEz2  |