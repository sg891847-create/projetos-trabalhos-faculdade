package sistemadeGestãodeFrota;

public class NaveCargueiro extends NaveEspacial {
    private double pesoCargaAtual;
    private double capacidadeMaximaCarga;

    public NaveCargueiro(String id, double max, double vel, double capMaxCarga) {
        super(id, max, vel);
        this.capacidadeMaximaCarga = capMaxCarga;
    }

    public void setPesoCargaAtual(double pesoCargaAtual) {
        if (pesoCargaAtual > capacidadeMaximaCarga) {
            System.out.println("Erro: Carga excede a capacidade!");
            return;
        }
        this.pesoCargaAtual = pesoCargaAtual;
    }

    @Override
    public double calcularConsumo(double distancia) {
        return (distancia * 0.5) + (this.pesoCargaAtual * 0.2);
    }
}