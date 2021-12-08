package mx.com.gm.peliculas.datos;
//IMPLEMNTAMOS LA INTERFACE IACCESODATOS

import java.io.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {
//implemtacion, pero se usa la notacion de sobreescritura

    @Override
    public boolean existe(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        //aveirguamos si existe el archivo
        return archivo.exists();
    }

    @Override                                               //usamos nuestra propia excepcion
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            //leer lineas
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            //vamos a leer una linea
            linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);//agregamos un objeto del tipo pelicula
                linea = entrada.readLine();
            }
            entrada.close();//cerramos el flujo
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al listar peliculas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al listar peliculas" + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);
        try {

            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());// mandamos a llamar al metodo toString para que imprima el objeto pelicula
            salida.close();
            System.out.println("se ha escrito informacion al archivo: " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("excepcion al escribir peliculas" + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            //indice
            var indice =1;
            //indicamos donde buscamos las peliculas con un indice!
            while (linea != null) {
              if(buscar != null && buscar.equalsIgnoreCase(linea)){
                  resultado= "Pelicula " + linea + " encontrado en el indice" + indice;
                  break;
              } 
              //para que si no la encuentra leea la sifuiente linea
              linea = entrada.readLine();
              //incrementamos el indice
              indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al buscar peliculas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al buscar peliculas" + ex.getMessage());
        }

        return resultado;

    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
             ex.printStackTrace();
            throw new AccesoDatosEx("excepcion al crear peliculas" + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) {
        var archivo = new File(nombreRecurso);
        if(archivo.exists()){
            archivo.delete();
            System.out.println("Se ha borrado el archivo");
        
        }
        
        
    }

}
