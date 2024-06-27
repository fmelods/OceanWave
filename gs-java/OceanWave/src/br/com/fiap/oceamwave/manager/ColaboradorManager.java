package br.com.fiap.oceamwave.manager;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.oceamwave.Colaborador;

public class ColaboradorManager {
    private List<Colaborador> colaboradores;

    public ColaboradorManager() {
        this.colaboradores = new ArrayList<>();
    }

    public void adicionarColaborador(Colaborador colaborador) {
        colaboradores.add(colaborador);
    }

    public Colaborador buscarPorEmailESenha(String email, int senha) {
        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getEmail().equals(email) && colaborador.getSenha() == senha) {
                return colaborador;
            }
        }
        return null;
    }
}
