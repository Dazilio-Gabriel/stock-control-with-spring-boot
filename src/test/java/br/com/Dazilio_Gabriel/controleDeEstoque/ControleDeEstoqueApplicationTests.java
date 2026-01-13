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

@ExtendWith(MockitoExtension.class)
class ControleDeEstoqueApplicationTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private StockService stockService;

    
}
