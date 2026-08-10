package exe4;

//MainEx4.java
public class Main {
 public static void main(String[] args) {
     Guerreiro guerreiro = new Guerreiro("Aragorn", 50);
     Mago mago = new Mago("Gandalf", 40);

     System.out.println("--- Início do Combate RPG ---");

     while (mago.getPontosVida() > 0) {
         try {
             System.out.println("Vida atual de " + mago.getNome() + ": " + mago.getPontosVida());
             guerreiro.atacar(mago);
         } catch (AlvoInvalidoException e) {
             System.out.println("Erro inesperado no loop: " + e.getMessage());
         }
     }

     System.out.println("Vida final de " + mago.getNome() + ": " + mago.getPontosVida());
     System.out.println("\n--- Forçando o disparo da Exceção ---");

     try {
         guerreiro.atacar(mago);
     } catch (AlvoInvalidoException e) {
         System.out.println("Exceção capturada com sucesso: " + e.getMessage());
     }
 }
}

