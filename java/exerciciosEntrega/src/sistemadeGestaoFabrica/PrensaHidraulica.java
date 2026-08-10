package sistemadeGestaoFabrica;

public class PrensaHidraulica extends MaquinaIndustrial {
    private double temperaturaAtual = 25.0;

    public PrensaHidraulica(String numeroSerie) { super(numeroSerie); }

    public void acionarRefrigeracao() { this.temperaturaAtual = 25.0; }

    @Override
    public void produzirLote(int quantidade) throws Exception {
        if (!isLigada()) throw new MaquinaDesligadaException("Prensa desligada!");
        if (temperaturaAtual >= 90.0) throw new SuperaquecimentoException("Prensa superaquecida!");

        registrarProducao(quantidade, quantidade * 2.0); 
        temperaturaAtual += (quantidade * 1.5);
        System.out.println("Prensa " + getNumeroSerie() + " concluiu o trabalho.");
    }
}
