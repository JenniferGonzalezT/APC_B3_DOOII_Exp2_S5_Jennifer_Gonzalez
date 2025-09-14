package gestioninventario.util;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatoMoneda {
    private static final Locale LOCALE_CL = Locale.forLanguageTag("es-CL");
    private static final NumberFormat CLP = NumberFormat.getCurrencyInstance(LOCALE_CL);
    
    private FormatoMoneda() {}
    
    // Formato de pesos chilenos
    public static String CLP(double valor) {
        return CLP.format(valor);
    }
}
