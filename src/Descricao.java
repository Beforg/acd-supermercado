public enum Descricao {
    ARROZ("Arroz"),
    FEIJAO("Feijão"),
    FARINHA("Farinha"),
    LEITE("Leite");

    private final String descricao;

    Descricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a descrição em String.
     * @return String com a descrição do enum.
     */
    public String getDescricao() {
        return descricao;
    }
}
