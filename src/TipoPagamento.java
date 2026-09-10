public enum TipoPagamento {
    DINHEIRO("Dinheiro"),
    CHEQUE("Cheque"),
    CARTAO("Cartão"),
    PIX("Pix");

    private final String tipoPagamento;

    TipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }
}
