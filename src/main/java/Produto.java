import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private int quantidadeEstoque;
    private float precoUnitario;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private List<String> historico;

    public Produto(String nome, int quantidadeEstoque, float precoUnitario, int estoqueMinimo, int estoqueMaximo) {
        if(nome==null){
            throw new IllegalArgumentException("O argumento nome nao pode ser nulo.");
        }

        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoUnitario = precoUnitario;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.historico = new ArrayList<String>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void debitarEstoque(int quantidade){
        this.quantidadeEstoque-=quantidade;
    }

    public void creditarEstoque(int quantidade){
        this.quantidadeEstoque+=quantidade;
    }

    public boolean verificarEstoqueInsuficiente(int quantidade){
        return quantidade>this.quantidadeEstoque;
    }

    public boolean verificarEstoqueBaixo(){
        return this.quantidadeEstoque < this.estoqueMinimo;
    }

    public boolean verificarEstoqueExcedente(int quantidade){
        return this.quantidadeEstoque + quantidade > this.estoqueMaximo;
    }

    public float calcularValorVenda(int quantidade){
        return this.precoUnitario*quantidade;
    }

    public void vender(String data, Cliente cliente, int quatidade){
        Venda venda = new Venda(data,this,cliente,  quatidade);
        if(venda.vender(this, quatidade)){
            this.resgistrarHistorico("Venda do produto " + this.getNome() + ".");
        }
    }

    public void comprar(String data, Fornecedor fornecedor, int quantidade){
        Compra compra = new Compra(data, this, fornecedor, quantidade);

        if(compra.comprar(this, quantidade)){
            this.resgistrarHistorico("Compra do produto " + this.getNome() + ".");
        }
    }

    public void resgistrarHistorico(String evento){
        this.historico.add(evento);
    }

    public List<String> exibirHistorico(){
        return this.historico;
    }
}
