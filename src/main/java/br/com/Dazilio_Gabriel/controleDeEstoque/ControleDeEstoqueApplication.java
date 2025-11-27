package br.com.Dazilio_Gabriel.controleDeEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.Dazilio_Gabriel.controleDeEstoque.service.StockService;
import br.com.Dazilio_Gabriel.controleDeEstoque.model.ProductModel;
import br.com.Dazilio_Gabriel.controleDeEstoque.model.MovementModel;
import br.com.Dazilio_Gabriel.controleDeEstoque.model.MovementTypeReport;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

@SpringBootApplication
public class ControleDeEstoqueApplication implements CommandLineRunner {

    private final StockService stockService;

    @Autowired
    public ControleDeEstoqueApplication(StockService stockService) {
        this.stockService = stockService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ControleDeEstoqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int totalProdutos = (int) stockService.contarProdutos();
        int totalMovimentacoes = (int) stockService.contarMovimentacoes();

        System.out.println("##################################################");
        System.out.println("#                                                #");
        System.out.println("#        SISTEMA DE CONTROLE DE ESTOQUE          #");
        System.out.println("#                                                #");
        System.out.println("#      TOTAL DE REGISTROS EXISTENTES             #");
        System.out.printf("#  1 - PRODUTOS:      %5d                      #%n", totalProdutos);
        System.out.printf("#  2 - MOVIMENTAÇÕES: %5d                      #%n", totalMovimentacoes);
        System.out.println("#                                                #");
        System.out.println("#      CRIADO POR: GABRIEL DAZILIO               #");
        System.out.println("#                  VICTOR CASTRO                 #");
        System.out.println("#                                                #");
        System.out.println("#      DISCIPLINA: BANCO DE DADOS                #");
        System.out.println("#      PROFESSOR: HOWARD ROATTI                  #");
        System.out.println("#                                                #");
        System.out.println("##################################################\n");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Relatórios");
            System.out.println("2 - Inserir Registro");
            System.out.println("3 - Remover Registro");
            System.out.println("4 - Atualizar Registro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite apenas números.");
                scanner.next();
                opcao = -1;
                continue;
            }
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    String continuarRelatorio;
                    do {
                        System.out.println("\n--- RELATORIOS ---");
                        System.out.println("1 - Listar Todas as Movimentações (com Nome do Produto)");
                        System.out.println("2 - Total de Itens Movimentados por Tipo (PENDENTE)");
                        System.out.println("3 - Produtos Cadastrados no sistema");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        int subOpcaoRelatorios = scanner.nextInt();
                        scanner.nextLine();

                        switch (subOpcaoRelatorios) {
                            case 1:
                                System.out.println("\n--- TODAS AS MOVIMENTACOES REGISTRADAS ---");
                                List<MovementModel> listaMovimentacoesRelatorio = stockService.listarTodasAsMovimentacoes();

                                if (listaMovimentacoesRelatorio == null || listaMovimentacoesRelatorio.isEmpty()) {
                                    System.out.println("Nenhuma movimentação encontrada.");
                                } else {
                                    for (MovementModel mov : listaMovimentacoesRelatorio) {
                                        System.out.println("ID: " + mov.getId() + " | Produto: [" + mov.getProduct().getId() + "] " + mov.getProduct().getNome() + " | Tipo: " + mov.getTipo() + " | Qtd: " + mov.getQuantidade() + " | Data: " + mov.getData());
                                    }
                                }
                                System.out.println("---------------------------------------------------------------------");
                                break;
                            case 2:
                                System.out.println("\n--- RELATÓRIO: TOTAL POR TIPO ---");
                                List<MovementTypeReport> relatorio = stockService.gerarRelatorioPorTipo();

                                if (relatorio == null || relatorio.isEmpty()) {
                                    System.out.println("Nenhum dado encontrado.");
                                } else {
                                    for (MovementTypeReport item : relatorio) {
                                        System.out.println("Tipo: " + item.getTipo() + " | Total de Itens: " + item.getTotalQuantidade());
                                    }
                                }
                                System.out.println("---------------------------------");
                                break;

                            case 3:
                                List<ProductModel> listaDosProdutosRelatorios = stockService.listarTodosOsProdutos();
                                System.out.println("\n--- PRODUTOS CADASTRADOS ---");
                                for (ProductModel produto : listaDosProdutosRelatorios) {
                                    System.out.println("ID: " + produto.getId() + " | Nome: " + produto.getNome() + " | Quantidade: " + produto.getEstoqueAtual());
                                }
                                System.out.println("---------------------------------------");
                                break;

                            case 0:
                                System.out.println("Voltando ao menu principal");
                                break;
                            default:
                                System.out.println("Opção de relatório inválida.");
                                break;
                        }
                        if (subOpcaoRelatorios != 0) {
                            System.out.print("\nDeseja ver outro relatório? (S/N): ");
                            continuarRelatorio = scanner.nextLine();
                        } else {
                            continuarRelatorio = "N";
                        }
                    } while (continuarRelatorio.equalsIgnoreCase("S"));
                    break;

                case 2:
                    String continuarInsercao;
                    do {
                        System.out.println("\n--- INSERIR REGISTRO ---");
                        System.out.println("1 - Inserir Produto");
                        System.out.println("2 - Inserir Movimentação");
                        System.out.println("0 - Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        int subOpcaoInserir = scanner.nextInt();
                        scanner.nextLine();

                        switch (subOpcaoInserir) {
                            case 1:
                                System.out.println("\n--- INSERIR NOVO PRODUTO ---");
                                System.out.print("Digite o nome do produto: ");
                                String nome = scanner.nextLine();
                                System.out.print("Digite a descrição: ");
                                String descricao = scanner.nextLine();
                                System.out.print("Digite a quantidade em estoque: ");
                                int estoque = scanner.nextInt();
                                scanner.nextLine();

                                ProductModel novoProduto = new ProductModel();
                                novoProduto.setNome(nome);
                                novoProduto.setDescricao(descricao);
                                novoProduto.setEstoqueAtual(estoque);

                                stockService.inserirProdutos(novoProduto);
                                System.out.println("Produto inserido com sucesso!");
                                break;
                            case 2:
                                System.out.println("\n--- INSERIR NOVA MOVIMENTACAO ---");
                                List<ProductModel> listaDosProdutosMov = stockService.listarTodosOsProdutos();
                                if (listaDosProdutosMov == null || listaDosProdutosMov.isEmpty()) {
                                    System.out.println("ERRO: Cadastre produtos antes de inserir movimentações.");
                                    break;
                                }
                                System.out.println("\n--- PRODUTOS DISPONÍVEIS ---");
                                for (ProductModel produto : listaDosProdutosMov) {
                                    System.out.println("ID: " + produto.getId() + " | Nome: " + produto.getNome());
                                }
                                System.out.println("---------------------------------------");

                                System.out.print("Digite o ID do produto que você irá movimentar: ");
                                String idProdMov = scanner.nextLine();

                                System.out.print("Digite o tipo da movimentação (ENTRADA/SAIDA): ");
                                String tipoMov = scanner.nextLine();
                                System.out.print("Digite a quantidade: ");
                                int quantidadeMov = scanner.nextInt();
                                scanner.nextLine();

                                ProductModel produtoSelecionado = stockService.buscarProdutoPorId(idProdMov);
                                LocalDate dataAtual = LocalDate.now();

                                if (produtoSelecionado != null) {
                                    MovementModel novaMovimentacao = new MovementModel();
                                    novaMovimentacao.setProduct(produtoSelecionado);
                                    novaMovimentacao.setTipo(tipoMov);
                                    novaMovimentacao.setQuantidade(quantidadeMov);
                                    novaMovimentacao.setData(dataAtual);

                                    stockService.inserirMovimentacao(novaMovimentacao);
                                    System.out.println("Movimentação inserida com sucesso! Estoque atualizado.");
                                } else {
                                    System.out.println("Erro: Produto com o ID informado não foi encontrado.");
                                }
                                break;
                            case 0:
                                System.out.println("\nVoltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção do sub-menu inválida.");
                                break;
                        }

                        if (subOpcaoInserir != 0) {
                            System.out.print("\nDeseja inserir outro registro? (S/N): ");
                            continuarInsercao = scanner.nextLine();
                        } else {
                            continuarInsercao = "N";
                        }

                    } while (continuarInsercao.equalsIgnoreCase("S"));
                    break;

                case 3:
                    String continuarRemocao;
                    do {
                        System.out.println("\n--- REMOVER REGISTRO ---");
                        System.out.println("1 - Remover Produto");
                        System.out.println("2 - Remover Movimentação (Não implementado)");
                        System.out.println("0 - Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        int subOpcaoRemover = scanner.nextInt();
                        scanner.nextLine();

                        switch (subOpcaoRemover) {
                            case 1:
                                System.out.println("\n--- REMOVER PRODUTO ---");
                                List<ProductModel> listaDosProdutos = stockService.listarTodosOsProdutos();
                                if (listaDosProdutos == null || listaDosProdutos.isEmpty()) {
                                    System.out.println("Nenhum produto cadastrado para remover.");
                                    break;
                                }
                                System.out.println("\n--- PRODUTOS CADASTRADOS ---");
                                for (ProductModel produto : listaDosProdutos) {
                                    System.out.println("ID: " + produto.getId() + " | Nome: " + produto.getNome());
                                }
                                System.out.println("---------------------------------------");
                                System.out.print("Digite o ID do produto que deseja remover: ");
                                String idProdDel = scanner.nextLine();

                                long contagem = stockService.contarMovimentacoesPorProduto(idProdDel);

                                if (contagem > 0) {
                                    System.out.println("\nERRO: Este produto não pode ser removido, pois possui " + contagem + " movimentacao(ões) associada(s).");
                                } else {
                                    ProductModel produtoParaRemover = stockService.buscarProdutoPorId(idProdDel);
                                    if (produtoParaRemover != null) {
                                        System.out.print("Tem certeza que deseja remover o produto '" + produtoParaRemover.getNome() + "'? (S/N): ");
                                        String confirmacao = scanner.nextLine();
                                        if (confirmacao.equalsIgnoreCase("S")) {
                                            stockService.removerProdutos(idProdDel);
                                            System.out.println("Produto removido com sucesso!");
                                        } else {
                                            System.out.println("Operação cancelada.");
                                        }
                                    } else {
                                        System.out.println("Erro: Produto com o ID informado não foi encontrado.");
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("\n--- REMOVER MOVIMENTAÇÃO ---");
                                System.out.println("Funcionalidade de remover movimentação ainda não implementada.");
                                break;

                            case 0:
                                System.out.println("\nVoltando ao menu principal...");
                                break;

                            default:
                                System.out.println("Opção do sub-menu inválida.");
                                break;
                        }

                        if (subOpcaoRemover != 0) {
                            System.out.print("\nDeseja remover outro registro? (S/N): ");
                            continuarRemocao = scanner.nextLine();
                        } else {
                            continuarRemocao = "N";
                        }

                    } while (continuarRemocao.equalsIgnoreCase("S"));
                    break;

                case 4:
                    String continuarAtualizacao;
                    do {
                        System.out.println("\n--- ATUALIZAR REGISTRO ---");
                        System.out.println("1 - Atualizar Produto");
                        System.out.println("2 - Atualizar Movimentação (Não implementado)");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        int subOpcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (subOpcao) {
                            case 1:
                                System.out.println("\n--- ATUALIZAR PRODUTO ---");
                                List<ProductModel> listaDosProdutos = stockService.listarTodosOsProdutos();
                                if (listaDosProdutos == null || listaDosProdutos.isEmpty()) {
                                    System.out.println("Nenhum produto cadastrado para atualizar.");
                                    break;
                                }
                                System.out.println("\n--- PRODUTOS CADASTRADOS ---");
                                for (ProductModel produto : listaDosProdutos) {
                                    System.out.println("ID: " + produto.getId() + " | Nome: " + produto.getNome());
                                }
                                System.out.println("---------------------------------------");

                                System.out.print("Digite o ID do produto que deseja alterar: ");
                                String idParaAtualizar = scanner.nextLine();

                                ProductModel produtoOriginal = stockService.buscarProdutoPorId(idParaAtualizar);
                                if (produtoOriginal == null) {
                                    System.out.println("Erro: Produto com ID informado não encontrado.");
                                    break;
                                }

                                System.out.print("Digite o NOVO nome do produto: ");
                                String novoNome = scanner.nextLine();
                                System.out.print("Digite a NOVA descrição: ");
                                String novaDescricao = scanner.nextLine();
                                System.out.print("Digite a NOVA quantidade em estoque: ");
                                int novoEstoque = scanner.nextInt();
                                scanner.nextLine();

                                ProductModel produtoAtualizado = new ProductModel();
                                produtoAtualizado.setNome(novoNome);
                                produtoAtualizado.setDescricao(novaDescricao);
                                produtoAtualizado.setEstoqueAtual(novoEstoque);

                                stockService.atualizarProduto(idParaAtualizar, produtoAtualizado);

                                System.out.println("\n--- Registro Atualizado ---");
                                break;

                            case 2:
                                System.out.println("\n--- ATUALIZAR MOVIMENTAÇÃO ---");
                                System.out.println("Funcionalidade de atualizar movimentação ainda não implementada.");
                                break;

                            case 0:
                                System.out.println("\nVoltando ao menu principal");
                                break;

                            default:
                                System.out.println("Opção do sub-menu inválida.");
                                break;
                        }

                        if (subOpcao != 0) {
                            System.out.print("\nDeseja atualizar outro registro? (S/N): ");
                            continuarAtualizacao = scanner.nextLine();
                        } else {
                            continuarAtualizacao = "N";
                        }

                    } while (continuarAtualizacao.equalsIgnoreCase("S"));
                    break;

                case 0:
                    System.out.println("Saindo do sistema... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção do menu.");
                    break;
            }
        }
        scanner.close();
    }
}