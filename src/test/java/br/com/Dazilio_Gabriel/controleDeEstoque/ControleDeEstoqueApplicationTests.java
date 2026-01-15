package br.com.Dazilio_Gabriel.controleDeEstoque;

import br.com.Dazilio_Gabriel.controleDeEstoque.model.ProductModel;
import br.com.Dazilio_Gabriel.controleDeEstoque.service.StockService;
import br.com.Dazilio_Gabriel.controleDeEstoque.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
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

        //Arrange
        String id = "15";
        ProductModel produtoFalso = new ProductModel();
        produtoFalso.setId(id);

        Mockito.when(productRepository.findById(id))
                .thenReturn(Optional.of(produtoFalso));

        //Act
        produtoFalso = stockService.findById(produtoFalso.getId());

        //Assert
        assertEquals(produtoFalso.getId(), id);
    }

    @Test
    void deveRetornarProdutoQuandoIdNaoExistir() {

        //Arrange
        String id = "15";
        ProductModel produtoFalso = new ProductModel();
        produtoFalso.setId(id);

        Mockito.when(productRepository.findById(id))
                .thenReturn(Optional.empty());

        //Act + Assert
        Assertions.assertThrows(RuntimeException.class,
                () -> stockService.findById(produtoFalso.getId()));
    }

    @Test
    void deveRetornarProdutoQuandoNomeExistir() {

        //Arrenge
        String nome = "Fulano";
        ProductModel produtoFalso = new ProductModel();
        produtoFalso.setNome(nome);

        Mockito.when(productRepository.findByNome(nome))
                .thenReturn(Optional.of(produtoFalso));

        //Act
        produtoFalso = stockService.findByNome(nome);

        //Assert
        assertEquals(produtoFalso.getNome(), nome);
    }

}
