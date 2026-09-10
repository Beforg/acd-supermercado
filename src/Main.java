import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Item> itensDisponiveis = List.of(
                new Item(new Produto(Descricao.ARROZ, new BigDecimal("50.0"), 10), 1),
                new Item(new Produto(Descricao.FARINHA, new BigDecimal("100.0"), 5), 1),
                new Item(new Produto(Descricao.FEIJAO, new BigDecimal("200.0"), 3), 1),
                new Item(new Produto(Descricao.LEITE, new BigDecimal("150.0"), 8), 1)
        );
        Pedido pedido = null;
        Scanner sc = new Scanner(System.in);
        int op = -1;

        while (op != 0) {
            Menu.exibirMenu();
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = sc.next();
                    System.out.println("Digite o CPF:");
                    String cpf = sc.next();
                    Cliente cliente = new Cliente(nomeCliente, cpf);
                    pedido = new Pedido(cliente);
                    int pedidoSelecionado = -2;
                    while (pedidoSelecionado != -1) {
                        Menu.exibirEtapaDeRealizarPedido(itensDisponiveis);
                        pedidoSelecionado = sc.nextInt();
                        if (pedidoSelecionado == -1) break;
                        try {
                            adicionarItemDisponivelAoPedido(itensDisponiveis, pedido, pedidoSelecionado - 1 );
                        } catch (OpcaoInvalidaException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }
                    break;
                case 2:
                    if (pedido != null) {
                        Menu.exibirEtapaDePagamento(pedido);
                        int pagamentoSelecionado = sc.nextInt();
                        try {
                            TipoPagamento tipo = adicionarTipoPagamento(pagamentoSelecionado - 1);
                            pedido.setTipoPagamento(tipo);
                        } catch (EnumInvalidoException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Não há pedido em andamento.");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private static void adicionarItemDisponivelAoPedido(List<Item> disponiveis, Pedido pedido, int selecionado) {
        if (selecionado >= 0 && selecionado < disponiveis.size()) {
            Item item = disponiveis.get(selecionado);
            disponiveis.get(selecionado)
                    .getProduto()
                    .setQuantidadeDeEstoque(disponiveis.get(selecionado).getProduto().getQuantidadeDeEstoque() - 1);
            pedido.adicionarItem(item);
            System.out.println("Item adicionado: " + item.getProduto().getDescricao());
        } else throw new OpcaoInvalidaException("Item selecionado não é válido.");
    }

    private static TipoPagamento adicionarTipoPagamento(int selecionado) {
        if (selecionado >= 0 && selecionado < TipoPagamento.values().length) {
            TipoPagamento tipoPagamento = TipoPagamento.values()[selecionado];
            System.out.println("Tipo de pagamento selecionado: " + tipoPagamento.getTipoPagamento());
            return tipoPagamento;
        } else throw new EnumInvalidoException("Tipo de pagamento selecionado não é válido.");

    }
}
