package br.edu.up.Modelos;

public class FinanciamentoVeicular extends Financiamento{

    private int NumContratoVeicular;
    private double valorFinanciamentoVeicular;

    public FinanciamentoVeicular(int categoria, int numContratoVeicular, double valorFinanciamentoVeicular) {
        super(categoria);
        NumContratoVeicular = numContratoVeicular;
        this.valorFinanciamentoVeicular = valorFinanciamentoVeicular;
    }

    public int getNumContrato() {
        return NumContratoVeicular;
    }

    public void setNumContratoVeicular(int numContratoVeicular) {
        NumContratoVeicular = numContratoVeicular;
    }

    public double getValorFinanciamentoVeicular() {
        return valorFinanciamentoVeicular;
    }

    public void setValorFinanciamentoVeicular(double valorFinanciamentoVeicular) {
        this.valorFinanciamentoVeicular = valorFinanciamentoVeicular;
    }

    @Override
    public String toString() {
        return "FinanciamentoVeicular [Categoria=" + Categoria + ", NumContratoVeicular=" + NumContratoVeicular
                + ", valorFinanciamentoVeicular=" + valorFinanciamentoVeicular + "]";
    } 
}