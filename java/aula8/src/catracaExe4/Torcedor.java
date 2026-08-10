package catracaExe4;

public class Torcedor {
    private int idade;
    private boolean isSocio;
    private String setor;
    private TipoIngresso tipo;
    private boolean temCarteirinha;
    private boolean acompanhado;

    public Torcedor(int idade, boolean isSocio, String setor, TipoIngresso tipo, 
                    boolean temCarteirinha, boolean acompanhado) {
        
        if (idade < 18 && "Social".equalsIgnoreCase(setor)) {
            throw new IllegalArgumentException("Menores de idade não permitidos no setor Social do estádio.\n");
        }
        
        if (!isSocio && idade < 18 && !acompanhado) {
            throw new IllegalArgumentException("Acesso negado: Menores não-sócios precisam de acompanhante.\n");
        }

        if (tipo == TipoIngresso.MEIA && idade > 25 && !temCarteirinha) {
            throw new IllegalArgumentException("Meia-entrada acima de 25 anos exige carteirinha.\n");
        }
        
        this.idade = idade;
        this.setor = setor;
        this.isSocio = isSocio;
        this.temCarteirinha = temCarteirinha;
        this.acompanhado = acompanhado;

    }
}