import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CompraTest {

    @Test
    void deveRetornarCompraFalse() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Fornecedor fornecedor = new Fornecedor("123456", "X S.A.");
        Compra compra = new Compra("01/08/2021", produto, fornecedor, 51);

        assertEquals(false, compra.comprar(produto, 51));
        }

    @Test
    void deveRetornarEstoqueExcedente() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Fornecedor fornecedor = new Fornecedor("123456", "X S.A.");
        Compra compra = new Compra("01/08/2021", produto, fornecedor, 51);
        compra.comprar(produto, 51);

        assertEquals(Arrays.asList("Estoque excedente."), produto.exibirHistorico());
    }

    @Test
    void deveRetornarCompraTrue() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Fornecedor fornecedor = new Fornecedor("123456", "X S.A.");
        Compra compra = new Compra("01/08/2021", produto, fornecedor, 50);

        assertEquals(true, compra.comprar(produto, 50));
    }

    @Test
    void deveRetornarCompraProdutoNome() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Fornecedor fornecedor = new Fornecedor("123456", "X S.A.");
        Compra compra = new Compra("01/08/2021", produto, fornecedor, 50);
        compra.comprar(produto, 50);

        assertEquals(Arrays.asList("Compra do produto Batata de X S.A.."), produto.exibirHistorico());
    }

    @Test
    void deveRetornarExcecaoArgumentoNuloData(){
        try{
            Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
            Fornecedor fornecedor = new Fornecedor("123456", "X S.A.");
            Compra compra = new Compra(null, produto, fornecedor, 50);

            fail();
        }catch (IllegalArgumentException e){
            assertEquals("O argumento data nao pode ser nulo.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoArgumentoNuloProduto(){
        try{
            Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
            Fornecedor fornecedor = new Fornecedor("123456", "X S.A.");
            Compra compra = new Compra("01/08/2021", null, fornecedor, 200);

            fail();
        }catch (IllegalArgumentException e){
            assertEquals("O argumento produto nao pode ser nulo.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoArgumentoNuloFornecedor(){
        try{
            Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
            Fornecedor fornecedor = new Fornecedor("123456", "X S.A.");
            Compra compra = new Compra("01/08/2021", produto, null, 200);

            fail();
        }catch (IllegalArgumentException e){
            assertEquals("O argumento fornecedor nao pode ser nulo.", e.getMessage());
        }
    }
}