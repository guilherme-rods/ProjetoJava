package br.edu.up;

import br.edu.up.DAO.AlunoDao;
import br.edu.up.Modelos.Aluno;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlunoDao alunoDao = new AlunoDao("alunos.csv");

        try {
            List<Aluno> alunos = alunoDao.lerAlunos();
            processarDados(alunos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processarDados(List<Aluno> alunos) {
        int totalAlunos = alunos.size();
        int aprovados = 0;
        int reprovados = 0;
        double menorNota = Double.MAX_VALUE;
        double maiorNota = Double.MIN_VALUE;
        double somaNotas = 0.0;

        for (Aluno aluno : alunos) {
            double nota = aluno.getNota();
            somaNotas += nota;

            if (nota >= 6.0) {
                aprovados++;
            } else {
                reprovados++;
            }

            if (nota < menorNota) {
                menorNota = nota;
            }

            if (nota > maiorNota) {
                maiorNota = nota;
            }
        }

        double media = somaNotas / totalAlunos;

        String resumo = "Total de Alunos: " + totalAlunos + "\n"
                + "Aprovados: " + aprovados + "\n"
                + "Reprovados: " + reprovados + "\n"
                + "Menor Nota: " + menorNota + "\n"
                + "Maior Nota: " + maiorNota + "\n"
                + "Média: " + media;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./dbbanco/resumo.csv"))) {
            bw.write(resumo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
