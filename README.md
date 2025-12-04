
Nome do Projeto
Sistema de Controle de Treinos Semanais

Descrição

Este projeto foi desenvolvido como parte da disciplina Programação Orientada a Objetos (POO) na UNIUBE.
O objetivo é criar uma aplicação em Java com interface gráfica Swing que ajude pessoas a organizarem seus treinos semanais.

Objetivos da Aplicação

- Facilitar o planejamento e organização da rotina de treinos.
- Permitir a visualização dos exercícios separados por dia da semana.
- Registrar quando um exercício foi realizado.
- Acompanhar o progresso semanal do usuário.
- Servir como base prática para aplicar os conceitos de POO.

Tecnologias Utilizadas

- Java 17
- Swing (interface gráfica)

Estrutura do Código

O projeto foi organizado em pacotes para separar lógica de domínio e interface gráfica:
src/
  dominio/
    Exercicio.java
    Semana.java
    Progresso.java
  ui/
    TelaPrincipal.java


Funcionalidades

- Cadastro de Exercícios: o usuário informa nome, grupo muscular, duração e dia da semana.
- Listagem: todos os exercícios aparecem organizados em uma tabela.
- Marcar Concluído/Desmarcar: selecionando uma linha da tabela, o usuário pode alterar o status do exercício.
- Remover Exercício: exclui um exercício da lista.
- Progresso Semanal: mostra a porcentagem de exercícios concluídos.

Como Executar
- Clone o repositório ou baixe o ZIP.
- Compile os arquivos:
javac dominio/*.java ui/*.java
- Execute a aplicação:
java ui.TelaPrincipal


Integrantes da Equipe
- Gustavo Marques Fernandes de Sousa 
- Gustavo Henrique Souto

