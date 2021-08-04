public class Transacao {
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
        if(quantidade<0){
            throw new IllegalArgumentException("O argumento quantidade nao pode ser negativo.");
        }
        this.data = data;
        this.quantidade = quantidade;
        this.produto = produto;
    }


}
