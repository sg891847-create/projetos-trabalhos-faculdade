package exe7;

public class Termometro {
    private double celsius;

    public Termometro(double temperaturaInicialCelsius) {
        this.celsius = temperaturaInicialCelsius;
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }

    public void setFahrenheit(double fahrenheit) {
        this.celsius = (fahrenheit - 32) * 5 / 9;
    }
}