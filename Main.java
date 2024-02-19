import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventManager manager = new EventManager();
        manager.carregarEventos();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de eventos!");

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar evento");
            System.out.println("2 - Listar eventos");
            System.out.println("3 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do evento:");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    String nome = scanner.nextLine();
                    System.out.println("Digite o endereço:");
                    String endereco = scanner.nextLine();
                    System.out.println("Digite a categoria:");
                    String categoria = scanner.nextLine();
                    System.out.println("Digite a descrição:");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite o ano do evento:");
                    int ano = scanner.nextInt();
                    System.out.println("Digite o mês do evento:");
                    int mes = scanner.nextInt();
                    System.out.println("Digite o dia do evento:");
                    int dia = scanner.nextInt();
                    System.out.println("Digite a hora do evento:");
                    int hora = scanner.nextInt();
                    System.out.println("Digite os minutos do evento:");
                    int minutos = scanner.nextInt();
                    LocalDateTime horario = LocalDateTime.of(ano, mes, dia, hora, minutos);
                    manager.cadastrarEvento(new Evento(nome, endereco, categoria, horario, descricao));
                    manager.salvarEventos();
                    break;
                case 2:
                    manager.listarEventos();
                    break;
                case 3:
                    manager.salvarEventos();
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
