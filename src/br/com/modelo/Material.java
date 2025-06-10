package br.com.modelo;

public class Material {
    private int codigo;
    private String nome;
    private int quantidade;

    public Material(int codigo, String nome, int quantidade){
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public void adicionarMaterial(int qtd){
        this.quantidade += qtd;
        System.out.println(nome + " adicionado no estoque. (" + qtd + ")");
    }

    public void removerMaterial(int qtd){
        if(qtd > quantidade){
            System.out.println("Não foi possível remover o material");
        }else{
            this.quantidade -= qtd;
            System.out.println(nome + " removido do estoque. (" + qtd + ")");
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "; Material: " + nome + "; Quantidade: " + quantidade+"\n";
    }
}
