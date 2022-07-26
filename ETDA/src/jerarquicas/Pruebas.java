
package jerarquicas;

import lineales.dinamicas.Lista;


public class Pruebas {
    public static void main (String[]arg){
        Lista l;
     ArbolBin arbol = new ArbolBin();
     NodoArbol a= new NodoArbol(1);
     NodoArbol b= new NodoArbol(2);
     NodoArbol c= new NodoArbol(3);
     NodoArbol d= new NodoArbol(4);
     arbol.insertar(a, b, 'd');
     arbol.insertar(a, c, 'i');
     arbol.insertar(c, d, 'i');
     arbol.insertar(c, 2, 'd');
     arbol.listarPreorden();
     arbol.toString();
     
}
 
  
}
