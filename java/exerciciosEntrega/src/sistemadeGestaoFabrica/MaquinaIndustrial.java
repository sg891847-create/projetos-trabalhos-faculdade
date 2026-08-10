package sistemadeGestaoFabrica;

public abstract class MaquinaIndustrial {
    private final String numeroSerie;
    private boolean ligada;
    private int pecasProduzidasTotais;
    private double energiaConsumidaKWh;

    public MaquinaIndustrial(String numeroSerie) {
        this.numeroSerie = numeroSerie;
        this.ligada = false;
        this.pecasProduzidasTotais = 0;
        this.energiaConsumidaKWh = 0;
    }

    public String getNumeroSerie() { return numeroSerie; }
    public boolean isLigada() { return ligada; }
    public int getPecasProduzidasTotais() { return pecasProduzidasTotais; }
    public double getEnergiaConsumidaKWh() { return energiaConsumidaKWh; }

    public void ligar() {
        if (ligada) throw new IllegalStateException("Máquina já está ligada!");
        this.ligada = true;
    }

    public void desligar() {
        if (!ligada) throw new IllegalStateException("Máquina já está desligada!");
        this.ligada = false;
    }

    protected void registrarProducao(int pecas, double energia) {
        this.pecasProduzidasTotais += pecas;
        this.energiaConsumidaKWh += energia;
    }

    public abstract void produzirLote(int quantidade) throws Exception;
}