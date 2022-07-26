
package lineales.dinamicas;
//ALUMNO: CORTEZ JOAQUIN IVAN
//LEGAJO: FAI-2084
public class Pila {
    
  private Nodo tope;
  
  public Pila(){
    this.tope=null;
}
  
  public boolean apilar(Object tipoElemento){
      
      //crea un nuevo nodo delante de la antigua cabecera
      Nodo nuevo= new Nodo(tipoElemento,this.tope);
      
      //actualiza el tope para que apunte al nodo nuevo
      this.tope=nuevo;
      
      //nunca hay erro de pila llena, entonces devulve true
      return true;
      
  }
  
  public boolean desapilar(){
      boolean condicion=false;
      
      if(this.tope!=null){
          //busca el enlace anterior del dato actual y a su vez este para a ser el nuevo tope
          this.tope=this.tope.getEnlace();
          condicion=true;
      }
      //en el caso de ser pila vacia condicion=false lo devulve como empezo
       return condicion;
  }
  //devulve el ultimo objeto incresado a la pila
  public Object obtenerTope(){
      return this.tope.getElemento();
  }
  //detecta si la pila es vacia con el tope de dicha pila
  public boolean esVacia(){
      boolean condicion= false;
      if(this.tope==null){
          condicion=true;
      }
          return condicion;
  }
  // asigna null a tope, lo que hace que la pila se vacie
  public void vaciar(){
      this.tope=null;
  }
  
  public Pila clone(){
      //declaro una variable de tipo pila
      Pila pilaclon= new Pila();
      //si el tope es null la pilaclon tambien sera vacia
      if(this.tope==null){
          pilaclon.tope=null;
      }
      else{
          //declaramos variables de tipo nodo para empezar a clonar
          Nodo aux1, aux2;
          aux1=this.tope;
          pilaclon.tope=new Nodo(aux1.getElemento());
          aux2=pilaclon.tope;
          aux1=aux1.getEnlace();
          while(aux1!=null){
              //clona cada nodo y enlace, luego devuelve la pila clonada
              Nodo nodonuevo = new Nodo(aux1.getElemento());
              aux2.setEnlace(nodonuevo);
              aux2 = nodonuevo;
              aux1= aux1.getEnlace();
          }
      }
      return pilaclon;
  }
  
  public String toString() {
        String cad = "";

        if (this.tope == null) {
            cad = "la cadena es vacía";
        } else {
            //creo una variable de tipo nodo y le asigno tope
            cad = "[";
            Nodo aux = this.tope;
            while (aux != null) {
                //luego itera mientras devuelve el elemento de aux, luego aux pasa a tener el enlace(sig elemento) y los almacena en cad hasta que aux es null, luego devuelve todo el array para mostrar por pantalla
                cad += aux.getElemento();
                aux = aux.getEnlace();
                if (aux != null) {
                    cad += ",";
                }

            }
            cad += "]";
        }
        return cad;
    }
  
  }
