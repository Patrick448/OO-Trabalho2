import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void vender() {
    }

    @Test
    void comprar() {
    }

    @Test
    void deveRetornarEstoqueDebitado() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        produto.debitarEstoque(2);

        assertEquals(98, produto.getQuantidadeEstoque());
    }

    @Test
    void deveRetornarEstoqueCreditado() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        produto.creditarEstoque(2);

        assertEquals(102, produto.getQuantidadeEstoque());

    }

    @Test
    void deveRetornarEstoqueInsuficienteTrue() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        assertEquals(true, produto.verificarEstoqueInsuficiente(101));
    }

    @Test
    void deveRetornarEstoqueInsuficienteFalse() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        assertEquals(false, produto.verificarEstoqueInsuficiente(100));
    }

    @Test
    void deveRetornarEstoqueBaixoTrue() {
        Produto produto = new Produto("Batata", 49, 1.40f, 50, 150);
        assertEquals(true, produto.verificarEstoqueBaixo());
    }

    @Test
    void deveRetornarEstoqueBaixoFalse() {
        Produto produto = new Produto("Batata", 51, 1.40f, 50, 150);
        assertEquals(false, produto.verificarEstoqueBaixo());
    }

    @Test
    void deveRetornarEstoqueExcedenteTrue() {
        Produto produto = new Produto("Batata", 150, 1.40f, 50, 150);
        assertEquals(true, produto.verificarEstoqueExcedente(1));
    }

    @Test
    void deveRetornarEstoqueExcedenteFalse() {
        Produto produto = new Produto("Batata", 149, 1.40f, 50, 150);
        assertEquals(false, produto.verificarEstoqueExcedente(1));
    }

    @Test
    void deveRetornarValorVenda() {
        Produto produto = new Produto("Batata", 150, 1.40f, 50, 150);
        assertEquals(140.0f, produto.calcularValorVenda(100));

    }

    @Test
    void deveRetornarMensagemValorVenda() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Cliente cliente = new Cliente("123456", "Patrick");
        Venda venda = new Venda("01/08/2021", produto, cliente, 10);
        venda.vender(produto, 10);

        assertEquals(Arrays.asList("Valor venda = 14.0."), produto.exibirHistorico());
    }

    @Test
    void deveRetornarMensagemValorVendaDepoisEstoqueBaixo() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Cliente cliente = new Cliente("123456", "Patrick");
        Venda venda = new Venda("01/08/2021", produto, cliente, 51);
        venda.vender(produto, 51);

        assertEquals(Arrays.asList("Valor venda = 71.4.", "Estoque baixo."), produto.exibirHistorico());
    }

    @Test
    void deveRetornarMensagemCompra() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Fornecedor fornecedor = new Fornecedor("123456", "X S.A.");
        Compra compra = new Compra("01/08/2021", produto, fornecedor, 50);
        compra.comprar(produto, 50);

        assertEquals(Arrays.asList("Compra do produto Batata de X S.A.."), produto.exibirHistorico());
    }

    @Test
    void deveRetornarMensagemEstoqueInsuficiente() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Cliente cliente = new Cliente("123456", "Patrick");
        Venda venda = new Venda("01/08/2021", produto, cliente, 101);
        venda.vender(produto, 101);

        assertEquals(Arrays.asList("Estoque insuficiente."), produto.exibirHistorico());
    }

    @Test
    void deveRetornarMensagemEstoqueExcedente() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Fornecedor fornecedor = new Fornecedor("123456", "X S.A.");
        Compra compra = new Compra("01/08/2021", produto, fornecedor, 51);
        compra.comprar(produto, 51);

        assertEquals(Arrays.asList("Estoque excedente."), produto.exibirHistorico());
    }

    @Test
    void deveRetornarHistorico() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Fornecedor fornecedor = new Fornecedor("123456", "X S.A.");
        Cliente cliente = new Cliente("123456", "Patrick");

        Compra compra = new Compra("01/08/2021", produto, fornecedor, 51);
        compra.comprar(produto, 51);
        compra.comprar(produto, 50);

        Venda venda = new Venda("01/08/2021", produto, cliente, 100);
        venda.vender(produto, 151);
        venda.vender(produto, 150);
        List<String> esperado = Arrays.asList(
                "Estoque excedente.", "Compra do produto Batata de X S.A..",
                "Estoque insuficiente.",
                "Valor venda = 210.0.",
                "Estoque baixo.");


        assertEquals(esperado, produto.exibirHistorico());
    }


    @Test
    void deveRetornarHistoricoVazio() {
        Produto produto = new Produto("Batata", 150, 1.40f, 50, 150);
        assertEquals(new ArrayList<String>(), produto.exibirHistorico());
    }

    @Test
    void deveRetornarHistorico1Evento() {
        Produto produto = new Produto("Batata", 150, 1.40f, 50, 150);
        produto.resgistrarHistorico("Evento 1");
        assertEquals(Arrays.asList("Evento 1"), produto.exibirHistorico());
    }

    @Test
    void deveRetornarHistorico2Eventos() {
        Produto produto = new Produto("Batata", 150, 1.40f, 50, 150);
        produto.resgistrarHistorico("Evento 1");
        produto.resgistrarHistorico("Evento 2");
        assertEquals(Arrays.asList("Evento 1", "Evento 2"), produto.exibirHistorico());
    }

    @Test
    void deveRetornarExcecaoArgumentoNuloNome(){
        try{
            Produto produto = new Produto(null, 100, 1.40f, 50, 150);

            fail();
        }catch (IllegalArgumentException e){
            assertEquals("O argumento nome nao pode ser nulo.", e.getMessage());
        }
    }
}