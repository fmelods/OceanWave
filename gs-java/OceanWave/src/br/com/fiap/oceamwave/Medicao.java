package br.com.fiap.oceamwave;

public class Medicao {
    private String dt_hora;
    private String tipo;
    private int temp;
    private String outrosDetalhes;

    public Medicao(String dt_hora, String tipo, int temp, String outrosDetalhes) {
        this.dt_hora = dt_hora;
        this.tipo = tipo;
        this.temp = temp;
        this.outrosDetalhes = outrosDetalhes;
    }

    public Alerta gerarAlerta() {
        if (this.temp > 30) {
            return new Alerta(this, "Temperatura acima do normal");
        } else if (this.temp < 10) {
            return new Alerta(this, "Temperatura abaixo do normal");
        }
        return null;
    }

    // Getters e Setters
    public String getDt_hora() { return dt_hora; }
    public void setDt_hora(String dt_hora) { this.dt_hora = dt_hora; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getTemp() { return temp; }
    public void setTemp(int temp) { this.temp = temp; }

    public String getOutrosDetalhes() { return outrosDetalhes; }
    public void setOutrosDetalhes(String outrosDetalhes) { this.outrosDetalhes = outrosDetalhes; }
}
