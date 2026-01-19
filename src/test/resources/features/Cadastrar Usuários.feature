@CadastrarUsuarios
Feature: Cadastro de Usuários

  Scenario: CT01: Cadastrar Novo Usuário com Sucesso
    Given que realize requisição POST criando novo usuário
    Then retorna status code 201 com usuário criado com sucesso


  Scenario: CT02: Cadastrar Usuário com Email já em Uso
    Given que realize requisição POST criando usuário com email em uso
    Then retorna status code 400 com erro "Este email já está sendo usado"


  Scenario: CT03: Cadastrar Usuário com Email Inválido
    Given que realize requisição POST criando usuário com email inválido
    Then retorna status code 400 com erro de email "email deve ser um email válido"


  Scenario: CT04: Cadastrar Usuário sem Nome
    Given que realize requisição POST criando usuário sem nome
    Then retorna status code 400 com erro de nome "nome é obrigatório"


  Scenario: CT05: Cadastrar Usuário sem Email
    Given que realize requisição POST criando usuário sem email
    Then retorna status code 400 com erro de email "email é obrigatório"


  Scenario: CT06: Cadastrar Usuário sem Password
    Given que realize requisição POST criando usuário sem password
    Then retorna status code 400 com erro de password "password é obrigatório"


  Scenario: CT07: Cadastrar Usuário sem Administrador
    Given que realize requisição POST criando usuário sem administrador
    Then retorna status code 400 com erro de administrador "administrador é obrigatório"