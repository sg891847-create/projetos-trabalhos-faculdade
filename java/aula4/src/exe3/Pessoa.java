package exe3;

public class Pessoa {
    public String nome;
    public int idade;
    public String genero;

    public void exibirDados() {
        System.out.println("\n--- Dados da Pessoa ---");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Gênero: " + genero);
    }
}