import java.util.List;

public class Menu {
    public static void exibirMenu() {
        System.out.println("=== MENU ===");
        System.out.println("1. Novo Pedido");
        System.out.println("2. Realizar Pagamento");
        System.out.println("0. Sair da Aplicação");
    }

    public static void exibirEtapaDePagamento(Pedido pedido) {
        pedido.imprimirItensDoPedido();
        System.out.println("Escolha a forma de pagamento:");
        for (TipoPagamento tipo : TipoPagamento.values()) {
            System.out.println(tipo.ordinal() + 1 + ". " + tipo.getTipoPagamento());
        }
    }

    public static void exibirEtapaDeRealizarPedido(List<Item> itensDisponiveias) {
        System.out.println("Escolha os itens do pedido (-1 para finalizar):");
        for (int i = 0; i < itensDisponiveias.size(); i++) {
            Item item = itensDisponiveias.get(i);
            System.out.println((i + 1) + ". " + item.getProduto().getDescricao() +
                    " - R$ " + item.getProduto().getPreco() +
                    " - Estoque: " + item.getProduto().getQuantidadeDeEstoque());
            System.out.println("==========================================");
        }
    }
}
