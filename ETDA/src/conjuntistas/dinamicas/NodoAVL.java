
package conjuntistas.dinamicas;


public class NodoAVL {
    private Comparable elemento;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    
    public NodoAVL(Comparable elem){
        this.elemento=elem;
        
    }
    public NodoAVL(Comparable elem, NodoAVL der, NodoAVL izq){
        this.elemento= elem;
        this.derecho= der;
        this.izquierdo= izq;
    }
    public Comparable getElem(){
        return elemento;
    }
    public void setElem(Comparable elem){
        this.elemento= elem;
    }
    public int getAltura(){
        return altura;
    }
    public void setAltura(int alt){
        this.altura= alt;
    }
    public void recalcularAltura(){
        //la altura de un nodo siempre es -1
        int alturaHI = -1, alturaHD= -1;
        //si mi hijoIzq no es nulo
        if(this.izquierdo!=null){
            alturaHI= this.izquierdo.getAltura();
        }//si HD no es nulo
        if(this.derecho!= null){
            alturaHD= this.derecho.getAltura();
        }
        if(alturaHI>=alturaHD){
            //sumo 1 porque cuento el nivel del padre ( altura padre = alturaMaxHijo +1)
            this.altura=alturaHI + 1;
        }else{
            this.altura= alturaHD + 1;
        }
        
    }
    
    public NodoAVL getIzquierdo(){
        return izquierdo;
    }
    public void setIzquierdo(NodoAVL izq){
        this.izquierdo= izq;
        if(izq!=null){
            izq.recalcularAltura();
        }
        this.recalcularAltura();
    }
    public NodoAVL getDerecho(){
        return derecho;
    }
    public void setDerecho(NodoAVL der){
        this.derecho= der;
        if(der!= null){
            der.recalcularAltura();
        }
        this.recalcularAltura();
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
