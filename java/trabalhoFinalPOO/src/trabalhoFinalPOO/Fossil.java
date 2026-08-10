package trabalhoFinalPOO;

import java.util.Arrays;
import java.util.List;

public abstract class Fossil implements Exibivel {
    private String nomePopular;
    private String especie;
    private String individuoMaisAntigo;
    private String periodoGeologico;
    private long idadeAnos;

    private static final List<String> PERIODOS_VALIDOS = Arrays.asList(
        "Cambriano", "Ordoviciano", "Siluriano", "Devoniano", "Carbonífero", 
        "Permiano", "Triássico", "Jurássico", "Cretáceo", "Paleógeno", "Neógeno", "Quaternário"
    );

    public Fossil() {
    }

    public Fossil(String nomePopular, String especie, String individuoMaisAntigo, 
                  String periodoGeologico, long idadeAnos) throws IdadeInvalidaException, PeriodoInvalidoException {
        this.nomePopular = nomePopular;
        this.especie = especie;
        this.individuoMaisAntigo = individuoMaisAntigo;
        validarPeriodo(periodoGeologico);
        this.periodoGeologico = periodoGeologico;
        this.idadeAnos = idadeAnos;
    }

    private void validarPeriodo(String periodo) throws PeriodoInvalidoException {
        boolean valido = PERIODOS_VALIDOS.stream().anyMatch(p -> p.equalsIgnoreCase(periodo));
        if (!valido) {
            throw new PeriodoInvalidoException("Erro Científico: O período geológico '" 
            						+ periodo + "' não é reconhecido registro geologico.");
        }
    }

    public abstract String obterTipoFossil();

    @Override
    public void exibirDetalhes() {
        System.out.println("\n - Detalhes do " + obterTipoFossil() + " -");
        System.out.println("Nome Popular: " + nomePopular);
        System.out.println("Espécie: " + especie);
        System.out.println("Período Geológico: " + periodoGeologico);
        System.out.println("Idade Estimada: " + idadeAnos + " anos");
        System.out.println("Indivíduo mais Antigo Registrado: " + individuoMaisAntigo);
    }

    // Getters e Setters
    public String getNomePopular() { return nomePopular; }
    public void setNomePopular(String nomePopular) { this.nomePopular = nomePopular; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getIndividuoMaisAntigo() { return individuoMaisAntigo; }
    public void setIndividuoMaisAntigo(String individuoMaisAntigo) { this.individuoMaisAntigo = individuoMaisAntigo; }

    public String getPeriodoGeologico() { return periodoGeologico; }
    public void setPeriodoGeologico(String periodoGeologico) throws PeriodoInvalidoException {
        validarPeriodo(periodoGeologico);
        this.periodoGeologico = periodoGeologico;
    }

    public long getIdadeAnos() { return idadeAnos; }
    public void setIdadeAnos(long idadeAnos) { this.idadeAnos = idadeAnos; }
}