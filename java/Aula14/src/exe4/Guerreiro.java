package exe4;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome, int pontosVida) {
        super(nome, pontosVida);
    }

    @Override
    public void atacar(Personagem alvo) throws AlvoInvalidoException {
        if (alvo.getPontosVida() <= 0) {
            throw new AlvoInvalidoException(alvo.getNome() + " já está fora de combate!");
        }
        System.out.println(getNome() + " desfere um golpe de espada em " + alvo.getNome());
        alvo.setPontosVida(alvo.getPontosVida() - 20);
    }
}