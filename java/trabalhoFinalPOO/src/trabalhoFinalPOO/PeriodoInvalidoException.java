package trabalhoFinalPOO;

//Exceção para checar o período geológico
public class PeriodoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

 public PeriodoInvalidoException(String mensagem) {
     super(mensagem);
 }
}