package br.com.Dazilio_Gabriel.controleDeEstoque.service;


import br.com.Dazilio_Gabriel.controleDeEstoque.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public StockService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void inserirProdutos(ProductModel produto) {
        this.mongoTemplate.save(produto);

    }

    public void listarTodosOsProdutos(ProductModel produto) {

    }

    public void removerProdutos(ProductModel produto) {

    }

}