
package conjuntistas.dinamicas;

public class Nodo {
    private Object elem;
    private Object enlace;
    
    public Nodo(){
        elem=null;
        enlace=null;
    }
    public Object getElem(){
        return this.elem;
    }
    public Object getEnlace(){
        return this.enlace;
    }
    public void setElem(Object n){
        this.elem=n;
    }
    public void setEnlace(Object n){
        this.enlace=n;
    }
}
