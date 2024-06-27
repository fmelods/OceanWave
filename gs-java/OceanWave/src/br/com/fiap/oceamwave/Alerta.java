package br.com.fiap.oceamwave;

public class Alerta {
    private Medicao medicao;
    private String detalhes;

    public Alerta(Medicao medicao, String detalhes) {
        this.medicao = medicao;
        this.detalhes = detalhes;
    }

    // Sobrescrita do método toString
    @Override
    public String toString() {
        return "Alerta: " + detalhes + " | Data/Hora: " + medicao.getDt_hora() + " | Temperatura: " + medicao.getTemp();
    }

    // Getters e Setters
    public Medicao getMedicao() { return medicao; }
    public void setMedicao(Medicao medicao) { this.medicao = medicao; }

    public String getDetalhes() { return detalhes; }
    public void setDetalhes(String detalhes) { this.detalhes = detalhes; }
}
