package exe3;

import java.util.ArrayList;
import java.util.List;

public class Main {
 public static void main(String[] args) {
     List<MembroAcademico> membros = new ArrayList<>();
     membros.add(new Professor("Rafael Bisogno", "PRF123"));
     membros.add(new AlunoPosGraduacao("Carlos Silva", "POS456"));

     System.out.println("--- Testando Sistema Acadêmico ---");

     for (MembroAcademico membro : membros) {
         membro.mostrarFuncao();

         if (membro instanceof Pesquisador) {
             try {
                 Pesquisador pesquisador = (Pesquisador) membro;
                 pesquisador.publicarArtigo(""); 
             } catch (DadosAcademicosInvalidosException e) {
                 System.out.println("Exceção capturada: " + e.getMessage());
             }
         }

         if (membro instanceof Avaliador) {
             try {
                 Avaliador avaliador = (Avaliador) membro;
                 avaliador.lancarNotas(11.0); 
             } catch (DadosAcademicosInvalidosException e) {
                 System.out.println("Exceção capturada: " + e.getMessage());
             }
         }
         System.out.println();
     }
 }
}