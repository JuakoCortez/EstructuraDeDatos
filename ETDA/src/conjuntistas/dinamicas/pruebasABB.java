
package conjuntistas.dinamicas;

/**
 *
 * @author Joaqu
 */
public class pruebasABB {
    public static void main (String []args){
        ArbolBB arbol= new ArbolBB();
        arbol.insertar(15);
        arbol.insertar(9);
        arbol.insertar(6);
        arbol.insertar(13);
        arbol.insertar(17);
        arbol.insertar(16);
        arbol.insertar(18);
        
        System.out.println(arbol.toString());
        System.out.println(arbol.listar());
        //System.out.println(arbol.listarRango(9, 16));
        //System.out.println(arbol.maximoElem());
        //System.out.println(arbol.minimoElem());
    }
}
