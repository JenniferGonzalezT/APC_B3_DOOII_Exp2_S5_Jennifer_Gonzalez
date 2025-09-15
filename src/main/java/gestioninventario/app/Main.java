package gestioninventario.app;

import gestioninventario.modelo.Inventario;
import gestioninventario.modelo.Producto;
import gestioninventario.vista.MenuPrincipal;

/**
 * Desarrollo de aplicación de gestión de inventario en java
 * @author Jennifer
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("¡Bienvenid@ a Gestión de Inventario!");
        Inventario inventario = new Inventario();
        
        System.out.println("Creando unos productos...");
        inventario.agregarProducto(new Producto("TEC031", "Teclado", "Teclado gamer violeta con luces", 92000, 10));
        inventario.agregarProducto(new Producto("TEC032", "Teclado", "Teclado inalámbrico grafito", 39990, 5));
        inventario.agregarProducto(new Producto("MOU017", "Mouse", "Mouse ergonomico negro", 49990, 7));
        
        MenuPrincipal menu = new MenuPrincipal(inventario);
        menu.accionMenu();
    }
}
