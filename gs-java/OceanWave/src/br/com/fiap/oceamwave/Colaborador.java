package br.com.fiap.oceamwave;

public class Colaborador {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private int senha;

    public Colaborador(String nome, String endereco, String telefone, String email, int senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
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

    public int getSenha() { return senha; }
    public void setSenha(int senha) { this.senha = senha; }
}
