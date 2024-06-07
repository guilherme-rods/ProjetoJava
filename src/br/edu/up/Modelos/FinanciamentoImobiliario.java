package br.edu.up.Modelos;

public class FinanciamentoImobiliario extends Financiamento {

    private int NumContratoImobiliario;
    private double valorFinanciamentoImobiliario;

    public FinanciamentoImobiliario(int categoria, int numContratoImobiliario, double valorFinanciamentoImobiliario) {
        super(categoria);
        NumContratoImobiliario = numContratoImobiliario;
        this.valorFinanciamentoImobiliario = valorFinanciamentoImobiliario;
    }

    public int getNumContratoImobiliario() {
        return NumContratoImobiliario;
    }

    public void setNumContratoImobiliario(int numContratoImobiliario) {
        NumContratoImobiliario = numContratoImobiliario;
    }

    public double getValorFinanciamentoImobiliario() {
        return valorFinanciamentoImobiliario;
    }

    public void setValorFinanciamentoImobiliario(double valorFinanciamentoImobiliario) {
        this.valorFinanciamentoImobiliario = valorFinanciamentoImobiliario;
    }

    @Override
    public String toString() {
        return "FinanciamentoImobiliario [Categoria=" + Categoria + ", NumContratoImobiliario=" + NumContratoImobiliario
                + ", valorFinanciamentoImobiliario=" + valorFinanciamentoImobiliario + "]";
    }
}