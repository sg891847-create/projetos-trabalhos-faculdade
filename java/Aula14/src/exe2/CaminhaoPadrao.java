package exe2;

public class CaminhaoPadrao extends Veiculo implements Rastreador {

    public CaminhaoPadrao(String placa, double capacidadeCarga) {
        super(placa, capacidadeCarga);
    }

    @Override
    public void iniciarViagem() {
        System.out.println("Caminhão Padrão (" + getPlaca() + ") iniciou a viagem de entrega.");
    }

    @Override
    public String obterLocalizacao() {
        return "Coordenadas do Caminhão Padrão: -29.684, -53.806";
    }
}
