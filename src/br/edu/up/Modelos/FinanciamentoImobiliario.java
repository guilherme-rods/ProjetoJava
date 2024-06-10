package br.edu.up.Modelos;

public class FinanciamentoImobiliario extends Financiamento {

    private String tipoImovel;
    private double taxaJurosAnual;

    public FinanciamentoImobiliario(int id, double valor, int prazo, String tipoImovel, double taxaJurosAnual,int idCliente) {
        super(id, valor, prazo, idCliente);
        this.tipoImovel = tipoImovel;
        this.taxaJurosAnual = taxaJurosAnual;
        this.tipoFinanciamento = 1;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    @Override
    public String toString() {
        return "FinanciamentoImobiliario [id=" + id + ", tipoImovel=" + tipoImovel + ", valor=" + valor + ", prazo="
                + prazo + ", taxaJurosAnual=" + taxaJurosAnual + "]";
    }

    public String ToStringCSV() {
        return id + ";" + tipoFinanciamento + ";" + valor + ";" + prazo + ";" + tipoImovel + ";" + taxaJurosAnual + ";;;";
    }
}