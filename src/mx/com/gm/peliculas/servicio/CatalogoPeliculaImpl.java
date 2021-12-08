package mx.com.gm.peliculas.servicio;

import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculaImpl  implements ICatalogoPeliculas {
    //implementamos la inteface
    
    private final IAccesoDatos datos;

    public CatalogoPeliculaImpl() {
        this.datos = new AccesoDatosImpl();
        
    }
    
    
    
    
    @Override
    public void agregarPelicula(String nombrePelicula) {
       //convertimos el string a un objeto tipo pelicula
        Pelicula palicula = new Pelicula(nombrePelicula);
        //agregamos una variable para indexar o sobreescribier al achivo
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(palicula, NOMBRE_RECURSO, anexar);
            //no cerramos el flujo, ya que de eso se encarga el metodo.
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso adatos");
            //imprimimos en la consola
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listaPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for(var pelicula: peliculas){
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error en acceso datos");
            //imprimimos en consola
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
       //definimos la variable de resultado
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error acceso datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogosPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de pelicula");
            ex.printStackTrace(System.out);
        }
        
    }
    
    
    
}
