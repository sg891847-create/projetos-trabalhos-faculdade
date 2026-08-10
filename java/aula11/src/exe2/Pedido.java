package exe2;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemCardapio> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
    }

    public double fecharConta() {
        double total = 0;
        for (ItemCardapio item : itens) {
            total += item.calcularPrecoFinal();
        }
        return total;
    }
}
