package exe2;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistema de Gestão de Frota Logística ---\n");

        CaminhaoPadrao caminhao = new CaminhaoPadrao("ABC-1234", 15000.0);
        VanRefrigerada van = new VanRefrigerada("XYZ-5678", 2500.0);

        caminhao.iniciarViagem();
        System.out.println("Localização atual: " + caminhao.obterLocalizacao());
        
        System.out.println("\n-------------------------------------------");
        
        van.iniciarViagem();
        System.out.println("Localização atual: " + van.obterLocalizacao());

        System.out.println("\n--- Teste de Ajuste de Temperatura (Cenário de Erro) ---");
        try {
            System.out.println("Tentando ajustar temperatura da Van para 15.0°C...");
            van.ajustarTemperatura(15.0);
        } catch (TemperaturaCriticaException e) {
            System.err.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        System.out.println("\n--- Teste de Ajuste de Temperatura (Cenário de Sucesso) ---");
        try {
            System.out.println("Tentando ajustar temperatura da Van para 2.0°C...");
            van.ajustarTemperatura(2.0);
        } catch (TemperaturaCriticaException e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
        
        System.out.println("\n--- Fim dos testes ---");
    }
}
