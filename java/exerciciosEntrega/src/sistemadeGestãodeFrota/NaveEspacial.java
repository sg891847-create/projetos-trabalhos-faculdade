package sistemadeGestãodeFrota;

public abstract class NaveEspacial {
    private String identificador;
    private double combustivelMaximo;
    private double combustivelAtual;
    private double velocidadeBase;

    public NaveEspacial(String identificador, double combustivelMaximo, double velocidadeBase) {
        this.identificador = identificador;
        this.combustivelMaximo = combustivelMaximo;
        this.combustivelAtual = combustivelMaximo; 
        this.velocidadeBase = velocidadeBase;
    }

    // Getters e Setters
    public String getIdentificador() { return identificador; }
    public void setIdentificador(String identificador) { this.identificador = identificador; }

    public double getCombustivelMaximo() { return combustivelMaximo; }
    public void setCombustivelMaximo(double combustivelMaximo) { this.combustivelMaximo = combustivelMaximo; }

    public double getCombustivelAtual() { return combustivelAtual; }

    public void setCombustivelAtual(double valor) {
        
    	if (valor < 0 || valor > this.combustivelMaximo) {
            throw new CombustivelInvalidoException("Valor de combustível inválido!");
        }
        this.combustivelAtual = valor;
    }

    public double getVelocidadeBase() { return velocidadeBase; }
    public void setVelocidadeBase(double velocidadeBase) { this.velocidadeBase = velocidadeBase; }

    public abstract double calcularConsumo(double distanciaEmAnosLuz);

    public void viajar(double distancia) throws CombustivelInsuficienteException {
        double consumoNecessario = calcularConsumo(distancia);
        
        if (this.combustivelAtual >= consumoNecessario) {
            this.combustivelAtual -= consumoNecessario;
            System.out.println("A nave [" + identificador + "] viajou " + distancia + 
                               " anos-luz. Combustível restante: " + combustivelAtual);
        } else {
            throw new CombustivelInsuficienteException("Combustível insuficiente para a distância de " + distancia);
        }
    }
}