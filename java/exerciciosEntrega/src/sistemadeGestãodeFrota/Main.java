package sistemadeGestãodeFrota;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<NaveEspacial> frota = new ArrayList<>();

        NaveCargueiro cargueiro = new NaveCargueiro("Cargueiro-Alpha", 1000.0, 50.0, 500.0);
        cargueiro.setPesoCargaAtual(200.0);
        
        NaveCombate combate = new NaveCombate("Fênix-Guerra", 500.0, 150.0, 10);
        combate.setEscudoAtivado(true);
        
        NaveExploracao exploracao = new NaveExploracao("Horizon-Explorer", 800.0, 100.0, true);

        frota.add(cargueiro);
        frota.add(combate);
        frota.add(exploracao);

        System.out.println("--- Teste de Validação de Combustível ---");
        try {
            cargueiro.setCombustivelAtual(2000.0); // Deve lançar exceção[cite: 1]
        } catch (CombustivelInvalidoException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        System.out.println("\n--- Iniciando Missões de Frota ---");
        for (NaveEspacial nave : frota) {
            try {
                System.out.println("Nave: " + nave.getClass().getSimpleName() + " | ID: " + nave.getIdentificador());
                nave.viajar(1000.0); 

            } catch (Exception e) {
                System.out.println("Erro na viagem: " + e.getMessage());
            }
            System.out.println("---------------------------------");
        }
    }
}
