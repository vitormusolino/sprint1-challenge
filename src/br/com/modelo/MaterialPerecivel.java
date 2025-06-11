package br.com.modelo;

import java.time.LocalDate;

public class MaterialPerecivel extends Material{
    private LocalDate dataVencimento;

    public MaterialPerecivel(int codigo, String nome, int quantidade, Localizacao localizacao,LocalDate dataVencimento ) {
        super(codigo, nome, quantidade, localizacao);
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public boolean estaVencido() {
        return LocalDate.now().isAfter(dataVencimento);
    }

    @Override
    public String toString() {
        String infoMaterialBase = super.toString().trim();
        String infoVencimento = "; Vencimento: " + dataVencimento;
        if (estaVencido()) {
            infoVencimento += " (VENCIDO!)";
        }
        return infoMaterialBase + infoVencimento + ".\n";
    }
}
