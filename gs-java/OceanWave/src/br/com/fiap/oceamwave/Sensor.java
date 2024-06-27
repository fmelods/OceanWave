package br.com.fiap.oceamwave;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private String localizacao;
    private String tipo;
    private String status;
    private String dt_instalacao;
    private Ong fonteOng;
    private List<Medicao> medicoes;
    private List<Alerta> alertas;

    public Sensor(String localizacao, String tipo, String status, String dt_instalacao, Ong fonteOng) {
        this.localizacao = localizacao;
        this.tipo = tipo;
        this.status = status;
        this.dt_instalacao = dt_instalacao;
        this.fonteOng = fonteOng;
        this.medicoes = new ArrayList<>();
        this.alertas = new ArrayList<>();
    }

    // Sobrecarga do método adicionarMedicao
    public void adicionarMedicao(Medicao medicao) {
        this.medicoes.add(medicao);
        Alerta alerta = medicao.gerarAlerta();
        if (alerta != null) {
            this.alertas.add(alerta);
        }
    }

    public void adicionarMedicao(String dt_hora, String tipo, int temp, String outrosDetalhes) {
        Medicao medicao = new Medicao(dt_hora, tipo, temp, outrosDetalhes);
        this.adicionarMedicao(medicao);
    }

    public List<Medicao> getMedicoes() {
        return medicoes;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    // Getters e Setters
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDt_instalacao() { return dt_instalacao; }
    public void setDt_instalacao(String dt_instalacao) { this.dt_instalacao = dt_instalacao; }

    public Ong getFonteOng() { return fonteOng; }
    public void setFonteOng(Ong fonteOng) { this.fonteOng = fonteOng; }

    public void setMedicoes(List<Medicao> medicoes) { this.medicoes = medicoes; }
    public void setAlertas(List<Alerta> alertas) { this.alertas = alertas; }
}
