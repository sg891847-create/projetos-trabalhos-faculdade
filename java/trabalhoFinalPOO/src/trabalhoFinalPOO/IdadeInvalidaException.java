package trabalhoFinalPOO;

//Exceção para checar a idade do fóssil
public class IdadeInvalidaException extends Exception {
	
	private static final long serialVersionUID = 1L;

 public IdadeInvalidaException(String mensagem) {
     super(mensagem);
 }
}