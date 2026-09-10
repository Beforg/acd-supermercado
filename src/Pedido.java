import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Item> itens;
    private TipoPagamento tipoPagamento;
    private Cliente cliente;

    public Pedido(TipoPagamento tipoPagamento, Cliente cliente) {
        this.itens = new ArrayList<>();
        this.tipoPagamento = tipoPagamento;
        this.cliente = cliente;
    }

    public Pedido(Cliente cliente) {
        this(null, cliente);
    }

    public List<Item> getItens() {
        return itens;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Item adicionarItem(Item item) {
        this.itens.add(item);
        return item;
    }
    // deixei private mas poderia ser público pra chamar em algum outro lugar que precise
    private BigDecimal calcularValorTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Item item : itens) {
            total = total.add(item.getProduto().getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())));
        }
        return total;
    }

    public void imprimirItensDoPedido() {
        System.out.println("Pedido do Cliente: " + cliente.getNome());
        for (Item item : itens) {
            System.out.println("Descrição" + item.getProduto().getDescricao() +
                    " - " + item.getQuantidade() +
                    " unidades - R$ " + item.getProduto().getPreco());
        }
        System.out.println("Valor Total: R$ " + calcularValorTotal());
    }
}
