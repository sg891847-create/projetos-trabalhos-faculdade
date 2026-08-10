package trabalhoFinalPOO;

public class Microfossil extends Fossil {
    // Atributo específico exclusivo da subclasse
    private String técnicaVisualizacao; // Ex: Microscópio Eletrônico de Varredura, Lupa

    public Microfossil(String nomePopular, String especie, String individuoMaisAntigo, 
                       String periodoGeologico, long idadeAnos, String técnicaVisualizacao) 
                       throws IdadeInvalidaException, PeriodoInvalidoException {
        
    	super(nomePopular, especie, individuoMaisAntigo, periodoGeologico, idadeAnos);
        
        //(mais de 11 mil anos)
        validarIdadeMicrofossil(idadeAnos);
        
        this.técnicaVisualizacao = técnicaVisualizacao;
    }

    // Regra específica para Microfóssil
    private void validarIdadeMicrofossil(long idade) throws IdadeInvalidaException {
        if (idade <= 11000) {
            throw new IdadeInvalidaException("Erro: Um microfóssil autêntico deve ter mais de 11.000 anos.");
        }
    }

    @Override
    public String obterTipoFossil() {
        return "Microfóssil";
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); 
        
        System.out.println("Técnica de Visualização Necessária: " + técnicaVisualizacao);
        }

    @Override
    public String obterResumo() {
        return "[MICRO] " + getNomePopular() + " - Técnica: " + técnicaVisualizacao;
    }

    // Getter e Setter
    public String getTécnicaVisualizacao() { 
        return técnicaVisualizacao; 
    }
    
    public void setTécnicaVisualizacao(String técnicaVisualizacao) { 
        this.técnicaVisualizacao = técnicaVisualizacao; 
    }
}