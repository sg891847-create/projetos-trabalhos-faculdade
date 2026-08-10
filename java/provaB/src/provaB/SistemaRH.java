package provaB;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaRH {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Profissional> profissionais =
                new ArrayList<>();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n MENU ");
            System.out.println("1 - Cadastrar Atleta");
            System.out.println("2 - Cadastrar Comissão Técnica");
            System.out.println("3 - Registrar Desempenho");
            System.out.println("4 - Mostrar Folha de Pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {

                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {

                    case 1:

                        try {

                            System.out.print("Nome: ");
                            String nome = sc.nextLine();

                            System.out.print("ID: ");
                            int id = sc.nextInt();

                            System.out.print("Salário: ");
                            double salario = sc.nextDouble();

                            profissionais.add(
                                    new Atleta(nome, id, salario));

                            System.out.println(
                                    "Atleta cadastrado!");

                        } catch (InputMismatchException e) {

                            System.out.println(
                                    "Entrada inválida!");

                            sc.nextLine();

                        } catch (OrcamentoException e) {

                            System.out.println(
                                    e.getMessage());
                        }

                        break;

                    case 2:

                        try {

                            System.out.print("Nome: ");
                            String nome = sc.nextLine();

                            System.out.print("ID: ");
                            int id = sc.nextInt();

                            System.out.print("Salário: ");
                            double salario = sc.nextDouble();

                            profissionais.add(
                                    new ComissaoTecnica(
                                            nome,
                                            id,
                                            salario));

                            System.out.println(
                                    "Membro cadastrado!");

                        } catch (InputMismatchException e) {

                            System.out.println(
                                    "Entrada inválida!");

                            sc.nextLine();

                        } catch (OrcamentoException e) {

                            System.out.println(
                                    e.getMessage());
                        }

                        break;

                    case 3:

                        try {

                            System.out.print(
                                    "Digite o ID: ");

                            int idBusca = sc.nextInt();

                            Profissional encontrado = null;

                            for (Profissional p :
                                    profissionais) {

                                if (p.getId() == idBusca) {
                                    encontrado = p;
                                    break;
                                }
                            }

                            if (encontrado == null) {

                                System.out.println(
                                        "Profissional não encontrado!");

                            } else {

                                System.out.print(
                                        "Digite desempenho: ");

                                int valor = sc.nextInt();

                                encontrado
                                        .registrarDesempenho(valor);

                                System.out.println(
                                        "Desempenho registrado!");
                            }

                        } catch (InputMismatchException e) {

                            System.out.println(
                                    "Valor inválido!");

                            sc.nextLine();
                        }

                        break;

                    case 4:

                        double total = 0;

                        System.out.println(
                                "\n===== FOLHA =====");

                        for (Profissional p :
                                profissionais) {

                            System.out.println(p);

                            total += p.calcularPagamento();
                        }

                        System.out.println(
                                "\nCusto Total do Clube: R$ "
                                        + total);

                        break;

                    case 0:

                        System.out.println("Encerrando...");
                        break;

                    default:

                        System.out.println(
                                "Opção inválida!");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Digite apenas números!");

                sc.nextLine();
            }
        }

        sc.close();
    }
}