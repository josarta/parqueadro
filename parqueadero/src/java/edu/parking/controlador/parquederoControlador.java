/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.parking.controlador;

import edu.parking.modelo.Parqueadero;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author JoseLuis
 */
@Named(value = "parquederoControlador")
@SessionScoped
public class parquederoControlador implements Serializable {

    private int valorMinMoto = 57;
    private int valorMinAuto = 70;
    private int valorMinBici = 30;
    private int tarifaCompletaMoto = 5000;
    private int tarifaCompletaAuto = 12000;
    private int tarifaCompletaBici = 3000;
    private int valorMinuto;
    private ArrayList<Parqueadero> miParqueadero = new ArrayList<>();
    private Parqueadero parquederoActual;

    private int numeroFactura;
    private Double valorapagar;

    private Double totalMinutos;

    /**
     * Creates a new instance of parquederoControlador
     */
    public parquederoControlador() {
        for (int i = 0; i < 10; i++) {
            Parqueadero objp = new Parqueadero();
            objp.setNumeroParqueadero(i + 1);
            objp.setPlaca("");
            miParqueadero.add(objp);
        }
        valorMinuto = 70;
        valorapagar = 0.0;
    }

    public int getValorMinMoto() {
        return valorMinMoto;
    }

    public void setValorMinMoto(int valorMinMoto) {
        this.valorMinMoto = valorMinMoto;
    }

    public int getValorMinAuto() {
        return valorMinAuto;
    }

    public void setValorMinAuto(int valorMinAuto) {
        this.valorMinAuto = valorMinAuto;
    }

    public int getValorMinBici() {
        return valorMinBici;
    }

    public void setValorMinBici(int valorMinBici) {
        this.valorMinBici = valorMinBici;
    }

    public int getTarifaCompletaMoto() {
        return tarifaCompletaMoto;
    }

    public void setTarifaCompletaMoto(int tarifaCompletaMoto) {
        this.tarifaCompletaMoto = tarifaCompletaMoto;
    }

    public int getTarifaCompletaAuto() {
        return tarifaCompletaAuto;
    }

    public void setTarifaCompletaAuto(int tarifaCompletaAuto) {
        this.tarifaCompletaAuto = tarifaCompletaAuto;
    }

    public int getTarifaCompletaBici() {
        return tarifaCompletaBici;
    }

    public void setTarifaCompletaBici(int tarifaCompletaBici) {
        this.tarifaCompletaBici = tarifaCompletaBici;
    }

    public ArrayList<Parqueadero> getMiParqueadero() {
        return miParqueadero;
    }

    public void setMiParqueadero(ArrayList<Parqueadero> miParqueadero) {
        this.miParqueadero = miParqueadero;
    }

    public String colocar(int temp) {
        temp -= 1;
        parquederoActual = miParqueadero.get(temp);
        return "detalle.xhtml";
    }

    public Parqueadero getParquederoActual() {
        return parquederoActual;
    }

    public void setParquederoActual(Parqueadero parquederoActual) {
        this.parquederoActual = parquederoActual;
    }

    public String calcular() {

        return "index";

    }

    public String factura() {
        numeroFactura++;
        int iniHora = this.parquederoActual.getHoraEntrada();
        int iniMin = this.parquederoActual.getMinEntrtada();
        int outHora = this.parquederoActual.getHoraSalida();
        int outMin = this.parquederoActual.getMinSalida();
        totalMinutos = 0.0;

        for (int j = iniHora; j <= 24; j++) {

            for (int i = iniMin; i <= 59; i++) {

                if (i == outMin) {
                    if (iniHora == outHora) {
                        break;
                    } else {
                        iniMin = 0;

                    }
                }
                totalMinutos++;
            }

            if (iniHora == outHora) {
                break;
            }
            iniHora++;
        }
        
        valorapagar= valorMinuto*totalMinutos;
        parquederoActual.setAcumulado( parquederoActual.getAcumulado()+valorapagar );
       
        
        return "factura";
    }
    
    
    public String borrarObjeto(){
       parquederoActual.setPlaca("");
        parquederoActual.setTipo("Automovil");
        parquederoActual.setHoraEntrada(0);
        parquederoActual.setMinEntrtada(0);
        parquederoActual.setMinEntrtada(0);
        parquederoActual.setMinSalida(0);
        valorapagar = 0.0;
    return "index";
    }

    public String actualizaValor() {
        try {

            switch (parquederoActual.getTipo()) {
                case "Moto":
                    valorMinuto = valorMinMoto;
                    break;
                case "Automovil":
                    valorMinuto = valorMinAuto;
                    break;
                default:
                    valorMinuto = valorMinBici;
                    break;
            }

        } catch (Exception e) {
        }
        return "" + valorMinuto;
    }

    public int getValorMinuto() {
        return valorMinuto;
    }

    public void setValorMinuto(int valorMinuto) {
        this.valorMinuto = valorMinuto;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Double getValorapagar() {
        return valorapagar;
    }

    public void setValorapagar(Double valorapagar) {
        this.valorapagar = valorapagar;
    }

    public double getTotalMinutos() {
        return totalMinutos;
    }

    public void setTotalMinutos(double totalMinutos) {
        this.totalMinutos = totalMinutos;
    }

}
