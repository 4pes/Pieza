package gato;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int filas, columnas;
        int filaPunto, columnaPunto;
        String dim;
        Scanner scan = new Scanner(System.in);

        System.out.println("---------------------------------");
        System.out.println("Bienvenido al creador de planos");
        System.out.println("---------------------------------");
        System.out.println("Regla: todo lo que sea coordenada");
        System.out.println("se debe ingresar separado por una");
        System.out.println("coma EJ: 1,4");
        System.out.println("---------------------------------");
        System.out.print("Ingrese ancho y alto de la pieza: ");

        dim = scan.nextLine();
        System.out.println();

        String[] dimensiones = dim.split(",");
        /*Separación de weas
     
        /*Rescata los valores de la fila y de la columna*/
        filas = Integer.parseInt(dimensiones[0]);
        System.out.println("Filas: " + filas);
        
        columnas = Integer.parseInt(dimensiones[1]);
        System.out.println("Columnas: " + columnas);
        
        //Porcentaje de gatos y ratones
        float maximoGatos = (float) (0.1 * filas * columnas);
        float maximoRaton= (float) (0.25 * filas * columnas);
        
        filas++;
        columnas++;
        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < matriz.length; i++) { //recorrer filas
            for (int j = 0; j < matriz[i].length; j++) { //recorre las columnas      
                if (i == 0) { //fila es la primera
                    //imprimir contador (indice)
                    j--;
                    if (j == -1) {
                        System.out.print("f/c");
                    } else {
                        System.out.print(" " + (j + 1) + " ");
                    }
                    j++;
                } else if (j == 0) {
                    i--;
                    System.out.print(" " + (i + 1) + " ");
                    i++;
                } else {
                    if (i == filas && j == columnas) {
                        System.out.print(" - ");
                    } else {
                        System.out.print(" - ");
                    }
                }
            }
            System.out.println();
        }
        
        System.out.println();

        System.out.println("Usted solo puede agregar "+(int)maximoGatos+" gatos");
        System.out.print("Ingrese posicion del gato: ");

        String puntoGato = scan.nextLine();
        System.out.println();

        String[] coordsPunto = puntoGato.split(",");

        int filaPuntoG = Integer.parseInt(coordsPunto[0]);
        int columnaPuntoG = Integer.parseInt(coordsPunto[1]);

        filaPuntoG++;
        columnaPuntoG++;

        /*imprimir gato*/
        for (int i = 0; i < matriz.length; i++) { //recorrer filas
            for (int j = 0; j < matriz[i].length; j++) { //imprimos las columnas

                if (i == 0) { //fila es la primera
                    //imprimir contador (indice)
                    j--;
                    if (j == -1) {
                        System.out.print("f/c");
                    } else {
                        System.out.print(" " + (j) + " ");
                    }
                    j++;
                } else if (j == 0) {
                    i--;
                    System.out.print(" " + (i) + " ");
                    i++;
                } else {
                    if (i == filaPuntoG && j == columnaPuntoG) {
                        System.out.print(" G ");
                    } else {
                        System.out.print(" - ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();

        boolean error;

        do{
            System.out.println("Usted solo puede agregar "+(int)maximoRaton+" ratones");
            System.out.print("Ingrese posicion del raton: ");

            String puntoRaton = scan.nextLine();
            System.out.println();

            String[] coordsPuntoRaton = puntoRaton.split(",");
            int filaPuntoR, columnaPuntoR;
            filaPuntoR = Integer.parseInt(coordsPuntoRaton[0]);
            columnaPuntoR = Integer.parseInt(coordsPuntoRaton[1]);

            filaPuntoR++;
            columnaPuntoR++;
            error = false;
            
            for (int i = 0; i < matriz.length; i++) { //recorrer filas
                for (int j = 0; j < matriz[i].length; j++) { //imprimos las columnas
                    if (i == 0) { //fila es la primera
                        //imprimir contador (indice)
                        j--;
                        if (j == -1) {
                            System.out.print("f/c");
                        } else {
                            System.out.print(" " + (j) + " ");
                        }
                        j++;
                    } else if (j == 0) {
                        i--;
                        System.out.print(" " + (i) + " ");
                        i++;
                    } else {
                        if (i == filaPuntoG && j == columnaPuntoG) {
                            System.out.print(" G ");
                            error = true;
                        } else if (i == filaPuntoR && j == columnaPuntoR) {
                            System.out.print(" R ");
                            error = false;
                        } else {
                            System.out.print(" - ");
                            error = false;
                        }
                    }
                }
                
                System.out.println();
            }
            
            if (error == false) {
                break;
            } else {
                System.out.println();
                System.out.println("No se puede colocar un Raton sobre un gato");
            }   
            
        } while (error == false);
    }
}
