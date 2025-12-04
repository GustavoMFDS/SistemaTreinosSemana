package br.uniube;

public class Exercicio {
    private String nome;
    private String grupoMuscular;
    private int duracaoMinutos;
    private boolean concluido;

    public Exercicio(String nome, String grupoMuscular, int duracaoMinutos) {
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.duracaoMinutos = duracaoMinutos;
        this.concluido = false;
    }


    public String getNome() { return nome; }
    public String getGrupoMuscular() { return grupoMuscular; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    public boolean isConcluido() { return concluido; }


    public void concluir() { this.concluido = true; }
    public void desmarcar() { this.concluido = false; }

    @Override
    public String toString() {
        return nome + " (" + grupoMuscular + ", " + duracaoMinutos + " min)";
    }
}