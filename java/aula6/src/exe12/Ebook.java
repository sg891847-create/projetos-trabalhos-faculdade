package exe12;

public class Ebook extends Livro {
    private double tamanhoArquivoMB;

    public Ebook(String titulo, String autor, double tamanhoArquivoMB) {
        super(titulo, autor); 
        this.tamanhoArquivoMB = tamanhoArquivoMB;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes(); 
        System.out.println("Tamanho do arquivo: " + tamanhoArquivoMB + " MB");
    }
}
