
package jerarquicas;


public class NodoArbol {
    
    //Atributos
    private Object elemento;
    private NodoArbol derecho;
    private NodoArbol izquierdo;
    
    //constructor
    public NodoArbol(Object elem){
        this.elemento=elem;
        this.derecho=null;
        this.izquierdo=null;
    }
    public NodoArbol(){
        this.elemento=null;
        this.derecho=null;
        this.izquierdo=null;
    }

    //observadores
    public Object getElemento(){
        return this.elemento;
    }
    public NodoArbol getDerecho(){
        return this.derecho;
    }
    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }
    
    //modificadores
    public void setElemento(Object elemento){
        this.elemento=elemento;
    }
    public void setDerecho(NodoArbol derecho){
        this.derecho=derecho;
    }
    public void setIzquierdo(NodoArbol izquierdo){
        this.izquierdo=izquierdo;
    }
}
