package apresentacao;

import dados.Pessoa;
import negocio.Sistema;

import java.util.Scanner;

public class Principal {
    private static Sistema sys = new Sistema();
    private static Scanner s = new Scanner(System.in);

    private static Pessoa novaPessoa(){
        Pessoa pessoa = new Pessoa();

        s.nextLine();

        System.out.println("Digite o nome:");
        pessoa.setNome(s.nextLine());
        System.out.println("Digite a idade:");
        pessoa.setIdade(Integer.parseInt(s.nextLine()));
        System.out.println("Digite a altura:");
        pessoa.setAltura(Float.parseFloat(s.nextLine()));
        System.out.println("Digite a massa:");
        pessoa.setMassa(Float.parseFloat(s.nextLine()));

        return pessoa;
    }

    private static void mostrarPessoas(){
        for (int i = 0; i < sys.getLista().size(); i++) {
            System.out.println("Pessoa " + i);
            System.out.println(sys.getLista().get(i));
            System.out.println();
        }
    }

    private static Pessoa escolherPessoa(){
        mostrarPessoas();

        System.out.println("Escolha uma pessoa:");
        int escolha = s.nextInt();

        if (escolha < sys.getLista().size()){
            return sys.getLista().get(escolha);
        } else {
            return null;
        }
    }

    public static void mostraMenu(){
        System.out.println("""
                Escolha uma opção:
                0 - Sair
                1 - Cadastrar Pessoa
                2 - Remover Pessoa
                3 - Mostrar Pessoas""");
    }

    public static void menu(){
        int op = -1;

        while (op != 0){
            mostraMenu();
            op = s.nextInt();

            switch (op){
                default -> System.out.println("Opção inválida");
                case 0 -> System.out.println("Adeus");
                case 1 -> sys.adicionarPessoa(novaPessoa());
                case 2 -> sys.removerPessoa(escolherPessoa());
                case 3 -> mostrarPessoas();
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }


}
