package mx.com.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.servicio.*;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        //si el usuario preciona cero el programa termina
        var opcion = -1;
        var scanner = new Scanner(System.in);
        //comunicamos la capa de presentacion con la capa de datos, logramos bajo acoplamiento
        ICatalogoPeliculas catalogo = new CatalogoPeliculaImpl();
        //al usar la separacion de capas, gracias al ia implemetnacion, no trabajamos con la capa de bajo nivel
        
        
        while(opcion !=0 ){
            System.out.println("Elige una opcion: \n"
                +"1. Iniciar catalogo de peliculas. \n"
                +"2. Agregar pelicula. \n"
                +"3. Listar Pelicula. \n"
                +"4. Buscar pelicula. \n"
                +"0. Salir");
            //capturamos la opcion que selecione el usuario.
            //usamos nextLine para leer la linea, pero hay que hacer una convercion
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogosPeliculas();
                    break;
                case 2:
                    // pedimos el dato al usuario
                    System.out.println("Introduce el nombre de la pelicula");
                    //scaneamos 
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);// el metodo no maneja string, sino que objetos tipo pelicula
                    break;
                case 3:
                    catalogo.listaPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la pelicula a buscar");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;
            }
        }
        
    }
}
