package exe4;

public class Paladino extends Personagem implements Clerigo {
    public Paladino(String nome, int pontosVida) {
        super(nome, pontosVida);
    }

    @Override
    public void atacar(Personagem alvo) throws AlvoInvalidoException {
        if (alvo.getPontosVida() <= 0) {
            throw new AlvoInvalidoException(alvo.getNome() + " já está fora de combate!");
        }
        System.out.println(getNome() + " ataca com seu martelo sagrado " + alvo.getNome());
        alvo.setPontosVida(alvo.getPontosVida() - 15);
    }

    @Override
    public void curarAliado(Personagem aliado) throws AlvoInvalidoException {
        if (aliado.getPontosVida() <= 0) {
            throw new AlvoInvalidoException(aliado.getNome() + " já está fora de combate!");
        }
        System.out.println(getNome() + " canaliza a luz e cura " + aliado.getNome());
        aliado.setPontosVida(aliado.getPontosVida() + 25);
    }
}
