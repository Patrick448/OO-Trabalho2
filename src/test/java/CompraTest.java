import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    void deveRetornarListaHistoricoVaziaCompraSucesso() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Fornecedor fornecedor = new Fornecedor("123456", "X S.A.");
        Compra compra = new Compra("01/08/2021", produto, fornecedor, 50);
        compra.comprar(produto, 50);

        assertEquals(new ArrayList<String>(), produto.exibirHistorico());
    }


    @Test
    void deveRetornarExcecaoArgumentoNuloFornecedor(){
        try{
            Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
            Compra compra = new Compra("01/08/2021", produto, null, 200);

            fail();
        }catch (IllegalArgumentException e){
            assertEquals("O argumento fornecedor nao pode ser nulo.", e.getMessage());
        }
    }
}