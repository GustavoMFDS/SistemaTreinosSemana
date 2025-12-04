package ui;

import br.uniube.Exercicio;
import br.uniube.Semana;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    private Semana semana;
    private JTable tabela;
    private DefaultTableModel modelo;
    private JLabel lblProgresso;

    public TelaPrincipal() {
        semana = new Semana();

        setTitle("Sistema de Controle de Treinos Semanais");
        setSize(700,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //tabela
        modelo = new DefaultTableModel(new Object[]{"Dia", "Nome", "Grupo Muscular", "Duração (min)", "Status"}, 0);
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        //botoes
        JPanel painel = new JPanel();
        JButton btnCadastrar = new JButton("Cadastrar Exercício");
        JButton btnConcluir = new JButton("Marcar Concluído");
        JButton btnDesmarcar = new JButton("Desmarcar");
        JButton btnRemover = new JButton("Remover");
        JButton btnExibir = new JButton("Atualizar Lista");
        lblProgresso = new JLabel("Progresso: 0%");

        painel.add(btnCadastrar);
        painel.add(btnConcluir);
        painel.add(btnDesmarcar);
        painel.add(btnRemover);
        painel.add(btnExibir);
        painel.add(lblProgresso);

        add(painel, BorderLayout.SOUTH);


        btnCadastrar.addActionListener(e -> cadastrarExercicio());
        btnConcluir.addActionListener(e -> marcarConcluido(true));
        btnDesmarcar.addActionListener(e -> marcarConcluido(false));
        btnRemover.addActionListener(e -> removerExercicio());
        btnExibir.addActionListener(e -> atualizarTabela());
    }

    private void cadastrarExercicio() {
        String nome = JOptionPane.showInputDialog("Nome do exercício:");
        if (nome == null || nome.trim().isEmpty()) return;

        String grupo = JOptionPane.showInputDialog("Grupo muscular:");
        if (grupo == null || grupo.trim().isEmpty()) return;

        String duracaoStr = JOptionPane.showInputDialog("Duração (min):");
        if (duracaoStr == null || duracaoStr.trim().isEmpty()) return;

        int duracao;
        try {
            duracao = Integer.parseInt(duracaoStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um número válido para a duração!");
            return;
        }

        String dia = JOptionPane.showInputDialog("Dia da semana:");
        if (dia == null || dia.trim().isEmpty()) return;

        Exercicio ex = new Exercicio(nome, grupo, duracao);
        semana.adicionarExercicio(dia, ex);
        atualizarTabela();
    }

    private void marcarConcluido(boolean status) {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            String dia = (String) modelo.getValueAt(linha, 0);
            String nome = (String) modelo.getValueAt(linha, 1);
            for (Exercicio e : semana.getExercicios(dia)) {
                if (e.getNome().equals(nome)) {
                    if (status) e.concluir();
                    else e.desmarcar();
                }
            }
            atualizarTabela();
        }
    }


    private void removerExercicio() {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            String dia = (String) modelo.getValueAt(linha, 0);
            String nome = (String) modelo.getValueAt(linha, 1);
            semana.getExercicios(dia).removeIf(e -> e.toString().contains(nome));
            atualizarTabela();
        }
    }

    private void atualizarTabela() {
        modelo.setRowCount(0); // limpa tabela
        for (String dia : semana.getDias()) {
            for (Exercicio e : semana.getExercicios(dia)) {
                modelo.addRow(new Object[]{
                        dia,
                        e.getNome(),
                        e.getGrupoMuscular(),
                        e.getDuracaoMinutos(),
                        e.isConcluido() ? "Concluído" : "Pendente"
                });
            }
        }
        lblProgresso.setText("Progresso: " + semana.calcularProgressoSemanal() + "%");
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}