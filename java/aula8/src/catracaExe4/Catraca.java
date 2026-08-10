package catracaExe4;

public class Catraca {
    
    public void validarIngresso(int idade, boolean socio, String setor, 
                               TipoIngresso tipo, boolean carteirinha, boolean acompanhado) {
        new Torcedor(idade, socio, setor, tipo, carteirinha, acompanhado);
        
        System.out.println("Acesso liberado no setor " + setor);
    }
}