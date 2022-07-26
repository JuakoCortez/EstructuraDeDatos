
package lineales.dinamicas;

public class Cola {
    private Nodo frente;
    private Nodo fin;
    
    public Cola(){
        this.fin = null;
        this.frente = null;
    }
    
    public  boolean esVacia(){
        boolean esVacia=false;
        if(this.frente==null && this.fin==null){
            esVacia=true;
        }
        return esVacia;
    }
    
    public boolean poner(Object nuevoElem){
        boolean exito=true;
        Nodo nuevo = new Nodo(nuevoElem,null); 
        //si ambos son vacio, seteamos ambos con el nuevo elemento//
        if(this.frente == null && this.fin == null){
        frente=nuevo;
        fin=nuevo;}
        //si al menos uno tiene un elemento, asiganamos el nuevo elemento al final y fin crea anlace al nuevo elemnento//
        else{
            this.fin.setEnlace(nuevo);
        }
        //luego de esto, fin pasa a apuntar al nuevo elemento creado//
        this.fin=nuevo;
        return exito;
    }
    
    public boolean sacar(){
        boolean exito=true;
        if(this.frente==null){
            //Error de cola llena//
            exito=false;
        }else{
            this.frente=this.frente.getEnlace();
        }
        if(this.frente==null){
            this.fin=null;
        }
        return exito;
    }
    
    public Object obtenerFrente(){
        return this.frente.getElemento();      
    }
    
    public void vaciar(){
        this.fin=null;
        this.frente=null;
    }
    
    public Cola clone(){
        Cola colaClon= new Cola();
        colaClon.frente=this.frente;
        colaClon.fin=this.frente;
        while(colaClon.fin.getEnlace()!=null){
            colaClon.fin.setElemento(this.fin.getEnlace());
            
        }
        return colaClon;
        }
        
   //ejercicios del tp
    
    public Cola generarOtraCola(Cola c1){
        Pila pilaAux = null;
        Cola c2;
        if(c1.esVacia()!=true){
          Nodo nuevo= new Nodo(c1.frente,null);
         pilaAux.apilar(nuevo.getElemento());
         while(nuevo)
          
        }
    }
    }
    

