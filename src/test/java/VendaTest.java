import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VendaTest {

    @Test
    void deveRetornarVendaFalse() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Cliente cliente = new Cliente("123456", "Patrick");
        Venda venda = new Venda("01/08/2021", produto, cliente, 101);

        assertEquals(false, venda.vender(produto, 101));
    }

    @Test
    void deveRetornarEstoqueInsuficiente() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Cliente cliente = new Cliente("123456", "Patrick");
        Venda venda = new Venda("01/08/2021", produto, cliente, 101);
        venda.vender(produto, 101);

        assertEquals(Arrays.asList("Estoque insuficiente."), produto.exibirHistorico());
    }

    @Test
    void deveRetornarVendaTrue() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Cliente cliente = new Cliente("123456", "Patrick");
        Venda venda = new Venda("01/08/2021", produto, cliente, 100);

        assertEquals(true, venda.vender(produto, 100));
    }

    @Test
    void deveRetornarValorVenda() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Cliente cliente = new Cliente("123456", "Patrick");
        Venda venda = new Venda("01/08/2021", produto, cliente, 10);
        venda.vender(produto, 10);

        assertEquals(Arrays.asList("Valor venda = 14.0."), produto.exibirHistorico());
    }

    @Test
    void deveRetornarValorVendaDepoisEstoqueBaixo() {
        Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
        Cliente cliente = new Cliente("123456", "Patrick");
        Venda venda = new Venda("01/08/2021", produto, cliente, 51);
        venda.vender(produto, 51);

        assertEquals(Arrays.asList("Valor venda = 71.4.", "Estoque baixo."), produto.exibirHistorico());
    }


    @Test
    void deveRetornarExcecaoArgumentoNuloCliente(){
        try{
            Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
            Cliente cliente = new Cliente("123456", "Patrick");
            Venda venda = new Venda("01/08/2021", produto, null, 100);

            fail();
        }catch (IllegalArgumentException e){
            assertEquals("O argumento cliente nao pode ser nulo.", e.getMessage());
        }
    }
}