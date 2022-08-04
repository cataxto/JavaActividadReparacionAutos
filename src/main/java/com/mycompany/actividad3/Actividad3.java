/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.actividad3;

import java.util.ArrayList;
import java.util.Scanner;

public class Actividad3 {

    public static void main(String[] args) {
        
        Scanner lector = new Scanner(System.in);
        
        //Punto 1: arrayList de objetos Cliente
        ArrayList<Cliente> arregloClientes = new ArrayList<>();
        String pNombre, pGenero, pPlaca;
        int pMod;
        
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
            System.out.println("Para el cliente "+cli.getNombre()+": ");
            System.out.print("Ingrese placa del primer vehiculo: (/* para salir): ");
            pPlaca=lector.nextLine();
            while(!pPlaca.equals("/*"))
            {
                System.out.print("Modelo: ");
                pMod=
            }
        }
        
        
        //Punto 14: Muestre todos los clientes OJO*********** FALTA!!
        System.out.println("\nLista de todos los clientes\nNombre\tGenero");
        for(Cliente cli:arregloClientes)
        {
            System.out.println(cli.getNombre()+"\t"+cli.getGenero());
        }
        
        //Punto1
        
        
    }
}
