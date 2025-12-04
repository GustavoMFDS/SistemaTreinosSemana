package br.uniube;

import java.util.*;

public class Semana implements Progresso {
    private Map<String, List<Exercicio>> treinosPorDia;

    public Semana() {
        treinosPorDia = new HashMap<>();
        for (String dia : Arrays.asList("Segunda","Terça","Quarta","Quinta","Sexta","Sábado","Domingo")) {
            treinosPorDia.put(dia, new ArrayList<>());
        }
    }

    public void adicionarExercicio(String dia, Exercicio e) {
        if (treinosPorDia.containsKey(dia)) {
            treinosPorDia.get(dia).add(e);
        }
    }

    public List<Exercicio> getExercicios(String dia) {
        return treinosPorDia.getOrDefault(dia, new ArrayList<>());
    }

    public Set<String> getDias() {
        return treinosPorDia.keySet();
    }

    @Override
    public double calcularProgressoSemanal() {
        int total = 0, concluidos = 0;
        for (List<Exercicio> lista : treinosPorDia.values()) {
            total += lista.size();
            for (Exercicio e : lista) {
                if (e.isConcluido()) concluidos++;
            }
        }
        return total == 0 ? 0 : (concluidos * 100.0 / total);
    }
}