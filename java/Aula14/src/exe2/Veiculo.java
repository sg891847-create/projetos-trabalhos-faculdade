package exe2;

public abstract class Veiculo {
    private String placa;
    private double capacidadeCarga;

    public Veiculo(String placa, double capacidadeCarga) {
        this.placa = placa;
        this.capacidadeCarga = capacidadeCarga;
    }

    public String getPlaca() {
        return placa;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    protected void registrarManutencao() {
        System.out.println("Manutenção registrada para o veículo de placa: " + placa);
    }

    public abstract void iniciarViagem();
}