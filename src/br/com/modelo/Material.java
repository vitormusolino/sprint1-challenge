package br.com.modelo;

public class Material {
    private int codigo;
    private String nome;
    private int quantidade;
    private Localizacao localizacao;

    public Material(int codigo, String nome, int quantidade, Localizacao localizacao){
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.localizacao = localizacao;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "; Material: " + nome + "; Quantidade: " + quantidade + "; Localização: " + localizacao + ".\n";
    }
}
