package lineales.estaticas;

//cola estatitca//
public class Cola {
    //ATRIBUTOS//
    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO=10;
    
    //CONSTRUCTORES//
    public Cola(){
        this.arreglo= new Object[TAMANIO];
        this.fin=0;
        this.frente=0;
    }
    
    //METODOS//
    public boolean sacar(){
        boolean exito= true;
        if(this.esVacia()){
            exito=false;
        }else{
            this.arreglo[this.frente]=null;
            this.frente=(this.frente+1)%this.TAMANIO;
        }
        return exito;
            
    }
    
    public boolean esVacia(){
        boolean exito=false;
        //fila llena si frente es igual a fin
        if(this.frente==this.fin){
            exito=true;
        }
        return exito;
    }
    
    public boolean poner(Object nuevoElem){
       boolean exito= true;
       //cola llena//
       if((this.fin+1==this.frente)||(this.fin==TAMANIO-1)&&(this.frente==0)){
           exito=false;
       }
       else{
           //agrega una elemento al arreglo y despues usa mod para setear el proximo lugar a ocupar//
           this.arreglo[fin]=nuevoElem;
           this.fin=(this.fin+1)%TAMANIO;
           exito = true;
       }
      return exito;
    }
    
    public Object obtenerFrente(){
        Object retorno;
        if(this.fin!=this.frente){
            retorno=this.arreglo[frente];
        }
        else{
            retorno=-1;
        }
        return retorno;   
    }
    
    public void vaciar(){
        this.frente=0;
        this.fin=0;
    }
    
    public Cola clone(){
        int i=0;
        Cola colaClone = new Cola();
        colaClone.arreglo = this.arreglo;
        colaClone.fin = this.frente;
        colaClone.frente = this.frente;
        if(i<TAMANIO){
            colaClone.arreglo[fin]= this.arreglo[i];
            i++;
            colaClone.fin++;
        }
        
        
        return colaClone;
    }
    
    public String toString(){
        String cadena="";
        int i=0;
        if(this.frente<this.fin){
          i = frente;
          while(i<this.fin){
              cadena= cadena+arreglo[i];
              i++;
          }}
          else{
              i=frente;
              while(i<TAMANIO-1){
                  cadena= cadena+arreglo[i];
                  i++;
              }        
                i=0;
             while(i<fin){
                 cadena= cadena+arreglo[i];
                  i++;
             }
                  }
        return cadena;
    }
    }
    
    

