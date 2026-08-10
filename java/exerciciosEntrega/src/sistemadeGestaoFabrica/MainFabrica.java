package sistemadeGestaoFabrica;

import java.util.ArrayList;
import java.util.List;

public class MainFabrica {
    public static void main(String[] args) {
        List<MaquinaIndustrial> fabrica = new ArrayList<>();
        
        InjetoraPlastico inj = new InjetoraPlastico("INJ-01");
        BracoRoboticoMontagem rob = new BracoRoboticoMontagem("ROB-02");
        PrensaHidraulica pre = new PrensaHidraulica("PRE-03");

        fabrica.add(inj);
        fabrica.add(rob);
        fabrica.add(pre);

        inj.abastecerPlastico(10.0); 

        for (MaquinaIndustrial m : fabrica) m.ligar();

        for (int i = 1; i <= 3; i++) {
            System.out.println("\n--- Turno " + i + " ---");
            for (MaquinaIndustrial m : fabrica) {
                try {
                    m.produzirLote(40);
                } catch (Exception e) {
                    System.err.println("ALERTA na " + m.getClass().getSimpleName() + ": " + e.getMessage());
                }
            }
        }

        System.out.println("\n--- Relatório Final ---");
        for (MaquinaIndustrial m : fabrica) {
            System.out.println("Máquina " + m.getNumeroSerie() + " | Peças: " + m.getPecasProduzidasTotais() + " | Energia: " + m.getEnergiaConsumidaKWh() + " kWh");
        }
    }
}