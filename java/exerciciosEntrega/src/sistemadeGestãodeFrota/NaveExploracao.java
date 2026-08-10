package sistemadeGestãodeFrota;

public class NaveExploracao extends NaveEspacial {
    private boolean possuiSensoresAvancados;

    public NaveExploracao(String id, double max, double vel, boolean possuiSensores) {
        super(id, max, vel);
        this.possuiSensoresAvancados = possuiSensores;
    }

    @Override
    public double calcularConsumo(double distancia) {
        double consumoBase = distancia * 0.3;
        if (possuiSensoresAvancados) {
            return consumoBase + 50.0;
        }
        return consumoBase;
    }
}