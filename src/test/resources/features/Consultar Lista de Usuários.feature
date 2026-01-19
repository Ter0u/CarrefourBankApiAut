@ConsultarListaDeUsuários
Feature: Consultar Lista de Usuários

  Scenario: CT01: Consultar lista de usuários com sucesso
    Given que realize requisição GET para o endpoint de lista de usuários
    Then retorna status code 200 com uma lista de usuários


  Scenario Outline: CT02: Consultar lista de usuários filtrando por id
    Given que realize requisição GET para o endpoint de lista de usuários filtrando por id "<id>"
    Then retorna status code 200 com um usuário de ID "<id>"

    Examples:
      | id               |
      | 0uxuPY0cbmQhpEz1 |


  Scenario Outline: CT03: Consultar lista de usuários filtrando por nome
    Given que realize requisição GET para o endpoint de lista de usuários filtrando por nome "<nome>"
    Then retorna status code 200 com um usuário de nome "<nome>"

    Examples:
      | nome            |
      | Fulano da Silva |


  Scenario Outline: CT04: Consultar lista de usuários filtrando por email
    Given que realize requisição GET para o endpoint de lista de usuários filtrando por email "<email>"
    Then retorna status code 200 com um usuário de email "<email>"

    Examples:
      | email         |
      | beltro@qa.com.br |


  Scenario Outline: CT05: Consultar lista de usuários filtrando por password
    Given que realize requisição GET para o endpoint de lista de usuários filtrando por password "<password>"
    Then retorna status code 200 com um usuário de password "<password>"

    Examples:
      | password |
      | teste    |


  Scenario Outline: CT06: Consultar lista de usuários filtrando de administrador
    Given que realize requisição GET para o endpoint de lista de usuários filtrando por administrador "<administrador>"
    Then retorna status code 200 com um usuário de administrador "<mustNot>"

    Examples:
      | administrador | mustNot |
      | true          | false   |
      | false         | true    |