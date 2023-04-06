/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahorcado;

/**
 *
 * @author LizzW
 */
public class ahorcado {
    private String[] palabra;
    private int encontradas=0;
    private int intentos;

    public ahorcado() {
    }

    public ahorcado(String[] palabra, int encontradas, int intentos) {
        this.palabra = palabra;
        this.encontradas = encontradas;
        this.intentos = intentos;
    }


    public String getPalabra(int i) {
        return palabra[i];
    }

    /*public void setPalabra(String letra, int i) {
        this.palabra[i] = letra;
    }*/

    public int getEncontradas() {
        return encontradas;
    }

    public void setEncontradas(int encontradas) {
        this.encontradas = encontradas;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public String[] getPalabra() {
        return palabra;
    }

    public void setPalabra(String[] palabra) {
        this.palabra = palabra;
    }
    
    
    
}
