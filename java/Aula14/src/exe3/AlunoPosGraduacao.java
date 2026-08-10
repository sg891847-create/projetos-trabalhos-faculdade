package exe3;

public class AlunoPosGraduacao extends MembroAcademico implements Pesquisador {

    public AlunoPosGraduacao(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public void mostrarFuncao() {
        System.out.println("Função: Aluno de Pós-Graduação / Pesquisador.");
    }

    @Override
    public void publicarArtigo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new DadosAcademicosInvalidosException("O título do artigo não pode ser vazio ou nulo.");
        }
        System.out.println("Aluno de Pós " + getNome() + " publicou o artigo: " + titulo);
    }
}
