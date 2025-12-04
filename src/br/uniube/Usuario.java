package br.uniube;

public class Usuario extends Pessoa {
    public Usuario(String nome) {
        super(nome);
    }

    @Override
    public String getTipo() {
        return "Usuário";
    }
}
