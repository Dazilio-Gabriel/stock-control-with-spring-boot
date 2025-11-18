package br.com.Dazilio_Gabriel.controleDeEstoque.model;

import org.springframework.data.annotation.Id;

public class MovementTypeReport {
    @Id
    private String tipo;
    private Long totalQuantidade;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getTotalQuantidade() {
        return totalQuantidade;
    }

    public void setTotalQuantidade(Long totalQuantidade) {
        this.totalQuantidade = totalQuantidade;
    }
}