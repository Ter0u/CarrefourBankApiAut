📈**OBJETIVO**

Desenvolvimento de script de automação de testes em java e restassured para execução de teste de api dentro dos critérios de aceite propostos no desafio técnico do Carrefour

**COBERTURA DE TESTES**

Os testes deste desafio foram planejados para cobrir o CRUD do endpoint  /usuarios conforme API documentada em https://serverest.dev/#/

Segue os cenários levantados:
| Endpoint | Cenários Testados |
|----------|-------------------|
| POST `/usuarios` | ✅ Cadastrar Novo Usuário com Sucesso<br>✅ Cadastrar Usuário com Email já em Uso<br>✅ Cadastrar Usuário com Email Inválido<br>✅ Cadastrar Usuário sem Nome<br>✅ Cadastrar Usuário sem Email<br>✅ Cadastrar Usuário sem Password <br>✅ Cadastrar Usuário sem Administrador|
| GET `/usuarios` | ✅ Consultar lista de usuários com sucesso<br>✅ Consultar lista de usuários filtrando por id<br>✅ Consultar lista de usuários filtrando por nome<br>✅ Consultar lista de usuários filtrando por email<br>✅ Consultar lista de usuários filtrando por password<br>✅ Consultar lista de usuários filtrando de administrador |
| GET `/usuarios/{id}` | ✅ Consultar Usuário Individual<br>✅ Consultar Usuário Inexistente |
| DELETE `/usuarios/{id}` | ✅ Deletar Usuário com Sucesso<br>✅ Deletar Usuário Inexistente |
| PUT `/usuarios/{id}` | ✅ Editar usuário com sucesso<br>✅ Editar usuário inexistente<br>✅ Editar usuário informando email duplicado |

**COMO CONFIGURAR E EXECUTAR SCRIPT DE AUTOMAÇÃO:**

✅ PASSO 1 — Instalar IDE
- Instalar o Intellij por https://www.jetbrains.com/idea/download/?section=windows
OU
- Instalar o Eclipse por https://eclipseide.org/

✅ PASSO 2 — Instalar Java
- Instalar Java JDK superior a 8 para evitar problemas por https://www.oracle.com/java/technologies/downloads/

✅ PASSO 3 — Instalar Maven
- Instalar o Maven por https://maven.apache.org/download.cgi

✅ PASSO 4 — Importar projeto maven na IDE

1️⃣ IntelliJ IDEA
- Abra o IntelliJ IDEA.

- Vá em File → New → Project from Existing Sources…

- Navegue até a pasta raiz do projeto (onde está o pom.xml) e clique em OK.

- Selecione Import project from external model → Maven.

- Clique em Next e configure:

- Project SDK: selecione a versão do Java que o projeto usa.

- Maven home directory: deixe como Bundled (Maven), ou selecione seu Maven local.

- Clique em Next → Finish.

- O IntelliJ vai carregar as dependências do pom.xml e configurar o projeto.

2️⃣ Eclipse
- Importando um projeto Maven existente

- Abra o Eclipse.

- Vá em File → Import…

- Escolha Maven → Existing Maven Projects, clique em Next.

- Clique em Browse e selecione a pasta raiz do projeto (onde está o pom.xml).

- O Eclipse vai detectar automaticamente o pom.xml. Marque o projeto na lista.

- Clique em Finish.

- O Eclipse vai baixar as dependências e configurar o projeto como Maven Project.

✅ PASSO 5 — Mãos na Massa
- Uma vez que todas as dependências foram instaladas, basta acessar src/test/java/RunnertTest.java

- Clicar com botão direito na classe

- E executar!

- Após a execução será armazenado o relatório do allure report na targe como cucumber-report.html com o resultado da execução com sucesso
