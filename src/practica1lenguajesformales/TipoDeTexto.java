
package practica1lenguajesformales;

/**
 *
 * @author yefri
 */
public enum TipoDeTexto {
    NUMERO_ENTERO("Numero Entero"),
    NUMERO_DECIMAL("Numero Decimal"),
    ID("Id"),
    CARACTER("Simbolo"),
    ERROR("Error");
    
    private String caracter;
    
    private TipoDeTexto(String caracter){
        this.caracter=caracter;
    }

    public String getCaracter() {
        return caracter;
    }
   
}
