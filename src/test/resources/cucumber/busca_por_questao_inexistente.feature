# language: pt

Funcionalidade: Busca no Banco de Questoes
  Cenario: Busca por questão inexistente
    Dado que navego para a pagina de busca do banco de questoes
    Quando digito 'Science Computers' no campo de busca
    E clico no botao de buscar
    Entao visualizo uma mensagem de erro com o texto 'No questions found.'

  Cenario: Busca por categoria especifica
    Dado que navego para a pagina de busca do banco de questoes
    Quando digito 'Science: Computers' no campo de busca
    E seleciono a opção 'Category'
    Entao visualizo 25 itens na listagem
    E visualizo a paginação

  Cenario: Cadastro de pergunta sem login efetuado
    Dado que acesso a pagina inicial do site sem logar
    Quando adicionar uma nova pergunta
    Entao visualizo uma mensagem de erro com o texto 'ERROR! You must be logged in to submit a trivia question.'