package trabalhoFinalPOO;

public class Subfossil extends Fossil {
	 // Atributo específico exclusivo da subclasse
	private String estadoPreservacao; 
    private boolean possuiRestosOrganicos;

    public Subfossil(String nomePopular, String especie, String individuoMaisAntigo, 
                     String periodoGeologico, long idadeAnos, String estadoPreservacao, boolean possuiRestosOrganicos) 
                     throws IdadeInvalidaException, PeriodoInvalidoException {
    	
    	// Passa os atributos comuns para o construtor da classe Fossil
    	super(nomePopular, especie, individuoMaisAntigo, periodoGeologico, idadeAnos);
        validarIdadeSubfossil(idadeAnos);
        this.estadoPreservacao = estadoPreservacao;
        this.possuiRestosOrganicos = possuiRestosOrganicos;
    }
    // Regra específica para Macrofóssil
    private void validarIdadeSubfossil(long idade) throws IdadeInvalidaException {
        if (idade > 11000) {
            throw new IdadeInvalidaException("Erro: Um subfóssil não pode ter mais de 11.000 anos.");
        }
    }

    @Override
    public String obterTipoFossil() {
        return "Subfóssil";
    }

    @Override
    public void exibirDetalhes() {
    	//Executa a estrutura padrão da classe mãe
    	super.exibirDetalhes();
    	//Acrescenta a informação exclusiva da classe
        System.out.println("Estado de Preservação: " + estadoPreservacao);
        System.out.println("Possui DNA / Restos Orgânicos: " + (possuiRestosOrganicos ? "Sim" : "Não"));
    }

    @Override
    public String obterResumo() {
        return "[SUBFÓSSIL] " + getNomePopular() + " - Preservação: " + estadoPreservacao;
    }
}