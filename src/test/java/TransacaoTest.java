import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoTest {


    @Test
    void deveRetornarExcecaoArgumentoNuloData(){
        try{
            Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
            Transacao transacao = new Transacao(null, produto, 100);

            fail();
        }catch (IllegalArgumentException e){
            assertEquals("O argumento data nao pode ser nulo.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoArgumentoNuloProduto(){
        try{
            Transacao transacao = new Transacao("01/08/2021", null, 100);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("O argumento produto nao pode ser nulo.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoArgumentoNegativoQuantidade(){
        try{
            Produto produto = new Produto("Batata", 100, 1.40f, 50, 150);
            Transacao transacao = new Transacao("01/08/2021", produto, -100);

            fail();
        }catch (IllegalArgumentException e){
            assertEquals("O argumento quantidade nao pode ser negativo.", e.getMessage());
        }
    }

}