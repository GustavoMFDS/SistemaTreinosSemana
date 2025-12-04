Sistema de Controle de Treinos Semanais

Nome do Projeto
Sistema de Controle de Treinos Semanais

Descrição

Este projeto foi desenvolvido como parte da disciplina Programação Orientada a Objetos (POO) na UNIUBE.
O objetivo é criar uma aplicação em Java com interface gráfica Swing que ajude pessoas a organizarem seus treinos semanais.

A aplicação permite:
- Cadastrar exercícios com nome, grupo muscular e duração.
- Associar exercícios a dias da semana.
- Marcar exercícios como concluídos ou desmarcados.
- Remover exercícios cadastrados.
- Visualizar todos os treinos organizados em uma tabela.
- Acompanhar o progresso semanal em porcentagem.

O público-alvo inclui estudantes, praticantes de academia e qualquer pessoa que queira monitorar seus treinos de forma simples e prática.

Objetivos da Aplicação

- Facilitar o planejamento e organização da rotina de treinos.
- Permitir a visualização dos exercícios separados por dia da semana.
- Registrar quando um exercício foi realizado.
- Acompanhar o progresso semanal do usuário.
- Servir como base prática para aplicar os conceitos de POO.


Tecnologias Utilizadas

- Java 17
- Swing (interface gráfica)
- GitHub (versionamento e entrega)

Estrutura do Código

O projeto foi organizado em pacotes para separar lógica de domínio e interface gráfica:
src/
 ├── dominio/
 │    ├── Exercicio.java
 │    ├── Semana.java
 │    └── Progresso.java
 └── ui/
      └── TelaPrincipal.java


Classes de Domínio

- Exercicio.java
Representa um exercício com atributos: nome, grupo muscular, duração e status (concluído ou pendente).
- Encapsulamento com atributos privados.
- Métodos auxiliares (getNome, getGrupoMuscular, getDuracaoMinutos, concluir, desmarcar).
- Sobrescrita de toString() para exibir informações de forma legível.
- Semana.java
Representa a semana de treinos, armazenando exercícios em um Map<String, List<Exercicio>>.
- Permite adicionar exercícios por dia.
- Retorna lista de exercícios de cada dia.
- Implementa a interface Progresso para calcular o percentual de treinos concluídos.
- Progresso.java
Interface que define o comportamento de cálculo de progresso semanal.
Interface Gráfica (Swing)

- TelaPrincipal.java
- Usa JTable para exibir os exercícios em colunas: Dia, Nome, Grupo Muscular, Duração, Status.
- Botões para Cadastrar, Concluir, Desmarcar, Remover e Atualizar Lista.
- Integração direta com as classes de domínio (Semana e Exercicio).
- Exibe o progresso semanal em um JLabel.

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

