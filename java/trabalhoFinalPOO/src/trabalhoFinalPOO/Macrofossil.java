package trabalhoFinalPOO;

public class Macrofossil extends Fossil {
    // Atributo específico exclusivo da subclasse
    private String tipoPreservacao; 
    
    public Macrofossil(String nomePopular, String especie, String individuoMaisAntigo, 
                       String periodoGeologico, long idadeAnos, String tipoPreservacao) 
                       throws IdadeInvalidaException, PeriodoInvalidoException {
        
    	// Passa os atributos comuns para o construtor da classe Fossil
    	super(nomePopular, especie, individuoMaisAntigo, periodoGeologico, idadeAnos);
        
        validarIdadeMacrofossil(idadeAnos);
        
        this.tipoPreservacao = tipoPreservacao;
    }

    // Regra específica para Macrofóssil
    private void validarIdadeMacrofossil(long idade) throws IdadeInvalidaException {
        if (idade <= 11000) {
            throw new IdadeInvalidaException("Erro: Um macrofóssil autêntico deve ter mais de 11.000 anos.");
        }
    }

    @Override
    public String obterTipoFossil() {
        return "Macrofóssil";
    }

    @Override
    public void exibirDetalhes() {
        //Executa a estrutura padrão da classe mãe
        super.exibirDetalhes(); 
        
        //Acrescenta a informação exclusiva da classe
        System.out.println("Tipo de Preservação: " + tipoPreservacao);
    }

    @Override
    public String obterResumo() {
        return "[MACRO] " + getNomePopular() + " (" + getEspecie() + ")";
    }

    // Getter e Setter 
    public String getTipoPreservacao() {
        return tipoPreservacao;
    }

    public void setTipoPreservacao(String tipoPreservacao) {
        this.tipoPreservacao = tipoPreservacao;
    }
}