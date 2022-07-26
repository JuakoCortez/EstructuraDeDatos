
package lineales.dinamicas;
import lineales.dinamicas.Nodo;

public class Lista {
    
    private Nodo cabecera;
    private int longitud;
 
    public Lista(){
    this.cabecera=null;
    this.longitud=0;
}
    
    public boolean insertar( Object tipoElem, int pos){
        boolean exito=true;
        
      if(pos < 1 || pos > (this.longitud + 1)){
         exito= false; 
      }
      else{
          if(pos==1){
              this.cabecera= new Nodo(tipoElem,this.cabecera);
              }else{
            Nodo aux = this.cabecera;
                int conta=1;
                while(conta<pos-1){
                  aux=aux.getEnlace();
                  conta++;
              }
                Nodo nuevo= new Nodo(tipoElem,aux.getEnlace());
                aux.setEnlace(nuevo);
        }
            longitud++;
      }
           return exito;
            
        }
    //desarrollo de parcial//
    public boolean agregarElemento(Object nuevo, int x){
        boolean exito=false;
        
        
        return exito;
    }
    
    public boolean eliminar(int pos){
        boolean exito= true;
        //caso de posicion invalida
        if(pos<1|| pos > this.longitud|| this.cabecera==null){
            exito=false;
        }else{  //caso eliminar en posicion 1
            if(pos==1){
                this.cabecera=cabecera.getEnlace();
            }else{ //caso general
            Nodo aux=this.cabecera;
            int conta=1;
            while(conta<pos-1){
                aux=aux.getEnlace();
                conta++;
            }
            aux.setEnlace(aux.getEnlace().getEnlace());
        }
            this.longitud--;
        }
        return exito;
    }
    
    public Object recuperar(int pos) {
        int auxPos = 1;
        Object salida = null;
        Nodo aux = null;
        if (pos >= 1 && pos <= this.longitud) {
            aux = this.cabecera;
            while (auxPos < pos) {
                aux = aux.getEnlace();
                auxPos++;
            }

            salida = aux.getElemento();
        }
        return salida;
    }
    
    public int localizar(Object tipoElem){
        Nodo aux;
        int posElem=-1, conta=1;
        boolean exito=false;
        aux= this.cabecera;
        while(aux!=null && exito==false){ //si aux no es nulo y exito sigue falso, sigue buscando, corta cuando encuentra y exito es true o cuando pasa la longitud y aux devuelve null
            if(aux.getElemento().equals(tipoElem)){
                posElem=conta;
                exito=true;
            }
            conta++;
            aux= aux.getEnlace();
        }
        return posElem; //devuelve la primera posicion en la que se encontro el elemento
    }
    
    public int longitud(){
        return this.longitud;
    }
    
    public void vaciar(){
        this.cabecera=null;
    }
     
    public boolean esVacia(){
        boolean esVacia=false;
        if(this.cabecera==null){
          esVacia=true;  
        }return esVacia;
    }
    
    public Lista clone(){
          Lista clone= new Lista();
        if(this.cabecera!=null){
            Nodo aux, aux2;
            Nodo cabe= new Nodo(this.cabecera.getElemento(),null);//nodo que toma elemento de la cabecera y lo copia
            clone.cabecera=cabe;
            aux=this.cabecera;
            aux2=clone.cabecera;
            aux = aux.getEnlace();
            while(aux!=null){
                aux2.setEnlace(new Nodo(aux.getElemento(),null));
                aux=aux.getEnlace();
                aux2=aux2.getEnlace();
            }
              
        }
        return clone;
        
    }
    
    @Override
    public String toString() {
        String mensaje;
        if (this.cabecera == null) {
            mensaje = "ES VACIA";
        } else {
            mensaje = "{";
            Nodo aux = this.cabecera;
            while (aux != null) {
                mensaje += aux.getElemento();
                if (aux.getEnlace() != null) {
                    mensaje += ", ";
                }
                aux = aux.getEnlace();
            }
            mensaje += "}";

        }

        return mensaje;
    }
       
        }
    
