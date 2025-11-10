package br.com.Dazilio_Gabriel.controleDeEstoque.service;


import br.com.Dazilio_Gabriel.controleDeEstoque.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Service
public class StockService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public StockService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void inserirProdutos(ProductModel produto) {
        this.mongoTemplate.save(produto);
        System.out.println("produto salvo: " + produto.getNome());
    }

    public List<ProductModel> listarTodosOsProdutos() {
        return this.mongoTemplate.findAll(ProductModel.class);
    }

    public void removerProdutos(String idProduto) {
        Query query = new Query(Criteria.where("id").is(idProduto));

        this.mongoTemplate.remove(query, ProductModel.class);
        System.out.println("produto removido: " + idProduto);
    }

    public void atualizarProduto(String idProduto, ProductModel dadosNovos) {
        Query query = new Query(Criteria.where("id").is(idProduto));

        Update update = new Update();
        update.set("nome", dadosNovos.getNome());
        update.set("descricao", dadosNovos.getDescricao());
        update.set("estoqueAtual", dadosNovos.getEstoqueAtual());

        this.mongoTemplate.updateFirst(query, update, ProductModel.class);
        System.out.println("produto atualizado: " + dadosNovos.getNome());
    }

}