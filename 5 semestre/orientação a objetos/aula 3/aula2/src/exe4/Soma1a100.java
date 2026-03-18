package exe4;

public class Soma1a100 {

	public static void main(String[] args) {
	
//		int i;
//		
//		for(i = 1; i < 100; i++ ) {
//			
//			int soma = i+1;
//			
//		System.out.println("soma de 1 a 100:" +soma);
//		}
		
		//com acumulador	
		int acumulador = 0;
		
		for(int e = 1; e <= 100; e++ ) {
			
			acumulador = acumulador + e;
			
		System.out.println("A soma total de 1 a 100 é: " + acumulador);
		}
	}

}
