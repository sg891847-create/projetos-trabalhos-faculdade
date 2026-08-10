package sistemadeFolhadePagamentoHospitalar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FuncionarioHospital> folhaPagamento = new ArrayList<>();

        Medico m = new Medico("Dr. Silva", "M123", 5000.0, "Cirurgião", 800.0, 5);
        
        Enfermeiro e = new Enfermeiro("Ana", "E456", 2500.0, "UTI");
        e.setPercentualInsalubridade(0.40);
        e.setHorasTrabalhadasMensais(180);

        Administrativo a = new Administrativo("Carlos", "A789", 3000.0, "RH", true);

        folhaPagamento.add(m);
        folhaPagamento.add(e);
        folhaPagamento.add(a);

        System.out.println("--- Iniciando Testes de Validação ---");
        
        try { a.setSalarioBase(900.0); } 
        catch (ValorInvalidoException ex) { System.err.println("Erro RH: " + ex.getMessage()); }

        try { e.setPercentualInsalubridade(0.99); } 
        catch (ValorInvalidoException ex) { System.err.println("Erro UTI: " + ex.getMessage()); }

        try { m.setHorasTrabalhadasMensais(400); } 
        catch (ValorInvalidoException ex) { System.err.println("Erro Médico: " + ex.getMessage()); }

        System.out.println("\n--- Folha de Pagamento Mensal ---");
        for (FuncionarioHospital f : folhaPagamento) {
            f.exibirResumoMensal();
        }
    }
}
