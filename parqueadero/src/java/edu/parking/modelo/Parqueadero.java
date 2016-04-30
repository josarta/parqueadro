/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.parking.modelo;

/**
 *
 * @author JoseLuis
 */
public class Parqueadero {
    private int numeroParqueadero;
    private String placa;
    private int horaEntrada;
    private int minEntrtada;
    private int horaSalida;
    private int minSalida;
    private double acumulado;
    private String tipo;

   
    
    
    public int getNumeroParqueadero() {
        return numeroParqueadero;
    }

    public void setNumeroParqueadero(int numeroParqueadero) {
        this.numeroParqueadero = numeroParqueadero;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getMinEntrtada() {
        return minEntrtada;
    }

    public void setMinEntrtada(int minEntrtada) {
        this.minEntrtada = minEntrtada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getMinSalida() {
        return minSalida;
    }

    public void setMinSalida(int minSalida) {
        this.minSalida = minSalida;
    }

    public double getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(double acumulado) {
        this.acumulado = acumulado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
}
