package br.com.modelo;

public class Localizacao {
    private String local;

    public Localizacao(String local){
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Local : " + local;
    }
}
