/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.actividad3;

import java.util.ArrayList;
import java.util.Scanner;

public class Actividad3 
{
    public static void main(String[] args) 
    {
        Scanner lector = new Scanner(System.in);
        
        //Punto 1: arrayList de objetos Cliente
        ArrayList<Cliente> arregloClientes = new ArrayList<>();
        String pNombre, pGenero, pPlaca, pMarca, pFecha, pMecanico;
        int pMod, pcant3=0,pcant3Total=0;
        double pValor,res3=0, maxRep4=0, menor5=0;
        
        //Agregar Clientes
        System.out.print("Ingrese nombre del primer cliente (/* para salir): ");
        pNombre=lector.nextLine();
        while(!pNombre.equals("/*"))
        {
            System.out.print("Genero(f/m): ");
            pGenero=lector.nextLine();
            arregloClientes.add(new Cliente(pNombre, pGenero));
            System.out.print("Ingrese nombre del siguiente cliente (/* para salir): ");
            pNombre=lector.nextLine();
        }
        
        //Agegar vehiculos
        for(Cliente cli:arregloClientes)
        {
            System.out.println("\nPara el cliente "+cli.getNombre()+": ");
            System.out.print("Ingrese placa del primer vehiculo: (/* para salir): ");
            pPlaca=lector.nextLine();
            while(!pPlaca.equals("/*"))
            {
                System.out.print("Modelo: ");
                pMod=lector.nextInt();
                System.out.print("Marca: ");
                lector.nextLine();
                pMarca=lector.nextLine();
                cli.agregarVehiculo(pPlaca, pMod, pMarca);
                System.out.print("Ingrese placa del siguiente vehiculo: (/* para salir): ");
                pPlaca=lector.nextLine();
            }
        }
        
        //Agregar Reparaciones
        for(Cliente cli:arregloClientes)
        {
            System.out.println("\nPara el cliente "+cli.getNombre()+": ");
            for(Vehiculo veh:cli.getArregloVehiculos())
            {
                System.out.println("Ingrese reparaciones para la Placa: "+veh.getPlaca()+": ");
                System.out.print("Ingrese fecha de la primera reparacion (/* para salir): ");
                pFecha=lector.nextLine();
                while(!pFecha.equals("/*"))
                {
                    System.out.print("Mecanico: ");
                    pMecanico=lector.nextLine();
                    System.out.print("Valor: ");
                    pValor=lector.nextInt();
                    veh.agregarReparacion(pFecha, pMecanico, pValor);
                    System.out.print("Ingrese fecha de la siguiente reparacion (/* para salir): ");
                    lector.nextLine();
                    pFecha=lector.nextLine();
                }
            }
        }
        
        //Muestre todos los clientes, vehiculos,reparaciones
        System.out.println("\nLista de todos los clientes y vehiculos\nNombre\tGenero\tPlaca\tModelo\tMarca\tFecha\tMecanico\tValor");
        for(Cliente cli:arregloClientes)
        {
            for(Vehiculo veh:cli.getArregloVehiculos())
            {
                for(Reparaciones rep:veh.getArregloReparaciones())
                {
                    System.out.println(cli.getNombre()+"\t"+cli.getGenero()+"\t"+veh.getPlaca()+"\t"+veh.getModelo()
                            +"\t"+veh.getMarca()+"\t"+rep.getFecha()+"\t"+rep.getMecanico()+"\t"+rep.getValor());
                }
            }
        }
        
        //Punto1: Listar todos los veniculos de  las mujeres cuyo valor Reparacion sea superior a $350.000
        System.out.println("\nListar todos los veniculos de  las mujeres cuyo valor de reparacion sea superior a $350.000");
        System.out.println("Nombre\tPlaca\tMarca\tTotal Reparacion");
        for(Cliente cli:arregloClientes)
        {
            if(cli.getGenero().equals("f"))
            {
                for(Vehiculo veh: cli.getArregloVehiculos())
                {
                    if(veh.totalValorReparacion()>350000)
                    {
                        System.out.println(cli.getNombre()+"\t"+veh.getPlaca()+"\t"+veh.getMarca()+"\t"+veh.totalValorReparacion());
                    }
                }
            }
        }
        
        //Punto2: Listado de clientes a quien les haya reparado vehiculos Luis Figo
        System.out.println("\nNombre de Cliente");
        for(Cliente cli:arregloClientes)
        {
            if(cli.clienteluisFigo())
                    System.out.println(cli.getNombre());
        }
        
        //Punto 3: Porcentaje de vehiculos Marca Renault Modelo 2012
        for(Cliente cli:arregloClientes)
        {
            pcant3+=cli.esRenault2012();
            pcant3Total+=cli.totalVehiculos();
        }
        res3=(pcant3/pcant3Total)*100;
        System.out.println("El Porcentaje de vehiculos Marca Renault Modelo 2012 es: "+res3+"%.");
        
        //Punto 4: Mostrar los datos de TODOS los clientes que tiene mayor vlor de reparacion
        //Encuentro mayor valor de reparacion para todos los clientes
        for(Cliente cli:arregloClientes)
        {
            if(cli.mayorReparacionCliente()>maxRep4)
            {
                maxRep4=cli.mayorReparacionCliente();
            }
        }
        //Lista de clientes
        System.out.println("\nMostrar los datos de TODOS los clientes que tiene mayor valor de reparacion");
        System.out.println("Nombre\tGenero");
        for(Cliente cli:arregloClientes)
        {
            if(cli.mayorReparacionCliente()==maxRep4)
            {
                System.out.println(cli.getNombre()+"\t"+cli.getGenero());
            }
        }
        
        //Punto5: Nombre de la mujer con menor valor pagado por reparacion de su auto Modelo 2010
        //Encuentro mayor valor de reparacion para todos los clientes femeninos y modelo 2010
        for(Cliente cli:arregloClientes)
        {
            if(cli.getGenero().equals("f") && cli.menorReparacionCliente2010()<menor5)
            {
                menor5=cli.menorReparacionCliente2010();
            }
        }
        //Lista de clientes
        System.out.println("\nNombre de la mujer con menor valor pagado por reparacion de su auto Modelo 2010");
        System.out.println("Nombre\tGenero");
        for(Cliente cli:arregloClientes)
        {
            if(cli.getGenero().equals("f") && cli.menorReparacionCliente2010()==menor5)
            {
                System.out.println(cli.getNombre()+"\t"+cli.getGenero());
            }
        }
    }    
}
