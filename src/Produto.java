import java.math.BigDecimal;

public class Produto {
    private Descricao descricao;
    private BigDecimal preco; // Costumo usar o BigDecimal nas aplicações,usei os tipos indicados no diagrama UML nas atividades anteriores.
    private int quantidadeDeEstoque;

    public Produto(Descricao descricao, BigDecimal preco, int quantidadeDeEstoque) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeDeEstoque = quantidadeDeEstoque;
    }

    public Descricao getDescricao() {
        return descricao;
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidadeDeEstoque() {
        return quantidadeDeEstoque;
    }

    public void setQuantidadeDeEstoque(int quantidadeDeEstoque) {
        this.quantidadeDeEstoque = quantidadeDeEstoque;
    }
}
