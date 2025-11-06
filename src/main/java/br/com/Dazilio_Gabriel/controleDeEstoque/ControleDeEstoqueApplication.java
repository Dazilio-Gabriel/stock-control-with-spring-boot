package br.com.Dazilio_Gabriel.controleDeEstoque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControleDeEstoqueApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ControleDeEstoqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("primeiro print de teste");

    }
}
