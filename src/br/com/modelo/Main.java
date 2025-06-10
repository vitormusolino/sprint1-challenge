package br.com.modelo;

public class Main {
    public static void main(String[] args) {
        Material agulha = new Material(001,"Agulha",1000);
        Material algodao = new Material(002,"Algodão",700);

        Estoque almoxarifado = new Estoque();

        System.out.println(agulha);
        System.out.println(algodao);

        agulha.adicionarMaterial(500);
        System.out.println(agulha);
        algodao.removerMaterial(200);

        almoxarifado.adicionarMateriais(agulha);
        almoxarifado.adicionarMateriais(algodao);

        System.out.println(almoxarifado);

        algodao.removerMaterial(100);
        System.out.println(almoxarifado);
    }
}
