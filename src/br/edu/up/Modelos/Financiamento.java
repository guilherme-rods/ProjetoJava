package br.edu.up.Modelos;

public abstract class Financiamento {

    protected int Categoria;

    public Financiamento(int categoria) {
        Categoria = categoria;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int categoria) {
        Categoria = categoria;
    }

    public abstract int getNumContrato(); 
    
    
    
}