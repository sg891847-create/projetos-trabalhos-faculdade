package sistemadeGestaoFabrica;

public class BracoRoboticoMontagem extends MaquinaIndustrial {
    private double percentualCalibracao = 100.0;

    public BracoRoboticoMontagem(String numeroSerie) { super(numeroSerie); }

    public void recalibrar() { this.percentualCalibracao = 100.0; }

    @Override
    public void produzirLote(int quantidade) throws Exception {
        if (!isLigada()) throw new MaquinaDesligadaException("Robô desligado!");
        if (percentualCalibracao < 20.0) throw new EquipamentoDescalibradoException("Robô descalibrado!");

        registrarProducao(quantidade, 15.0); 
        percentualCalibracao -= (quantidade * 0.5);
        if (percentualCalibracao < 0) percentualCalibracao = 0;
        System.out.println("Robô " + getNumeroSerie() + " montou o lote.");
    }
}