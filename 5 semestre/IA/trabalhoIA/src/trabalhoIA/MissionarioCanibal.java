package trabalhoIA;

import busca.Estado;
import busca.BuscaLargura;
import busca.MostraStatusConsole;
import busca.Nodo;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MissionarioCanibal implements Estado {

    final int mOrigem, cOrigem;     
    final int barco; 
    final String op;

    public MissionarioCanibal(int m, int c, int b, String op) {
        this.mOrigem = m;
        this.cOrigem = c;
        this.barco = b;
        this.op = op;
    }

    @Override
    public String getDescricao() {
        return "Problema dos Missionários e Canibais";
    }

    @Override
    public boolean ehMeta() {
        return mOrigem == 0 && cOrigem == 0 && barco == 1;
    }

    @Override
    public int custo() {
        return 1;
    }

    @Override
    public List<Estado> sucessores() {
        List<Estado> suc = new LinkedList<>();
        
        int[][] movimentos = {{1, 0}, {2, 0}, {0, 1}, {0, 2}, {1, 1}};

        for (int[] mov : movimentos) {
            int mLevar = mov[0];
            int cLevar = mov[1];

            if (barco == 0) { 
                gerarNovoEstado(mOrigem - mLevar, cOrigem - cLevar, 1, mLevar, cLevar, "Leva ", suc);
            } else { 
                gerarNovoEstado(mOrigem + mLevar, cOrigem + cLevar, 0, mLevar, cLevar, "Traz ", suc);
            }
        }
        return suc;
    }

    private void gerarNovoEstado(int novoM, int novoC, int novoB, int m, int c, String acao, List<Estado> lista) {
        if (novoM >= 0 && novoM <= 3 && novoC >= 0 && novoC <= 3) {
            if (ehSeguro(novoM, novoC) && ehSeguro(3 - novoM, 3 - novoC)) {
                lista.add(new MissionarioCanibal(novoM, novoC, novoB, acao + m + "M e " + c + "C"));
            }
        }
    }

    private boolean ehSeguro(int m, int c) {
        if (m > 0 && m < c) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MissionarioCanibal)) return false;
        MissionarioCanibal that = (MissionarioCanibal) o;
        return mOrigem == that.mOrigem && cOrigem == that.cOrigem && barco == that.barco;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mOrigem, cOrigem, barco);
    }

    @Override
    public String toString() {
        String margem = (barco == 0) ? "Origem" : "Destino";
        return String.format("(M:%d, C:%d) Barco em: %s -> %s\n", mOrigem, cOrigem, margem, op);
    }

    public static void main(String[] args) {
        MissionarioCanibal inicial = new MissionarioCanibal(3, 3, 0, "Início");

        Nodo solucao = new BuscaLargura(new MostraStatusConsole()).busca(inicial);

        if (solucao != null) {
            System.out.println("Solução encontrada:\n" + solucao.montaCaminho());
        } else {
            System.out.println("Nenhuma solução encontrada.");
        }
    }
}