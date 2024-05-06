package service;

import java.util.List;
import java.util.stream.Collectors; // Importa la clase Collectors

import modelo.Pagina;

public class BuscadorService {
    List<Pagina> paginas = List.of(
            new Pagina("www.fnac.es", "libros", "Libros y más cosas"),
            new Pagina("www.casadellibro.es", "libros", "La web se los libro"),
            new Pagina("www.radio.es", "musica", "Música de todo tipo"),
            new Pagina("www.radio.es", "musica", "Música de actualidad"),
            new Pagina("www.gamer.es", "juegos", "Juegos on-line")
    );
    
    public List<Pagina> buscador(String tematica){
        return paginas.stream()
                      .filter(x -> x.getTematica().equals(tematica))
                      .collect(Collectors.toList()); // Utiliza collect junto con Collectors.toList()
    }
}
