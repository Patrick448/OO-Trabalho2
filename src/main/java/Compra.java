public class Compra extends Transacao{
    private Fornecedor fornecedor;

    public Compra(String dataCompra, Produto produto, Fornecedor fornecedor, int quantidade) {
        super(dataCompra, produto, quantidade);
        if(fornecedor==null){
            throw new IllegalArgumentException("O argumento fornecedor nao pode ser nulo.");
        }

        this.fornecedor = fornecedor;
    }

    public boolean comprar(Produto produto, int quantidade){
        boolean excedente = produto.verificarEstoqueExcedente(quantidade);

        if(excedente){
            produto.resgistrarHistorico("Estoque excedente.");
            return false;
        }
        String descEvento = "Compra do produto " + produto.getNome() + " de " + this.fornecedor.getNome() + ".";
        produto.creditarEstoque(quantidade);
        produto.resgistrarHistorico(descEvento);


        return true;
    }
}
