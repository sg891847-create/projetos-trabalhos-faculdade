package exe3;

public class Professor extends MembroAcademico implements Pesquisador, Avaliador {
    
    public Professor(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public void mostrarFuncao() {
        System.out.println("Função: Professor Docente e Pesquisador.");
    }

    @Override
    public void publicarArtigo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new DadosAcademicosInvalidosException("O título do artigo não pode ser vazio ou nulo.");
        }
        System.out.println("Professor " + getNome() + " publicou o artigo: " + titulo);
    }

    @Override
    public void lancarNotas(double nota) {
        if (nota < 0 || nota > 10) {
            throw new DadosAcademicosInvalidosException("Nota inválida! A nota deve ser entre 0 e 10.");
        }
        System.out.println("Nota " + nota + " lançada com sucesso pelo Professor " + getNome());
    }
}