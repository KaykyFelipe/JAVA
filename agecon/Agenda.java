/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agecon;

/**
 *
 * @author kayky
 */
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    // Método para adicionar um novo contato
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    // Método para listar os contatos (agora retorna uma lista de contatos)
    public List<Contato> listarContatos() {
        return contatos; // Retorna a lista de contatos
    }

    // Método para atualizar um contato
    public boolean atualizarContato(String nome, String novoTelefone, String novoEmail) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contato.setTelefone(novoTelefone);
                contato.setEmail(novoEmail);
                return true;
            }
        }
        return false;
    }

    // Método para remover um contato
    public boolean removerContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(contato);
                return true;
            }
        }
        return false;
    }
}

