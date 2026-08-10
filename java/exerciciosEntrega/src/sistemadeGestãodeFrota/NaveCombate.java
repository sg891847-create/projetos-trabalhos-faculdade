package sistemadeGestãodeFrota;

public class NaveCombate extends NaveEspacial {
    private int numeroArmas;
    private boolean escudoAtivado;

    public NaveCombate(String id, double max, double vel, int numArmas) {
        super(id, max, vel);
        this.numeroArmas = numArmas;
    }

    public void setEscudoAtivado(boolean escudoAtivado) { this.escudoAtivado = escudoAtivado; }

    @Override
    public double calcularConsumo(double distancia) {
        double consumoBase = distancia * 0.8;
        if (escudoAtivado) {
            return consumoBase * 1.15;
        }
        return consumoBase;
    }
}
