package br.com.modelo;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private String nomeEstoque;
    private List<Material> materiais;

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }

    public String getNomeEstoque() {
        return nomeEstoque;
    }

    public void setNomeEstoque(String nomeEstoque) {
        this.nomeEstoque = nomeEstoque;
    }

    public Estoque(String nomeEstoque) {
        this.nomeEstoque = nomeEstoque;
        this.materiais = new ArrayList<>();
    }

    public void adicionarMateriais(Material material){
        if(material!= null){
            materiais.add(material);
            System.out.println("Material adicionado no estoque.");
        }else{
            System.out.println("Não foi possível adicionar o material.");
        }
    }

    public Material buscarMaterialPorCodigo(int codigo) {
        for (Material m : materiais) {
            if (m.getCodigo() == codigo) {
                return m;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Estoque: ").append(nomeEstoque).append(" ---\n");
        if (materiais.isEmpty()) {
            sb.append("   (Vazio)\n");
        } else {
            for (Material material : materiais) {
                sb.append("   - ").append(material.toString());
            }
        }
        sb.append("--------------------------------------\n");
        return sb.toString();
    }
}
