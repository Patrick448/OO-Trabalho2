public abstract class Transacao {
    private String data;
    private int quantidade;
    private Produto produto;

    public Transacao(String data, Produto produto, int quantidade) {
        if(data==null){
            throw new IllegalArgumentException("O argumento data nao pode ser nulo.");
        }
        if(produto==null){
            throw new IllegalArgumentException("O argumento produto nao pode ser nulo.");
        }
        this.data = data;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
