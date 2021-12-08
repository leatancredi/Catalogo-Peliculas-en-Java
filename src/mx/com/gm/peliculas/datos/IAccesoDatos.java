package mx.com.gm.peliculas.datos;
// en la interface almacenamos todo los datos para la conexion de datos
// en las interfaces solo definimos el comportamiento

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public interface IAccesoDatos {

    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    //creamos el primer metodo que va a revisar si exsiste la base de datos qu vamnos a utilizar
    // aplicamos la api colecciones  
    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreRecurso, boolean enexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecursos) throws AccesoDatosEx;

}
