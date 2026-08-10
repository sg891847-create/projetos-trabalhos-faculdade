package exe2;

class PratoPrincipal extends ItemCardapio {
 private int tempoPreparo;

 public PratoPrincipal(String nome, double precoBase, int tempoPreparo) {
     super(nome, precoBase);
     this.tempoPreparo = tempoPreparo;
 }

 @Override
 public double calcularPrecoFinal() {
	return tempoPreparo;
	 
 }
}

class Bebida extends ItemCardapio {
 private boolean isAlcoolica;

 public Bebida(String nome, double precoBase, boolean isAlcoolica) {
     super(nome, precoBase);
     this.isAlcoolica = isAlcoolica;
 }

 @Override
 public double calcularPrecoFinal() {
     if (isAlcoolica) {
         return precoBase * 1.10; 
         }
     return precoBase;
 }
}