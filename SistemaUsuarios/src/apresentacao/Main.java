package apresentacao;

import controladora.ControladorUsuario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControladorUsuario controlador = new ControladorUsuario();
        int opcao = 0;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Logar");
            System.out.println("3 - Alterar dados (logado)");
            System.out.println("4 - Excluir conta (logado)");
            System.out.println("5 - Listar todos os usuários (logado)");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("E-mail: ");
                        String email = sc.nextLine();
                        System.out.print("Senha: ");
                        String senha = sc.nextLine();
                        controlador.criarConta(nome, email, senha);
                        System.out.println("Conta criada com sucesso!");
                        break;

                    case 2:
                        System.out.print("E-mail: ");
                        email = sc.nextLine();
                        System.out.print("Senha: ");
                        senha = sc.nextLine();
                        if (controlador.logar(email, senha)) {
                            System.out.println("Login realizado!");
                        } else {
                            System.out.println("E-mail ou senha inválidos.");
                        }
                        break;

                    case 3:
                        if (controlador.isLogado()) {
                            System.out.print("Novo nome: ");
                            String novoNome = sc.nextLine();
                            System.out.print("Novo e-mail: ");
                            String novoEmail = sc.nextLine();
                            System.out.print("Nova senha: ");
                            String novaSenha = sc.nextLine();
                            controlador.alterarDados(novoNome, novoEmail, novaSenha);
                            System.out.println("Dados alterados com sucesso!");
                        } else {
                            System.out.println("Você não está logado!");
                        }
                        break;

                    case 4:
                        if (controlador.isLogado()) {
                            controlador.excluirConta();
                            System.out.println("Conta excluída!");
                        } else {
                            System.out.println("Você não está logado!");
                        }
                        break;

                    case 5:
                        if (controlador.isLogado()) {
                            controlador.listarUsuarios();
                        } else {
                            System.out.println("Você não está logado!");
                        }
                        break;

                    case 6:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 6);

        sc.close();
    }
}