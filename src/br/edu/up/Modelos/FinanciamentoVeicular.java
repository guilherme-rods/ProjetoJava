package br.edu.up.Modelos;

public class FinanciamentoVeicular extends Financiamento{

    private String tipoVeiculo;
    private int anoFabricacao;
    private double taxaJurosMensal;

    public FinanciamentoVeicular(int id, double valor, int prazo, String tipoVeiculo, int anoFabricacao,
            double taxaJurosMensal,int idCliente) {
        super(id, valor, prazo,idCliente);
        this.tipoVeiculo = tipoVeiculo;
        this.anoFabricacao = anoFabricacao;
        this.taxaJurosMensal = taxaJurosMensal;
        this.tipoFinanciamento = 2;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getTaxaJurosMensal() {
        return taxaJurosMensal;
    }

    public void setTaxaJurosMensal(double taxaJurosMensal) {
        this.taxaJurosMensal = taxaJurosMensal;
    }

    @Override
    public String toString() {
        return "FinanciamentoVeicular [id=" + id + ", tipoVeiculo=" + tipoVeiculo + ", valor=" + valor
                + ", anoFabricacao=" + anoFabricacao + ", prazo=" + prazo + ", taxaJurosMensal=" + taxaJurosMensal
                + "]";
    }

    public String ToStringCSV() {
        return id + ";" + tipoFinanciamento + ";" + valor + ";" + prazo + ";;;" + tipoVeiculo + ";" + anoFabricacao + ";" + taxaJurosMensal;
    }

}