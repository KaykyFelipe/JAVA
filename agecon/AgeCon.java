/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agecon;

/**
 *
 * @author felip
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;


public class AgeCon {

    public static void main(String[] args) {
        // Menu inicial para escolher entre Console ou GUI
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o modo de operação:");
        System.out.println("1 - Modo Console");
        System.out.println("2 - Modo GUI (Interface Gráfica)");
        System.out.print("Digite a opção (1 ou 2): ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir o '\n' restante

        if (opcao == 1) {
            iniciarModoConsole();
        } else if (opcao == 2) {
            iniciarModoGUI();
        } else {
            System.out.println("Opção inválida!");
        }
    }

    // Função para iniciar o modo Console
    public static void iniciarModoConsole() {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Agenda de Contatos ====");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Atualizar Contato");
            System.out.println("4. Remover Contato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir o '\n'

            switch (opcao) {
                case 1:
                    // Adicionar Contato
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone do contato: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Digite o email do contato: ");
                    String email = scanner.nextLine();
                    Contato novoContato = new Contato(nome, telefone, email);
                    agenda.adicionarContato(novoContato);
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 2:
                    // Listar Contatos
                    System.out.println("Lista de Contatos:");
                    List<Contato> contatos = agenda.listarContatos();
                    if (contatos != null && !contatos.isEmpty()) {
                        contatos.forEach(contato -> System.out.println(contato));
                    } else {
                        System.out.println("Nenhum contato encontrado.");
                    }
                    break;
                case 3:
                    // Atualizar Contato
                    System.out.print("Digite o nome do contato que deseja atualizar: ");
                    String nomeParaAtualizar = scanner.nextLine();
                    System.out.print("Digite o novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    System.out.print("Digite o novo email: ");
                    String novoEmail = scanner.nextLine();
                    if (agenda.atualizarContato(nomeParaAtualizar, novoTelefone, novoEmail)) {
                        System.out.println("Contato atualizado com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 4:
                    // Remover Contato
                    System.out.print("Digite o nome do contato que deseja remover: ");
                    String nomeParaRemover = scanner.nextLine();
                    if (agenda.removerContato(nomeParaRemover)) {
                        System.out.println("Contato removido com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 5:
                    // Sair
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Função para iniciar o modo GUI (Swing)
    public static void iniciarModoGUI() {
        Agenda agenda = new Agenda();

        // Configuração da janela
        JFrame frame = new JFrame("Agenda de Contatos");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel para as ações
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));

        // Campos de texto para inserção de dados
        JTextField nomeField = new JTextField();
        JTextField telefoneField = new JTextField();
        JTextField emailField = new JTextField();

        // Labels
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);

        // Botões de ação
        JButton adicionarButton = new JButton("Adicionar Contato");
        JButton listarButton = new JButton("Listar Contatos");
        JButton atualizarButton = new JButton("Atualizar Contato");
        JButton removerButton = new JButton("Remover Contato");

        // Área de texto para mostrar a lista de contatos
        JTextArea listaArea = new JTextArea();
        listaArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaArea);
        scrollPane.setPreferredSize(new Dimension(500, 150));

        // Adicionando os botões no painel
        panel.add(adicionarButton);
        panel.add(listarButton);
        panel.add(atualizarButton);
        panel.add(removerButton);
        panel.add(new JLabel("Lista de Contatos:"));
        panel.add(scrollPane);

        // Adicionando o painel na janela
        frame.add(panel);
        frame.setVisible(true);

        // Ação do botão "Adicionar Contato"
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String telefone = telefoneField.getText();
                String email = emailField.getText();
                if (!nome.isEmpty() && !telefone.isEmpty() && !email.isEmpty()) {
                    Contato novoContato = new Contato(nome, telefone, email);
                    agenda.adicionarContato(novoContato);
                    JOptionPane.showMessageDialog(frame, "Contato adicionado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.");
                }
            }
        });

        // Ação do botão "Listar Contatos"
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaArea.setText("");
                List<Contato> contatos = agenda.listarContatos();
                for (Contato contato : contatos) {
                    listaArea.append(contato + "\n\n");
                }
            }
        });

        // Ação do botão "Atualizar Contato"
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String novoTelefone = telefoneField.getText();
                String novoEmail = emailField.getText();
                if (agenda.atualizarContato(nome, novoTelefone, novoEmail)) {
                    JOptionPane.showMessageDialog(frame, "Contato atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Contato não encontrado!");
                }
            }
        });

        // Ação do botão "Remover Contato"
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                if (agenda.removerContato(nome)) {
                    JOptionPane.showMessageDialog(frame, "Contato removido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Contato não encontrado!");
                }
            }
        });
    }
}

