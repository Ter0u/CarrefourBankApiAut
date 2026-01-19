@EditarUsuarios
Feature: Editar de Usuários

  Scenario Outline: CT01: Editar usuário com sucesso
    Given que realize requisição PUT editando usuário "<id>"
    Then retorna status code 200 com "Registro alterado com sucesso"

    Examples:
      | id               |
      | 0uxuPY0cbmQhpEz1 |


  Scenario: CT02: Editar usuário inexistente
    Given que realize requisição PUT editando usuário inexistente
    Then retorna status code 201 com "Cadastro realizado com sucesso"


 Scenario Outline: CT03: Editar usuário informando email duplicado
    Given que realize requisição PUT editando usuário com usuário duplicado "<id>"
    Then retorna status code 400 com "Este email já está sendo usado"

    Examples:
      | id               |
      | oYR2TNZIPxm7TGGB |