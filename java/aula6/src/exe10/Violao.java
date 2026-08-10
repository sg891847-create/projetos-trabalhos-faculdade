package exe10;

class Violao extends Instrumento {
 @Override
 public void tocar() {
     System.out.println("Violão: Tocando acordes com as cordas (Dó - Ré - Mi).");
 }
}

class Piano extends Instrumento {
 @Override
 public void tocar() {
     System.out.println("Piano: Pressionando as teclas e percutindo as cordas.");
 }
}