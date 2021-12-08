package mx.com.gm.peliculas.servicio;
//es nuesta capa de servicion o logica de negocio
public interface ICatalogoPeliculas {
    
    String NOMBRE_RECURSO = "peliculas.txt";
    
    
    
    void agregarPelicula(String nombrePelicula);
    
    void listaPeliculas();
    
    void buscarPelicula(String buscar);
    
    void iniciarCatalogosPeliculas();
}
