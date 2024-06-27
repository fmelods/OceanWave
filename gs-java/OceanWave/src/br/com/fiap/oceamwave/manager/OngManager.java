package br.com.fiap.oceamwave.manager;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.oceamwave.Ong;

public class OngManager {
    private List<Ong> ongList;

    public OngManager() {
        this.ongList = new ArrayList<>();
    }

    public void adicionarOng(Ong ong) {
        ongList.add(ong);
    }

    public Ong buscarOngPorNome(String nome) {
        for (Ong ong : ongList) {
            if (ong.getNome().equals(nome)) {
                return ong;
            }
        }
        return null;
    }

    public List<Ong> getOngList() {
        return ongList;
    }
}
