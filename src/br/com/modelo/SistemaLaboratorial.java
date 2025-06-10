package br.com.modelo;

import java.time.LocalDate;

public class SistemaLaboratorial {

    public static void realizarTransferencia(Estoque origem, Estoque destino, int codigoMaterial, int quantidade) {
        System.out.println("\n--- Iniciando Transferência ---");
        System.out.println("De: " + origem.getNomeEstoque() + " Para: " + destino.getNomeEstoque() +
                ", Material (código): " + codigoMaterial + ", Quantidade: " + quantidade);

        Material materialNaOrigem = origem.buscarMaterialPorCodigo(codigoMaterial);

        if (materialNaOrigem == null) {
            System.out.println("Erro: Material com código " + codigoMaterial + " não encontrado em " + origem.getNomeEstoque() + ".");
            return;
        }

        if (materialNaOrigem.getQuantidade() < quantidade) {
            System.out.println("Erro: Quantidade insuficiente de '" + materialNaOrigem.getNome() + "' em " + origem.getNomeEstoque() +
                    ". Disponível: " + materialNaOrigem.getQuantidade() + ", Solicitado: " + quantidade + ".");
            return;
        }

        materialNaOrigem.removerMaterial(quantidade);

        Material materialNoDestino = destino.buscarMaterialPorCodigo(codigoMaterial);

        if (materialNoDestino != null) {
            materialNoDestino.adicionarMaterial(quantidade);
            materialNoDestino.setLocalizacao(new Localizacao(destino.getNomeEstoque()));
        } else {
            Material novoMaterialNoDestino = new Material(
                    materialNaOrigem.getCodigo(),
                    materialNaOrigem.getNome(),
                    quantidade,
                    new Localizacao(destino.getNomeEstoque())
            );
            destino.adicionarMateriais(novoMaterialNoDestino);
        }

        if (materialNaOrigem.getQuantidade() == 0) {
            origem.getMateriais().remove(materialNaOrigem); // Acessa diretamente a lista (poderia ser um método em Estoque)
            System.out.println("Material '" + materialNaOrigem.getNome() + "' esgotado e removido de " + origem.getNomeEstoque() + ".");
        }

        System.out.println("Transferência de " + quantidade + " unidades de '" + materialNaOrigem.getNome() + "' concluída!");
        System.out.println("---------------------------\n");
    }

    public static void main(String[] args) {
        Estoque almoxarifado = new Estoque("Almoxarifado Central");
        Estoque sala1Exame = new Estoque("Estoque Sala 1 de Exames");
        Estoque sala2Exame = new Estoque("Estoque Sala 2 de Exames");

        Material agulha = new Material(10,"Agulha", 100, new Localizacao(almoxarifado.getNomeEstoque()));
        Material algodao = new Material(23,"Algodao", 100, new Localizacao(almoxarifado.getNomeEstoque()));
        Material luvas = new Material(50,"Luvas", 100, new Localizacao(almoxarifado.getNomeEstoque()));
        LocalDate vencimentoLiquido = LocalDate.of(2025,12,10);
        MaterialPerecivel liquidoA = new MaterialPerecivel(101,"Líquido A",25, new Localizacao(almoxarifado.getNomeEstoque()), vencimentoLiquido);

        almoxarifado.adicionarMateriais(agulha);
        almoxarifado.adicionarMateriais(algodao);
        almoxarifado.adicionarMateriais(luvas);
        almoxarifado.adicionarMateriais(liquidoA);

        System.out.println(almoxarifado);
        System.out.println(sala1Exame);
        System.out.println(sala2Exame);

        realizarTransferencia(almoxarifado,sala1Exame,10,20);
        realizarTransferencia(almoxarifado, sala1Exame, 23, 10);

        realizarTransferencia(almoxarifado,sala2Exame,10,30);
        realizarTransferencia(almoxarifado, sala2Exame, 50, 14);
        realizarTransferencia(almoxarifado,sala2Exame, 101, 5);

        System.out.println(almoxarifado);
        System.out.println(sala1Exame);
        System.out.println(sala2Exame);


        realizarTransferencia(sala1Exame,almoxarifado,10,5);

        System.out.println(almoxarifado);
        System.out.println(sala1Exame);
        System.out.println(sala2Exame);

    }
}
