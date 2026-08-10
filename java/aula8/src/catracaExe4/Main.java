package catracaExe4;


public class Main {
    public static void main(String[] args) {
        Catraca catracaOficial = new Catraca();

        System.out.println("  TESTES DE ACESSO  \n");

        // é para ta tudo errado
        executarTeste(catracaOficial, 15, false, "Arquibancada", TipoIngresso.INTEIRA, false, false);

        // menor setor Social
        executarTeste(catracaOficial, 10, true, "Social", TipoIngresso.INTEIRA, false, true);

        // teoricamente não é pra funcionar
        executarTeste(catracaOficial, 30, true, "Arquibancada", TipoIngresso.MEIA, false, true);

        // teoricamente é pra tar certo
        executarTeste(catracaOficial, 22, false, "Arquibancada", TipoIngresso.CORTESIA, false, true);
    }

    private static void executarTeste(Catraca catraca, int idade, boolean socio, String setor, 
                                     TipoIngresso tipo, boolean carteira, boolean acompanhado) {
        try {
            catraca.validarIngresso(idade, socio, setor, tipo, carteira, acompanhado);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}