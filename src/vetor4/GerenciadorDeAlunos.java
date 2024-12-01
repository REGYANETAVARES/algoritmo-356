package vetor4;

import java.util.Scanner;

public class GerenciadorDeAlunos {

    // Método principal da lógica
    public void executar() {
        final int TOTAL_ALUNOS = 15;
        String[] nomes = new String[TOTAL_ALUNOS];
        double[] pr1 = new double[TOTAL_ALUNOS];
        double[] pr2 = new double[TOTAL_ALUNOS];
        int[] media = new int[TOTAL_ALUNOS];
        String[] situacao = new String[TOTAL_ALUNOS];

        Scanner scanner = new Scanner(System.in);

        // Entrada de dados dos alunos
        for (int i = 0; i < TOTAL_ALUNOS; i++) {
            // Entrada do nome
            System.out.print("\nDigite o nome do aluno " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();

            // Garante que o nome tenha no máximo 30 caracteres
            while (nomes[i].length() > 30) {
                System.out.println("O nome deve ter até 30 caracteres.");
                System.out.print("\nDigite o nome do aluno " + (i + 1) + " novamente: ");
                nomes[i] = scanner.nextLine();
            }

            // Completa o nome com espaços até ter 30 caracteres
            while (nomes[i].length() < 30) {
                nomes[i] += " ";
            }

            // Entrada das notas, com verificação para garantir que são números válidos
            pr1[i] = lerNota(scanner, "Digite a nota da PR1: ");
            pr2[i] = lerNota(scanner, "Digite a nota da PR2: ");

            // Calcula a média arredondada
            media[i] = (int) Math.round((pr1[i] + pr2[i]) / 2);

            // Determina a situação do aluno (AP ou RP)
            if (media[i] >= 5) {
                situacao[i] = "AP";
            } else {
                situacao[i] = "RP";
            }
        }

        // Saída de dados
        System.out.println("\n\n\t\t\t\tRELACAO FINAL");
        System.out.printf("%-4s%-30s%-8s%-8s%-8s%-8s\n", "Nº", "Nome", "PR1", "PR2", "Média", "Situação");
        for (int i = 0; i < TOTAL_ALUNOS; i++) {
            System.out.printf("%-4d%-30s%-8.2f%-8.2f%-8d%-8s\n",
                (i + 1), nomes[i], pr1[i], pr2[i], media[i], situacao[i]);
        }
    }

    // Função para ler uma nota, tratando entradas inválidas
    private double lerNota(Scanner scanner, String mensagem) {
        double nota = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensagem);
                nota = scanner.nextDouble();
                scanner.nextLine(); // Consumir a quebra de linha
                entradaValida = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.nextLine(); // Limpar o buffer de entrada
            }
        }

        return nota;
    }
}
