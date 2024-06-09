package br.edu.up.Controller;

import br.edu.up.Modelos.Financiamento;
import br.edu.up.Modelos.FinanciamentoImobiliario;
import br.edu.up.Modelos.FinanciamentoVeicular;

import java.util.ArrayList;
import java.util.List;

public class FinanciamentoController {

    private List<Financiamento> financiamentos;

    public FinanciamentoController() {
        this.financiamentos = new ArrayList<>();
    }

    public void adicionarFinanciamento(Financiamento financiamento) {
        this.financiamentos.add(financiamento);
    }

    public String visualizarPrazoTotal() {
        StringBuilder resultado = new StringBuilder();
        for (Financiamento financiamento : financiamentos) {
            resultado.append("ID: ").append(financiamento.getId()).append(", Prazo: ").append(financiamento.getPrazo()).append(" meses\n");
        }
        return resultado.toString();
    }

    public String visualizarParcelasPagas(int id, int parcelasPagas) {
        StringBuilder resultado = new StringBuilder();
        for (Financiamento financiamento : financiamentos) {
            if (financiamento.getId() == id) {
                resultado.append("ID: ").append(financiamento.getId())
                        .append(", Parcelas Pagas: ").append(parcelasPagas)
                        .append(" de ").append(financiamento.getPrazo()).append("\n");
                break;
            }
        }
        return resultado.toString();
    }

    public String visualizarSaldoAPagar(int id, int parcelasPagas) {
        StringBuilder resultado = new StringBuilder();
        for (Financiamento financiamento : financiamentos) {
            if (financiamento.getId() == id) {
                double valorParcela = financiamento.getValor() / financiamento.getPrazo();
                double saldoAPagar = (financiamento.getPrazo() - parcelasPagas) * valorParcela;
                resultado.append("ID: ").append(financiamento.getId())
                        .append(", Saldo a Pagar: ").append(saldoAPagar).append("\n");
                break;
            }
        }
        return resultado.toString();
    }
}