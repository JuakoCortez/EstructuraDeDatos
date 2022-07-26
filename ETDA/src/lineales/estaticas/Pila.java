
package lineales.estaticas;
//ALUMNO: CORTEZ JOAQUIN IVAN
//LEGAJO: FAI-2084

public class Pila {
    
    //Atributos
    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 10;
    //constructor
    public Pila(){
        this.arreglo = new Object [TAMANIO];
        this.tope=-1;
    }
    //modificadores
    public boolean apilar(Object nuevoElem){
        
        boolean exito;
        
         if(this.tope>= this.TAMANIO-1){
             //Error: pila llena
             exito=false;}
         else{
             //pone el elemento en el tope de la pila e incrementa el tope
             this.tope++;
             this.arreglo[this.tope]= nuevoElem;
             exito = true;
         }
         return exito;
        
    }
    
    public boolean desapilar(){
        boolean exito = true;
        //desapila sacandole 1 al tope hasta que sea -1 y en ese caso va a dar pila vacia
        if (this.esVacia()) {
            exito = false;
        } else {
            this.tope--;
        }
        return exito;
    }
            //se usa un boolean para devolver true o false dependiendo si la pila esta vacia
            //si esta vacia tope es -1    
    public boolean esVacia(){
        boolean vacia=false;
        if(this.tope==-1){
            vacia=true;
        }
        return vacia;
    }
            
    public Object obtenerTope(){
        Object ultimo;
        if(!this.esVacia()){
            ultimo=this.tope;
        }
        return this.tope;
    }
    
   
    public void vaciar(){
        this.tope=-1;
    }
    
    public Pila clone(){
        Pila pilaClon;
        pilaClon = new Pila();
        pilaClon.arreglo=this.arreglo.clone();
        pilaClon.tope=this.tope;
        return pilaClon;
    }
    
    @Override
    public String toString(){
       int i;
        String cadena = "[";
        for (i = 0; i < tope; i++) {
            if(this.arreglo[i]!=null){
            cadena = cadena + this.arreglo[i] + "|";
            }
        }
        return cadena;
        
    }
    
  
    
  
}
