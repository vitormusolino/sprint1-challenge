package br.com.modelo;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Material> materiais;

    public Estoque() {
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

    @Override
    public String toString() {
        return "Estoque: \n" +
                materiais;
    }
}
