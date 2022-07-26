
package jerarquicas;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

public class ArbolBin {
    //atributos
    private NodoArbol raiz;
    
    //contructor
    public ArbolBin(){
        this.raiz=null;
    }
    
    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        NodoArbol exito= null;
        if(n!= null){
            if(n.getElemento()==(buscado)){
                //si el buscado es n, lo devuelve
                exito= n;
            }else{
                //no es el buscado: busca primero en el hi
                exito= obtenerNodo(n.getIzquierdo(), buscado);
                //si no lo encuentra, busca en el hijo derecho
                if(exito==null){
                    exito= obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return exito;
    }
    
    public boolean insertar(Object elem,Object padre, char posicion){
       boolean exito=true;
       if(posicion=='D'||posicion=='I'){
       if(raiz==null){//si la iraiz es nula inserta el elemento en la raiz
           this.raiz= new NodoArbol(elem);
       }else{
           NodoArbol nodoPadre = obtenerNodo(this.raiz, padre);//se fija si existe el padre del elemento nuevo
           if(nodoPadre!=null){//en el caso de obtener el padre, nodoPadre tendra el valor que le corresponde
               if(posicion=='I' && nodoPadre.getIzquierdo()==null){//i para izquierda
                   nodoPadre.setIzquierdo(new NodoArbol(elem));//agregamos el hijo en la posicion izquierda
               }else if(posicion=='D'&& nodoPadre.getDerecho()==null){//d para derecha
                   nodoPadre.setDerecho(new NodoArbol(elem));//agregamos el hijo en la posicion derecha
               }
           }else{//si no se encuenta al padre exito es falso
               exito=false;   
           }
       
           
       }}
       return exito;
}
    
    public boolean esVacio(){
        boolean esVacio=false;
        if(this.raiz==null){//si la raiz es vacia devuelve verdadero
            esVacio=true;
        }
        return esVacio;
    }
    
    public Object padre( Object hijo){
        Object esPadre = null;
        NodoArbol padre= padreRecursivo(hijo, this.raiz);
        return esPadre;
    }
    private NodoArbol padreRecursivo(Object hijo, NodoArbol nodo){
        NodoArbol padre= null;
        if(nodo!=null){ //si el nodo no es vacio
            if(nodo.getDerecho()!=null){ //verifica que el hijo derecho contenga un objeto y lo compara con el hijo
                if(nodo.getDerecho()==hijo){
                    padre=nodo;//si el object derecho es igual a hijo, el nodo que venia por parametros es el padre
                }else{// caso contrario se busca en el siquiente hijo de la derecha recursivamente
                    padre= padreRecursivo(hijo,nodo.getDerecho());//primero revisa toda la derecha
                }
            }if(nodo.getIzquierdo()!=null){//ahora realizamos la misma busqueda por la izquierda, visitamos el hijo izquierdo y lo comparamos
                if(nodo.getIzquierdo()==hijo){
                    padre=nodo; //Si la comparacion es exitosa el padre es el que venia por parametros y lo devolvemos
                }  
            }
            if(padre==null){
                padre= padreRecursivo(hijo, nodo.getIzquierdo());  //en el caso que por la derecha no encuantre nada, pasa por los elementos de la izquierda
            }   
        }
        return padre;
    }
    
    public int altura(){
        int altura;
        altura= alturaRecursiva(this.raiz);
        return altura;
    }
    private int alturaRecursiva(NodoArbol n){
        int cont=-1;
        if(n!=null){
            int izq=alturaRecursiva(n.getIzquierdo());
            int der= alturaRecursiva(n.getDerecho());
            cont= Math.max(izq,der)+1;
        }
        
        return cont;
        
    }
    
    public int nivel(Object elem){
        int nivel;
        if(this.raiz!=null){
        nivel= nivelRecursivo(this.raiz, elem)-1;
        }else{
        nivel=-1;}
        return nivel;
    }
    private int nivelRecursivo(NodoArbol n, Object elem){
        int a;
        if(n==null){//caso que el nodo sea nulo, no se encuentra el elemento
            a= -1;
        }else if(n.getElemento()==elem){
            //caso base
            a=0;
        }else{
            a=nivelRecursivo(n.getIzquierdo(), elem);//recorre la izq
            if(a==-1){
                a=nivelRecursivo(n.getDerecho(), elem);//recorre la der
            }
        }
        if(a!=-1){
            a++;
        }
        return a;
    }
    
    public void vaciar(){
      this.raiz=null;
    }
    
    public ArbolBin clone(){
        ArbolBin arbolRec= new ArbolBin();
        if(this.esVacio()!=true){
            arbolRec.raiz= arbolBinRecursivo(this.raiz);
        }
        return arbolRec;
    }
    public NodoArbol arbolBinRecursivo( NodoArbol n){
        NodoArbol aux= new NodoArbol();
        if(n.getIzquierdo()!=null){
            aux.setIzquierdo(n.getIzquierdo());
        }
        if(n.getDerecho()!=null){
            aux.setDerecho(n.getDerecho());
        }
        return aux;    
    }
    
    @Override
    public String toString() {
        String cad;
        if (!this.esVacio()) {
            cad = "raiz: " + this.raiz.getElemento()+ "\n";
            cad += "========================\n";
            cad += stringRecursivo(this.raiz) + "\n";
        } else {
            cad = "Arbol vacío";
        }
        return cad;
    }

    private String stringRecursivo(NodoArbol n) {
        String cadena = "";
        if (n != null) {
            if (n.getIzquierdo() != null) {
                cadena += "Nodo: " + n.getElemento() + " Hijo Izquierdo: " + n.getIzquierdo().getElemento();
            } else {
                cadena += "Nodo: " + n.getElemento()+ " Hijo Izquierdo: vacio";
            }
            if (n.getDerecho() != null) {
                cadena += " Hijo Derecho: " + n.getDerecho().getElemento();
            } else {
                cadena += " Hijo Derecho: vacio ";
            }
            cadena += "\n";
            if (n.getIzquierdo() != null) {
                cadena += stringRecursivo(n.getIzquierdo());
            }
            if (n.getDerecho() != null) {
                cadena += stringRecursivo(n.getDerecho());
            }
        }

        return cadena;
    }
    
    public Lista listarPreorden(){
        Lista lis= new Lista();
            listarPreordenAux(this.raiz, lis);
       return lis;
    }
    private void listarPreordenAux(NodoArbol nodo, Lista lis){
            //privado ya que se usa NodoArbol
            if(nodo!=null){
                //visita al elemento en el nodo
                lis.insertar(nodo.getElemento(),lis.longitud()+1);
                //recorre a sus hijos en preorden
                listarPreordenAux(nodo.getIzquierdo(),lis);
                listarPreordenAux(nodo.getDerecho(),lis);    
            }
        }
     
    public Lista listarInorden(){
        Lista lis= new Lista();
        listarInordenAux(this.raiz,lis);
        return lis;
    }
    private void listarInordenAux(NodoArbol nodo, Lista lis){
        if(nodo!=null){
            listarInordenAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElemento(),lis.longitud()+1);
            listarInordenAux(nodo.getDerecho(), lis);
            
        }
    }
    
    public Lista listarPosorden(){
        Lista lis= new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }
    private void listarPosordenAux(NodoArbol nodo,Lista lis){
        if(nodo!=null){
            listarPosordenAux(nodo.getIzquierdo(), lis);
            listarPosordenAux(nodo.getDerecho(), lis);
            lis.insertar(nodo.getElemento(),lis.longitud()+1);
            
        }
    }
    
    public Lista listarPorNiveles(){
        Lista lis=new Lista();
        if(this.raiz!=null){
           Cola aux= new Cola();
           aux.poner(this.raiz);//primer elemento es la raiz
           NodoArbol nodoNuevo;
           
           while(aux.esVacia()!=true){
               nodoNuevo= (NodoArbol)aux.obtenerFrente();
               aux.sacar();
               lis.insertar(nodoNuevo.getElemento(),lis.longitud()+1);
               if(nodoNuevo.getIzquierdo()!=null){
                   aux.poner(nodoNuevo.getIzquierdo());
               }
               if(nodoNuevo.getDerecho()!=null){
                   aux.poner(nodoNuevo.getDerecho());
               }
           }
           
        }
        return lis;
    }
    public Lista frontera() {
        Lista lista = new Lista();
        System.out.println(lista);
        int pos = 1;
        fronteraRec(this.raiz, lista, pos);

        return lista;
    }

    private void fronteraRec(NodoArbol a, Lista lista2, int pos) {
        if (a != null) {
            if (a.getDerecho() == null && a.getIzquierdo() == null) {
                System.out.println(a.getElemento());
                lista2.insertar(a.getElemento(), pos);
            } else {

                fronteraRec(a.getDerecho(), lista2, pos);
                fronteraRec(a.getIzquierdo(), lista2, pos);
            }
        }
    }

    
    
    
    
    
    
    
    
}
