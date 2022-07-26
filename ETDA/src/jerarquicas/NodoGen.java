
package jerarquicas;


public class NodoGen {
    private Object tipoElemento;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
public NodoGen(Object tipoElem,NodoGen hijoIzq, NodoGen hermanoDer){
    this.tipoElemento=tipoElem;
    this.hijoIzquierdo=hijoIzq;
    this.hermanoDerecho=hermanoDer;
}
public NodoGen(){
    
}
public Object getElem(){
    return this.tipoElemento;
}
public NodoGen getHijoIzquierdo(){
    return this.hijoIzquierdo;
}
public NodoGen getHermanoDerecho(){
    return this.hermanoDerecho;
}
public void setElem(Object elem){
    this.tipoElemento=elem;
}
public void setHijoIzquierdo(NodoGen hijoIzq){
    this.hijoIzquierdo=hijoIzq;
}
public void setHermanoDerecho(NodoGen hermanoDer){
    this.hermanoDerecho=hermanoDer;
}
}
