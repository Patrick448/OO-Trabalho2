public class Fornecedor extends Pessoa{

    private String cnpj;

    public Fornecedor(String cnpj, String nome) {
        super(nome);
        this.cnpj = cnpj;
    }

}
