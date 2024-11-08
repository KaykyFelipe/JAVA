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


    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }


    public List<Contato> listarContatos() {
        return contatos; 
    }

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

