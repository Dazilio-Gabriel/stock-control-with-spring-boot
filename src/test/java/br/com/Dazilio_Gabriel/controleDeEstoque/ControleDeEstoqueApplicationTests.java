package br.com.Dazilio_Gabriel.controleDeEstoque;

import br.com.Dazilio_Gabriel.controleDeEstoque.model.ProductModel;
import br.com.Dazilio_Gabriel.controleDeEstoque.service.StockService;
import br.com.Dazilio_Gabriel.controleDeEstoque.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ControleDeEstoqueApplicationTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private StockService stockService;

    @Test
    void deveRetornarProdutoQuandoIdExistir() {

        String id = "15";
        ProductModel produtoFalso = new ProductModel();
        produtoFalso.setId(id);


        Mockito.when(productRepository.findById(id))
                .thenReturn(Optional.of(produtoFalso));

        produtoFalso = stockService.findById(produtoFalso.getId());

        assertEquals(produtoFalso.getId() , id);

    }
}
