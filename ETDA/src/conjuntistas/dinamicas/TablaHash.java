
package conjuntistas.dinamicas;




public class TablaHash {
    private final int TAMANIO = 10;
    private Nodo [] hash;
    private int cant=0;
    
    public TablaHash(){
       this.hash= new Nodo[TAMANIO]; 
       this.cant=0;
}
    public boolean insertar(Object elem){
        //primero verifica si el elemento ya esta cargado
        //si no lo encuentra, lo pone adelante del resto
        int pos= elem.hashCode()% this.TAMANIO;
        Nodo aux = this.hash[pos];
        boolean encontrado=false;
    }
    
    
}
