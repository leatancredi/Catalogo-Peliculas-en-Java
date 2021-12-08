package mx.com.gm.peliculas.excepciones;

//siempre extender de la clase padre exceptions
public class AccesoDatosEx extends Exception {
   public AccesoDatosEx(String mensaje){
       super(mensaje);
   } 
}

