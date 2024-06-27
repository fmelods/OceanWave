package br.com.fiap.oceamwave;

import java.util.ArrayList;
import java.util.List;

public class Ong {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private List<Sensor> sensores;

    public Ong(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.sensores = new ArrayList<>();
    }

    public void adicionarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    


    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    public void alterarDados(Ong ong) {
        // Implementação do método para alterar dados
    }
}
