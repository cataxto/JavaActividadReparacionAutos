/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad3;

import java.util.ArrayList;

public class Cliente 
{
    private String nombre;
    private String genero;
    private ArrayList<Vehiculo> arregloVehiculos;

    //Constructor vacio
    public Cliente() {}

    //Constructor con parametros
    public Cliente(String nombre, String genero) 
    {
        this.nombre = nombre;
        this.genero = genero;
        this.arregloVehiculos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Vehiculo> getArregloVehiculos() {
        return arregloVehiculos;
    }
    
        
    public void agregarVehiculo(String placa, int modelo, String marca)
    {
        arregloVehiculos.add(new Vehiculo(placa, modelo, marca));
    }
    
    //Problema 2.1: Listar todos los vehiculos de las mujeres cuyo 
    //valor pagado por la reparacion sea superior a $350.000
    
    public ArrayList<Vehiculo> mostrarVehiculosMujeres350()
    {
        ArrayList<Vehiculo> arrayVeh = new ArrayList<>();
        if(this.genero.equals("f"))
        {
            for(Vehiculo veh: this.arregloVehiculos)
            {
                if(veh.totalValorReparacion()>350000)
                {arrayVeh.add(veh);}
            }
        }
        return arrayVeh;
    }
    
    //Problema 2.2: Listado de clientes a quien les haya reparado vehiculos el mecanico "Luis Figo"
    public boolean clienteluisFigo()
    {
        
        for(Vehiculo veh: this.arregloVehiculos)
        {
            if(veh.reparoLuisFigo()==true)
            {return true;}
        }
        
        return false;
    }
    
    public int esRenault2012()
    {
        int contEsRenault2012=0;
        for(Vehiculo veh: this.arregloVehiculos)
        {
            if(veh.getMarca().toLowerCase().trim().equals("renault") && veh.getModelo()==2012)
                contEsRenault2012++;
        }
        return contEsRenault2012;
    }
    
    
    public int totalVehiculos()
    {
        return this.arregloVehiculos.size();
    }
    
    public double mayorReparacionCliente()
    {
        double mayorRepCliente=0;
        for(Vehiculo veh: this.arregloVehiculos)
        {
            if(veh.mayorReparacionVeh()>mayorRepCliente)
                mayorRepCliente=veh.mayorReparacionVeh();
        }
        return mayorRepCliente;
    }
    
    public double menorReparacionCliente()
    {
        double menorRepCliente=10000000000000000.0;
        for(Vehiculo veh: this.arregloVehiculos)
        {
            if(veh.menorReparacionVeh()<menorRepCliente)
                menorRepCliente=veh.mayorReparacionVeh();
        }
        return menorRepCliente;
    }
    
    public double menorReparacionCliente2010()
    {
        double menorRepCliente=0;
        for(Vehiculo veh: this.arregloVehiculos)
        {
            if(veh.mayorReparacionVeh()<menorRepCliente && veh.getModelo()==2010)
                menorRepCliente=veh.mayorReparacionVeh();
        }
        return menorRepCliente;
    }
    
    public double pagoMecanicoBenitoXCliente()
    {
        double pagoBenito=0;
        for(Vehiculo veh: this.arregloVehiculos)
        {
            pagoBenito+=veh.totalPagadoBenito();
        }
        return pagoBenito;
    }
    
    public double totalValorReparacionXCliente()
    {
        double totalPagadoCliente=0;
        for(Vehiculo veh: this.arregloVehiculos)
        {
            totalPagadoCliente+=veh.totalValorReparacion();
        }
        return totalPagadoCliente;
    }
    
    
    public int totalCantReparacionXCliente()
    {
        int totalCantRepCliente=0;
        for(Vehiculo veh: this.arregloVehiculos)
        {
            totalCantRepCliente+=veh.totalCantReparacion();
        }
        return totalCantRepCliente;
    }
}