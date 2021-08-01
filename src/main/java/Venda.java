public class Venda extends  Transacao{
    private Cliente cliente;

    public Venda(String dataVenda, Produto produto, Cliente cliente, int quantidade) {
        super(dataVenda, produto, quantidade);
        if(cliente==null){
            throw new IllegalArgumentException("O argumento cliente nao pode ser nulo.");
        }
        this.cliente = cliente;
    }

    public boolean vender(Produto produto, int quantidade){
        boolean insuficiente = produto.verificarEstoqueInsuficiente(quantidade);

        if(insuficiente){
            produto.resgistrarHistorico("Estoque insuficiente.");
            return false;
        }

        produto.debitarEstoque(quantidade);
        produto.resgistrarHistorico("Valor venda = " + produto.getPrecoUnitario()*quantidade + ".");

        if(produto.verificarEstoqueBaixo()){
            produto.resgistrarHistorico("Estoque baixo.");
        }

        return true;
    }
}
