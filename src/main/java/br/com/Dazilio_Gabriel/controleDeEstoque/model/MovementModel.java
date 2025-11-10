package br.com.Dazilio_Gabriel.controleDeEstoque.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "movements")
public class MovementModel {

    @Id
    private String id;
    private LocalDate data;
    private  String tipo;
    private  Integer quantidade;

    @DBRef private ProductModel product;

    public MovementModel(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "MovementModel{" +
                "id='" + id + '\'' +
                ", data=" + data +
                ", tipo='" + tipo + '\'' +
                ", quantidade=" + quantidade +
                ", product=" + product +
                '}';
    }
}

