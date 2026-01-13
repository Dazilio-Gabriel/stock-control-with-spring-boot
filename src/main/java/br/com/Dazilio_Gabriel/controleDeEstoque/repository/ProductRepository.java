package br.com.Dazilio_Gabriel.controleDeEstoque.repository;

import br.com.Dazilio_Gabriel.controleDeEstoque.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModel, String> {

}