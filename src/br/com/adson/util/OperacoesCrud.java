package br.com.adson.util;


public enum OperacoesCrud {

    NOVO(1), EDITAR(2), EXLUIR(3);
    
    private final Integer operacao;

    private OperacoesCrud(Integer operacao) {
        this.operacao = operacao;
    }

    public Integer getOperacao() {
        return operacao;
    }
    
}
