package br.com.Dazilio_Gabriel.controleDeEstoque.service;

import br.com.Dazilio_Gabriel.controleDeEstoque.model.MovementModel;
import br.com.Dazilio_Gabriel.controleDeEstoque.model.ProductModel;
import br.com.Dazilio_Gabriel.controleDeEstoque.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import br.com.Dazilio_Gabriel.controleDeEstoque.model.MovementTypeReport;

import java.util.List;

@Service
public class StockService {

    private final MongoTemplate mongoTemplate;
    private ProductRepository productRepository;

    @Autowired
    public StockService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    //  metodos produtos

    public void inserirProdutos(ProductModel produto) {
        this.mongoTemplate.save(produto);
        System.out.println("produto salvo: " + produto.getNome());
    }

    public List<ProductModel> listarTodosOsProdutos() {
        return this.mongoTemplate.findAll(ProductModel.class);
    }

    public long contarProdutos() {
        return this.mongoTemplate.count(new Query(), ProductModel.class);
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

    public ProductModel buscarProdutoPorId(String id) {
        return this.mongoTemplate.findById(id, ProductModel.class);
    }


    //  metodos movimentacoes

    @Transactional
    public void inserirMovimentacao(MovementModel mov) {
        this.mongoTemplate.save(mov);
        System.out.println("movimentacao registrada: " + mov.getTipo());

        String idDoProduto = mov.getProduct().getId();
        int quantidadeParaMudar = mov.getQuantidade();

        if ("SAIDA".equalsIgnoreCase(mov.getTipo())) {
            quantidadeParaMudar = -quantidadeParaMudar;
        }

        Query query = new Query(Criteria.where("id").is(idDoProduto));
        Update update = new Update().inc("estoqueAtual", quantidadeParaMudar);

        this.mongoTemplate.updateFirst(query, update, ProductModel.class);
        System.out.println("estoque do produto ID " + idDoProduto + " atualizado.");
    }

    public List<MovementModel> listarTodasAsMovimentacoes() {
        return this.mongoTemplate.findAll(MovementModel.class);
    }

    public long contarMovimentacoes() {
        return this.mongoTemplate.count(new Query(), MovementModel.class);
    }

    public long contarMovimentacoesPorProduto(String idDoProduto) {
        Query query = new Query(Criteria.where("product").is(idDoProduto));
        return this.mongoTemplate.count(query, MovementModel.class);
    }

    public MovementModel buscarMovimentacaoPorId(String id) {
        return this.mongoTemplate.findById(id, MovementModel.class);
    }

    public List<MovementTypeReport> gerarRelatorioPorTipo() {

        GroupOperation operation = Aggregation.group("tipo").sum("quantidade").as("totalQuantidade");
        Aggregation aggregation = Aggregation.newAggregation(operation);

        return this.mongoTemplate.aggregate(aggregation, "movements", MovementTypeReport.class).getMappedResults();
    }

    //metodos para teste JUnit

    public ProductModel findById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado para o id: " + id));
    }

}