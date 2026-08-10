package trabalhoFinalPOO;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fossil> acervoMuseu = new ArrayList<>();

        System.out.println(" CADASTRANDO NOVO FÓSSIL \n");
        try {
            Subfossil dodo = new Subfossil(
                "Pássaro Dodô", "Raphus cucullatus", "Espécime Oxford-201", 
                "Quaternário", 400, "Ossos originais com vestígios de queratina", true
            );

            acervoMuseu.add(dodo);
            System.out.println("Subfóssil cadastrado com sucesso!");

        } catch (IdadeInvalidaException | PeriodoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Macrofossil Yutyrannus = new Macrofossil(
                "Yutyrannus", "Yutyrannus huali", "ZCDM V5000", 
                "Cretáceo", 125000000, "Incompleto"
            );

            acervoMuseu.add(Yutyrannus);
            System.out.println("Fóssil cadastrado com sucesso!");

        } catch (IdadeInvalidaException | PeriodoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n TESTANDO VALIDAÇÃO DO FÓSSIL \n");
        try {
            //falha pois ultrapassa o limite de 11.000 anos da regra do Subfóssil
            Subfossil erroSubfossil = new Subfossil(
                "Tricerátops", "Triceratops horridus", "TRI-02", 
                "Cretáceo", 65000000, "Incompleto", false
            );
            acervoMuseu.add(erroSubfossil);
        } catch (IdadeInvalidaException | PeriodoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n LISTAGEM DO ACERVO ATUALIZADO \n");
        for (Fossil f : acervoMuseu) {
            f.exibirDetalhes(); 
            }
    }
}