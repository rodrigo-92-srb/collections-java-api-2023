package main.java.OperacoesBasicas.list;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> ItensList;

    public CarrinhoDeCompras(){
        this.ItensList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        ItensList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itemsToRemove = new ArrayList<>();
        for(Item itemToRemove: ItensList){
            if(itemToRemove.getNome().equalsIgnoreCase(nome)){
                itemsToRemove.add(itemToRemove);
            }
        }
        ItensList.removeAll(itemsToRemove);
        if(!itemsToRemove.equals(null)){
            System.out.println("Item removido");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Item item : ItensList) {
            valorTotal = valorTotal + ( item.getPreco() * item.getQuantidade() );

        }
        return valorTotal;
    }

    public void exibirItens(){
        System.out.println("---------- ITENS NO CARRINHO ----------");
        for (Item item : ItensList) {
            System.out.println("Item: " + item.getNome() + " Preço: R$ " + item.getPreco() + " Quantidade: " +item.getQuantidade());
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.adicionarItem("Shampoo", 19.15, 2);
        carrinhoDeCompras.adicionarItem("Arroz", 10.99, 2);
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.removerItem("Shampoo");
        carrinhoDeCompras.exibirItens();
        double valorTotal = carrinhoDeCompras.calcularValorTotal();
        System.out.println("Valor Total: R$ "+valorTotal);
    }


}
