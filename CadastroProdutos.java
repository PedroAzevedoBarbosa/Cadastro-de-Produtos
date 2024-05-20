import java.util.Scanner;

class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return preco * quantidade;
    }
}

public class CadastroProdutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[3];

        System.out.println("Cadastro de Produtos");
        for (int i = 0; i < produtos.length; i++) {
            System.out.print("Digite o nome do produto " + (i + 1) + ": ");
            String nome = scanner.nextLine();

            System.out.print("Digite o preço do produto " + (i + 1) + ": ");
            double preco = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite a quantidade do produto " + (i + 1) + ": ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            produtos[i] = new Produto(nome, preco, quantidade);
        }

        System.out.println("\nDados dos produtos cadastrados:");
        double valorTotalMaximo = 0;
        Produto produtoMaximo = null;
        double somaValoresTotais = 0;

        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome() +
                    ", Preço: R$" + produto.getPreco() +
                    ", Quantidade: " + produto.getQuantidade() +
                    ", Valor Total: R$" + produto.getValorTotal());

            somaValoresTotais += produto.getValorTotal();

            if (produto.getValorTotal() > valorTotalMaximo) {
                valorTotalMaximo = produto.getValorTotal();
                produtoMaximo = produto;
            }
        }

        System.out.println("\nProduto com maior valor total:");
        if (produtoMaximo != null) {
            System.out.println("Nome: " + produtoMaximo.getNome() +
                    ", Valor Total: R$" + produtoMaximo.getValorTotal());
        } else {
            System.out.println("Nenhum produto cadastrado.");
        }

        double mediaValoresTotais = somaValoresTotais / produtos.length;
        System.out.println("\nMédia dos valores totais: R$" + mediaValoresTotais);
    }
}
