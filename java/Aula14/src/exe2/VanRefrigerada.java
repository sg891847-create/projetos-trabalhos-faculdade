package exe2;

public class VanRefrigerada extends Veiculo implements Rastreador, Refrigerado {
    private double temperaturaAtual;

    public VanRefrigerada(String placa, double capacidadeCarga) {
        super(placa, capacidadeCarga);
        this.temperaturaAtual = 0.0; 
    }

    @Override
    public void iniciarViagem() {
        System.out.println("Van Refrigerada (" + getPlaca() + ") iniciou a viagem com carga perecível.");
    }

    @Override
    public String obterLocalizacao() {
        return "Coordenadas da Van Refrigerada: -29.691, -53.812";
    }

    @Override
    public void ajustarTemperatura(double graus) throws TemperaturaCriticaException {
        if (graus > 10.0 || graus < -20.0) {
            throw new TemperaturaCriticaException(
                "ALERTA CRÍTICO: A temperatura de " + graus + "°C está fora dos limites de segurança (-20°C a 10°C). A carga pode ser comprometida!"
            );
        }
        this.temperaturaAtual = graus;
        System.out.println("Temperatura da Van (" + getPlaca() + ") ajustada com sucesso para: " + temperaturaAtual + "°C");
    }
}
