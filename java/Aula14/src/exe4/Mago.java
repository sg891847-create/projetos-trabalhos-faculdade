package exe4;

public class Mago extends Personagem implements Feiticeiro {
    public Mago(String nome, int pontosVida) {
        super(nome, pontosVida);
    }

    @Override
    public void atacar(Personagem alvo) throws AlvoInvalidoException {
        if (alvo.getPontosVida() <= 0) {
            throw new AlvoInvalidoException(alvo.getNome() + " já está fora de combate!");
        }
        System.out.println(getNome() + " lança um ataque básico de cajado em " + alvo.getNome());
        alvo.setPontosVida(alvo.getPontosVida() - 10);
    }

    @Override
    public void lancarFeitico(Personagem alvo) throws AlvoInvalidoException {
        if (alvo.getPontosVida() <= 0) {
            throw new AlvoInvalidoException(alvo.getNome() + " já está fora de combate!");
        }
        System.out.println(getNome() + " conjura uma Bola de Fogo devastadora em " + alvo.getNome());
        alvo.setPontosVida(alvo.getPontosVida() - 40);
    }
}