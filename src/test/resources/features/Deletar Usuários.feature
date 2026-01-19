@DeletarUsuarios
Feature: Deletar de Usuários

  Scenario: CT01: Deletar Usuário com Sucesso
    Given que realize requisição DELETE removendo usuário
    Then retorna status code 200 com mensagem "Registro excluído com sucesso"


  Scenario Outline: CT02: Deletar Usuário Inexistente
    Given que realize requisição DELETE usuario inexistente "<id>"
    Then retorna status code 200 com mensagem "Nenhum registro excluído"

    Examples:
      | id       |
      | inexiste |