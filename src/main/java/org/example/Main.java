package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Visualizar Tarefas");
            System.out.println("3. Remover Tarefa");
            System.out.println("4. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da tarefa: ");
                    String nomeTarefa = scanner.nextLine();
                    boolean encontrada = false;
                    for (Tarefa tarefa : tarefas) {
                        if (tarefa.getNome().equalsIgnoreCase(nomeTarefa)) {
                            encontrada = true;
                            break;
                        }
                    }
                    if (encontrada) {
                        System.out.println("Tarefa já existe.");
                    } else {
                        tarefas.add(new Tarefa(nomeTarefa));
                        System.out.println("Tarefa adicionada com sucesso.");
                    }
                    break;
                case 2:
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas cadastradas.");
                    } else {
                        for (Tarefa tarefa : tarefas) {
                            System.out.println(tarefa);
                        }
                    }
                    break;
                case 3:
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas cadastradas para remover.");
                    } else {
                        System.out.print("Digite o nome da tarefa a ser removida: ");
                        String nomeTarefaRemover = scanner.nextLine();
                        boolean removida = false;
                        for (Tarefa tarefa : tarefas) {
                            if (tarefa.getNome().equalsIgnoreCase(nomeTarefaRemover)) {
                                tarefas.remove(tarefa);
                                removida = true;
                                break;
                            }
                        }
                        if (removida) {
                            System.out.println("Tarefa removida com sucesso.");
                        } else {
                            System.out.println("Tarefa não encontrada.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                default:
                    System.out.println("Valor inválido, por favor digite uma opção válida.");
            }
        }
    }
}
