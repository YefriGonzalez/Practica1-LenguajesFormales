
package practica1lenguajesformales;

/**
 *
 * @author yefri
 */
public class Texto {
    private String palabra;
    private TipoDeTexto tipo;

    public Texto(String palabra, TipoDeTexto tipo) {
        this.palabra = palabra;
        this.tipo = tipo;
    }

    public String getPalabra() {
        return palabra;
    }

    public TipoDeTexto getTipo() {
        return tipo;
    }
    
    
}
