package sistemadeGestaoFabrica;

public class InjetoraPlastico extends MaquinaIndustrial {
    private double kgMateriaPrima;

    public InjetoraPlastico(String numeroSerie) { super(numeroSerie); }

    public void abastecerPlastico(double kg) {
        if (kg > 0) this.kgMateriaPrima += kg;
    }

    @Override
    public void produzirLote(int quantidade) throws Exception {
        if (!isLigada()) throw new MaquinaDesligadaException("Injetora desligada!");
        double necessidade = quantidade * 0.2; 
        if (kgMateriaPrima < necessidade) throw new FaltaMateriaPrimaException("Plástico insuficiente!");

        kgMateriaPrima -= necessidade;
        registrarProducao(quantidade, quantidade * 0.5);
        System.out.println("Injetora " + getNumeroSerie() + " produziu " + quantidade + " peças.");
    }
}