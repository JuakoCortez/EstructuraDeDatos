
package lineales.estaticas;

import utiles.TecladoIn;

public class TestPilaPropio {
    public static void main(String[]args){
        Pila pila1;
        pila1= new Pila();
        int opcionMenu;
        
         do {
            opcionMenu = Menu();

            switch (opcionMenu) {
                case 1:
                    System.out.println("Ingrese elemento a apilar");
                    int elem = TecladoIn.readLineInt();
                    pila1.apilar(elem);
                    break;

                case 2:
                    pila1.desapilar();
                    System.out.println(pila1.toString());
                    break;

                case 3:
                    System.out.println("TOPE: " + pila1.obtenerTope());
                    break;

                case 4:
                    if (pila1.esVacia()) {
                        System.out.println("Es vacía");
                    } else {
                        System.out.println("No es vacía");
                    }
                    break;
                case 5:
                    pila1.vaciar();
                    System.out.println("La pila esta vacía");
                    break;
                case 6:
                    Pila pila2;
                    pila2 = new Pila();

                    pila2 = pila1.clonar();
                    System.out.println("La pila original es: " + pila1.toString());
                    System.out.println("La pila clonada es : " + pila2.toString());
                    break;
                case 7:
                    System.out.println(pila1.toString());
            }

        } while (opcionMenu != 8);

    }

    public static int Menu() {
        int opc;
        do {
            System.out.println("--------------MENU-----------");
            System.out.println("1.Apilar elemento ");
            System.out.println("2.Desapilar elemento");
            System.out.println("3.Obtener tope");
            System.out.println("4.Es vacía");
            System.out.println("5.Vaciar");
            System.out.println("6. Clonar");
            System.out.println("7. ToString");
            System.out.println("8. salir");
            opc = TecladoIn.readLineInt();
        } while (opc < 1 && opc > 7);

        return opc;
        
    }
}
