# UOL HOST Challenge

Este projeto implementa uma interface para o gerenciamento de jogadores utilizando **Thymeleaf** como motor de template, oferecendo as funcionalidades de listar e cadastrar jogadores.
A interface é responsiva, com estilização moderna, e permite manipular os dados de forma intuitiva.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Thymeleaf**
- **HTML5**
- **CSS3**
- **JavaScript (Vanilla)**

## Arquitetura

![Arquitetura do projeto](/docs/arquitetura.png)


## Funcionalidades

1. **Listagem de Jogadores:**
    - Exibe uma tabela com os jogadores cadastrados contendo as colunas Nome, E-mail, Telefone, Codinome e Grupo.
2. **Cadastro de Jogadores:**
    - Formulário acessível após clicar no botão "Novo jogador".
    - Persistência dos dados é feita via um POST para o endpoint `/players`.
    - Os dados são persistiidos em arquivo ou em memória
3. **Limpar Jogadores:**
    - Botão para limpar todos os jogadores cadastrados.

## Como Executar o Projeto

1. **Clone o Repositório:**
   ```bash
   git clone https://github.com/Rosivaldo-Lucas/challenge-uol-host.git
   cd challenge-uol-host
   ```

2. **Configure o Ambiente:**
    - Certifique-se de ter o Java 11+ e o Maven instalados.
    - Configure as dependências do Spring Boot no arquivo `pom.xml`.

3. **Inicie a Aplicação:**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse no Navegador:**
    - Abra `http://localhost:8080/index`.

## Estrutura do Projeto

- **src/main/java:** Contém a lógica de negócio e os controladores.
- **src/main/resources/templates:** Arquivos HTML utilizando Thymeleaf.
- **src/main/resources/static:** Arquivos de estilo e scripts.

## Melhorias Futuras

- Implementar a funcionalidade de edição.
- Melhorar a responsividade para dispositivos menores.
- Conectar com um banco de dados para persistência real.

## Contribuição

1. Faça um fork do repositório.
2. Crie um branch para sua feature (`git checkout -b feature/nome-da-feature`).
3. Commit suas alterações (`git commit -m 'Adiciona nova feature'`).
4. Envie para o branch (`git push origin feature/nome-da-feature`).
5. Abra um Pull Request.
