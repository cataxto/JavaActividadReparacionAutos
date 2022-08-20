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
        int pMod, pcant3=0,pcant3Total=0, cant=0, cantH9=0, cantM9=0, cant11=0, opc;
        double pValor,res3=0, maxRep4=0, menor5=100000000000.0, total6=0, valor=0, prom=0,valor12=0, minRep14=100000000000.0;
        
        do 
        {            
            opc=menu();
            switch(opc)
            {
                case 15:
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
                        break;
                case 16:
                        //Agegar vehiculos
                        for(Cliente cli:arregloClientes)
                        {
                            System.out.println("\nPara el cliente "+cli.getNombre()+": ");
                            System.out.print("\nIngrese placa del primer vehiculo: (/* para salir): ");
                            pPlaca=lector.nextLine();
                            while(!pPlaca.equals("/*"))
                            {
                                System.out.print("Modelo(Año): ");
                                pMod=lector.nextInt();
                                System.out.print("Marca: ");
                                lector.nextLine();
                                pMarca=lector.nextLine();
                                cli.agregarVehiculo(pPlaca, pMod, pMarca);
                                System.out.print("Ingrese placa del siguiente vehiculo: (/* para salir): ");
                                pPlaca=lector.nextLine();
                            }
                        }
                        break;
                case 17:
                        //Agregar Reparaciones
                        for(Cliente cli:arregloClientes)
                        {
                            System.out.println("\nPara el cliente "+cli.getNombre()+": ");
                            for(Vehiculo veh:cli.getArregloVehiculos())
                            {
                                System.out.println("\nIngrese reparaciones para la Placa: "+veh.getPlaca()+": ");
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
                        break;
                case 18:
                        //Muestre todos los clientes, vehiculos,reparaciones
                        System.out.println("\nLista de todos los clientes y vehiculos\nNombre\tGenero\tPlaca\tModelo\tMarca\tFecha\t\tMecanico\tValor");
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
                        break;
                case 1:
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
                        break;
                case 2:
                        //Punto2: Listado de clientes a quien les haya reparado vehiculos Luis Figo
                        System.out.println("\nNombre de Cliente");
                        for(Cliente cli:arregloClientes)
                        {
                            if(cli.clienteluisFigo())
                                    System.out.println(cli.getNombre());
                        }
                        break;
                case 3:
                        //Punto 3: Porcentaje de vehiculos Marca Renault Modelo 2012
                        for(Cliente cli:arregloClientes)
                        {
                            pcant3+=cli.esRenault2012();
                            pcant3Total+=cli.totalVehiculos();
                        }
                        res3=(pcant3/pcant3Total)*100;
                        System.out.println("\nEl Porcentaje de vehiculos Marca Renault Modelo 2012 es: "+res3+"%.");
                        break;
                case 4:
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
                        System.out.println("\nMostrar los datos de TODOS los clientes que tiene el mayor valor de reparacion");
                        System.out.println("Nombre\tGenero");
                        for(Cliente cli:arregloClientes)
                        {
                            if(cli.mayorReparacionCliente()==maxRep4)
                            {
                                System.out.println(cli.getNombre()+"\t"+cli.getGenero());
                            }
                        }
                        break;
                case 5:
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
                        break;
                case 6:
                        //Punto6: Total dinero pagado por reparación al mecanico Benito Bueno
                        for(Cliente cli:arregloClientes)
                        {
                            total6+=cli.pagoMecanicoBenitoXCliente();
                        }
                        System.out.println("\nTotal dinero pagado por reparación al mecanico Benito Bueno: "+total6);
                        break;
                case 7:
                        //Punto 7: promedio pagado por reparaciones de todos los clientes
                        for(Cliente cli:arregloClientes)
                        {
                            cant+=cli.totalCantReparacionXCliente();
                            valor+=cli.totalValorReparacionXCliente();
                        }
                        prom=valor/cant;
                        System.out.println("\nPromedio pagado por reparaciones de todos los clientes: "+prom);
                        break;
                case 8:
                        //Punto 8: promedio de pagado por reparaciones de todos loc clientes mujeres con vehiculos marca Hyundai
                        prom=0;valor=0;cant=0;
                        for(Cliente cli:arregloClientes)
                        {
                            if(cli.getGenero().equals("f"))
                            {
                                for(Vehiculo veh: cli.getArregloVehiculos())
                                {
                                    if(veh.getMarca().toLowerCase().equals("hyundai"))
                                    {
                                        valor+=veh.totalValorReparacion();
                                        cant+=veh.totalCantReparacion();
                                    }
                                }
                            }
                        }
                        prom=valor/cant;
                        System.out.println("\nPromedio de pagado por reparaciones de todos los clientes mujeres con vehiculos marca Hyundai: "+prom);
                        break;
                case 9:
                        //Punto 9: Numero de clientes hombres y mujeres
                        for(Cliente cli:arregloClientes)
                        {
                            if(cli.getGenero().equals("f"))
                            {cantM9++;} 
                            else 
                            {cantH9++;}
                        }
                        System.out.println("\nNumero de clientes hombres y mujeres, respectivamente son: "+cantH9+" y "+cantM9);
                        break;
                case 10:
                        //Punto 10: Dado el nombre de un cliente lista la cantidad de vehiculos que ha reparado y el total de dinero pagado por ese concepto
                        System.out.print("\nIngrese nombre del cliente a quien desea saber la cantidad de vehiculos que ha reparado y el total de dinero pagado por ese concepto: ");
                        pNombre=lector.nextLine();
                        valor=0;cant=0;
                        for(Cliente cli:arregloClientes)
                        {
                            if(cli.getNombre().equals(pNombre))
                            {    
                                for(Vehiculo veh:cli.getArregloVehiculos())
                                {
                                    if(!veh.getArregloReparaciones().isEmpty())
                                    {
                                    valor+=veh.totalValorReparacion();
                                    cant++;
                                    }
                                }
                            break;
                            }
                        }
                        System.out.println("Para el cliente: "+pNombre+", ha reparado "+cant+" vehiculos y ha pagado en total por ese concepto $"+valor);
                        break;
                case 11:
                        //Punto11: Cantidad y porcentaje de vehículos reparados cuyo valor es superior a los 4 SMLV
                        cant=0;
                        for(Cliente cli:arregloClientes)
                        {    
                            cant11+=cli.totalVehiculos();
                            for(Vehiculo veh:cli.getArregloVehiculos())
                            {
                                if(veh.totalValorReparacion()>4000000)
                                    {
                                    cant++;
                                }
                            }
                        }
                        System.out.println("\nCantidad y porcentaje de vehículos reparados cuyo valor es superior a los 4 SMLV, respectivamente son: "+cant+" y "+(cant/cant11)*100+"%");
                        break;
                case 12:
                        //Punto 12: Dado la placa de un vehiculo, cambiar el valor de la reparacion por el 15% del valor de sus reparaciones
                        System.out.print("\nIngrese placa del vehiculo al que desea cambiar el valor de la reparacion por el 15% del valor de sus reparaciones: ");
                        pNombre=lector.nextLine();
                        valor=0;
                        for(Cliente cli:arregloClientes)
                        {
                            for(Vehiculo veh:cli.getArregloVehiculos())
                            {
                                if(veh.getPlaca().equals(pNombre))
                                {
                                    valor=veh.totalValorReparacion();
                                    veh.cambioValorRep15();
                                    valor12=veh.totalValorReparacion();
                                    break;
                                }
                            }
                        }
                        System.out.println("\nEl vehiculo con placa "+pNombre+", tenia un valor de repaciones original por: $"+valor+" y ahora es $"+valor12);
                        break;
                case 13:
                        //Punto 13: Dado el nombre de un cliente, muestre el total pagado por todas las reparaciones
                        System.out.print("\nIngrese nombre del cliente a quien desea saber el total pagado por todas las reparaciones: ");
                        pNombre=lector.nextLine();
                        valor=0;
                        for(Cliente cli:arregloClientes)
                        {
                            if(cli.getNombre().equals(pNombre))
                            {
                                valor=cli.totalValorReparacionXCliente();
                                break;
                            }
                        }
                        break;
                case 14:
                        //Punto14: Mostrar todos los datos de los clientes que tiene  el menor valor reparación
                        //Encuentro menor valor de reparacion para todos los clientes
                        for(Cliente cli:arregloClientes)
                        {
                            if(cli.menorReparacionCliente()<minRep14)
                            {
                                minRep14=cli.menorReparacionCliente();
                            }
                        }
                        //Lista de clientes
                        System.out.println("\nMostrar los datos de TODOS los clientes que tiene el menor valor de reparacion");
                        System.out.println("Nombre\tGenero");
                        for(Cliente cli:arregloClientes)
                        {
                            if(cli.menorReparacionCliente()==minRep14)
                            {
                                System.out.println(cli.getNombre()+"\t"+cli.getGenero());
                            }
                        }
                        break;
                case 19:
                        System.out.println("Eligió salir, Hasta luego!!");
                        break;
                default:
                        break;
                    }
                }while(opc!=19);
            }
    
    static int menu()
    {
        int opc;
        Scanner lector = new Scanner(System.in);
        
        System.out.println("\n\t**MENU DE OPCIONES**\n"
                + "15. Ingresar clientes\n" +
                "16. Ingresar vehiculos\n" +
                "17. Ingresar reparaciones\n" +
                "18. Mostrar clientes, vehiculos y reparaciones\n" +
                "1. Listar todos los vehiculos de las mujeres cuyo valor total pagado por las reparaciones sea superior a $350.000\n" +
                "2. Listado de clientes a quien les haya reparado vehiculos el mecánico \"Luis Figo\"\n" +
                "3. Qué porcentaje representan del total los vehículos Marca \"RENAULT\" modelo 2012\n" +
                "4. Mostrar todos los datos del cliente(s) que tiene mayor valor total repación\n" +
                "5. Nombre de la mujer con menor valor pagado por reparación de su auto Modelo \"2010\"\n"+
                "6. Total de dinero pagado por reparación al mecánico \"Benito Bueno\"\n"+
                "7. Promedio pagado por reparaciones de todos los clientes\n"+
                "8. Promedio pagado por reparaciones de todos los clientes mujeres con vehículos con vehiculos marca \"Hyundai\"\n"+
                "9. Cantidad(número) de clientes hombres y cantidad de clientes mujeres\n"+
                "10. Dado el nombre de un cliente liste la cantidad de vehículos y el total de dinero pagado por ese concepto\n"+
                "11. Cantidad y porcentaje de vehículos reparados cuyo valor es superior a los 4 SMLV\n"+
                "12. Dado la placa de un vehículo cambiar el valor de la reparación por el 15% del valor de sus reparaciones\n"+
                "13. Dado el nombre de un cliente, muestre el total pagado por todas las reparaciones\n"+
                "14. Mostrar todos los datos del cliente que tiene menor valor por reparación\n"+
                "19. Salir\n");
        do
        {
            System.out.print("Ingrese opción a consultar: ");
            opc = lector.nextInt();
        }while(opc<1||opc>19);
        return opc;
    }

      
}
