/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad3;

import java.util.ArrayList;



public class Vehiculo implements Seguros
{
    private String placa;
    private int modelo;
    private String marca;
    private ArrayList<Reparaciones> arregloReparaciones;

    //Constructor vacio
    public Vehiculo() {}

    //constructor con parametros
    public Vehiculo(String placa, int modelo, String marca) 
    {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.arregloReparaciones = new ArrayList<>();
        
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public ArrayList<Reparaciones> getArregloReparaciones() {
        return arregloReparaciones;
    }
 
    public void agregarReparacion(String fecha, String mecanico, double valor)
    {
        arregloReparaciones.add(new Reparaciones(fecha,mecanico,valor));
    }
    
    public double totalValorReparacion()
    {
        double valorTotalRep=0;
        for (Reparaciones rep : this.arregloReparaciones) {
            valorTotalRep+=rep.getValor();
        }
        return valorTotalRep;
    }
    
    public int totalCantReparacion()
    {
        return this.arregloReparaciones.size();
    }
    
    public boolean reparoLuisFigo()
    {
        boolean reparoLuisF=false;
        for (Reparaciones rep : this.arregloReparaciones) {
            if(rep.getMecanico().equals("Luis Figo"))
            {
                reparoLuisF=true;
                break;
            }
        }
        return reparoLuisF;
    }
    
    public double mayorReparacionVeh()
    {
        double mayorRep=0;
        for (Reparaciones rep : this.arregloReparaciones) 
        {
            if(rep.getValor()>mayorRep)
            {
                mayorRep=rep.getValor();
            }
        }
        return mayorRep; 
    }
    
    public double menorReparacionVeh()
    {
        double menorRep=0;
        for (Reparaciones rep : this.arregloReparaciones) 
        {
            if(rep.getValor()<menorRep)
            {
                menorRep=rep.getValor();
            }
        }
        return menorRep; 
    }
    
    public double totalPagadoBenito()
    {
        double totalPagadoBenito=0;
        for (Reparaciones rep : this.arregloReparaciones) 
        {
            if(rep.getMecanico().equals("Benito Bueno"))
                totalPagadoBenito+=rep.getValor();
        }
        return totalPagadoBenito;
    }
    
    public void cambioValorRep15()
    {
        for (Reparaciones rep : this.arregloReparaciones) 
        {rep.setValor(rep.getValor()*0.15);}
    }

    @Override
    public double mostrarPoliza() {
        return 10000;
    }
}
