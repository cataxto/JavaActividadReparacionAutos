/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad3;


public class Reparaciones 
{
    private String fecha;
    private String mecanico;
    private double valor;

    //Constructor vacio
    public Reparaciones(){}

    //Constructor con parámetros
    public Reparaciones(String fecha, String mecanico, double valor) 
    {
        this.fecha = fecha;
        this.mecanico = mecanico;
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}
