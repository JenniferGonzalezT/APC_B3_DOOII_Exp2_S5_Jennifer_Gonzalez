package gestioninventario.app;

import gestioninventario.vista.MenuPrincipal;

/**
 * Desarrollo de aplicación de gestión de inventario en java
 * @author Jennifer
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("¡Bienvenid@ a Gestión de Inventario!");
        
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenu();
        menu.opcionMenu();
        menu.accionMenu();
    }
}
