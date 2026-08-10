package exercicios1905;


public class Smartwatch extends Dispositivo implements Conectividade, Monitoramento {

 public Smartwatch(String marca) {
     super(marca);
 }

 @Override
 public void ligar() {
     System.out.println("Smartwatch ligando.....Inicializando sistema.");
 }

 @Override
 public void conectarBluetooth() {
     System.out.println("Conectando ao Bluetooth......Dispositivo emparelhado com sucesso!");
 }

 @Override
 public void medirBatimentos() {
     System.out.println("Medindo batimentos cardíacos no pulso.........");
 }
}