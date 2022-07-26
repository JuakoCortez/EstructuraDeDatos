
package conjuntistas.dinamicas;


    public class NodoABB {
    private Comparable elem;
    private NodoABB izquierdo;
    private NodoABB derecho;
    
   public NodoABB(Comparable elem, NodoABB izquierdo, NodoABB derecho){
       this.elem = elem;
       this.derecho = derecho;
       this.izquierdo = izquierdo;
}
   public Comparable getElem(){
       return elem;
   }
   public void setElem(Comparable elem){
       this.elem= elem;
   }
   public NodoABB getIzquierdo(){
       return izquierdo;
   }
   public void setIzquierdo(NodoABB izquierdo){
       this.izquierdo=izquierdo;
   }
   public NodoABB getDerecho(){
       return this.derecho;
   }
   public void setDerecho(NodoABB derecho){
       this.derecho=derecho;
   }  
}

