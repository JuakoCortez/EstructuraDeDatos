
package jerarquicas;

import lineales.dinamicas.Lista;

public class ArbolGen {
    //atributos
    private NodoGen raiz;
    //constructor
public ArbolGen(){
    this.raiz=null;
    }

private NodoGen buscarNodo(NodoGen a, Object bus){
    NodoGen retorna= null;
    NodoGen aux= null;
    if(a!=null){
        if(a.getElem().equals(bus)){
            retorna=a;
        }else{
            aux= a.getHijoIzquierdo();
            while(aux!=null && retorna==null){
                retorna= buscarNodo(aux,bus);
                aux= aux.getHermanoDerecho();
            }
        }
    }
    return retorna;
}

public boolean insertar(Object elemNuevo, Object elemPadre){
    boolean exito=true;
    NodoGen aux3= null;
    NodoGen aux2= new NodoGen();
    aux2.setElem(elemNuevo);
    if(this.raiz==null){
        //observa si la raiz es nula, en el caso de cerla, crea una raiz con el elemento nuevo
        this.raiz=aux2;
    }else{
        //busca recursivamente al padre dado para adjuntarle el elemento como hijo
        NodoGen aux = buscarNodo(this.raiz, elemPadre);
        if(aux==null){
           //si la busqueda da null, no se encontro al padre del elemento 
            exito= false;
        }else if(aux.getHijoIzquierdo()==null){
            //si la busqueda encuentra al padre, verifica que su hijo izquierdo es nulo para setear el elemento nuevo como hizo izquierdo
            aux.setHijoIzquierdo(aux2);
        }else{
            //en el caso de encontrar el elemento pero que este tenga un hijo izquierdo usamos una nuevo nodo auxiliar al que le seteamos el valor del 
            //hijo izquierdo y luego a travez de un while buscamos hasta que encontremos un hijo derecho nulo
            aux3=aux.getHijoIzquierdo();
            while(aux3.getHermanoDerecho()!=null&& exito!=false){
                if(aux3.equals(aux2)){
                    //caso de que el elemento a incorporar sea igual a un hijo, no inserta y devuelve false
                    exito= false;
                }//se le da como valor a aux3 el hermano derecho siguiente
                aux3=aux3.getHermanoDerecho();
            }
            if(exito){
                //setea el nuevo elemento como hermano derecho
                aux.setHermanoDerecho(aux2);
           
            }
        }
    }return exito;
}  

public boolean pertenece(Object elem){
    //verifica a travez del metodo buscarNodo con los elementos diferentes a nulo, de encontrarlo asigana true, contrario false
    boolean aux;
    aux=(buscarNodo(this.raiz, elem)!=null);
    return aux;
}
  /*boolean exito=false;
    NodoGen aux;
    aux=buscarNodo(this.raiz, elem);
    if(aux!=null){
        exito=true;
    }
    return exito;
}*/
public Lista ancestros(Object elem){
    Lista lista= new Lista();
    if(this.raiz!=null){
        ancestrosRecursivos(this.raiz,lista,elem);
    }
    return lista;
}

private boolean ancestrosRecursivos(NodoGen r, Lista ls, Object b){
    boolean exito= false;
    NodoGen aux=null;
    if(r!=null){
        //si el nodo no es nulo verifica que su elemento es igual al buscado, en el caso que si lo inserta en la lista 
    if(r.getElem().equals(b)){
        ls.insertar(r.getElem(), 1);
        exito=true;
    }else{ 
        aux=r.getHijoIzquierdo();
        while(aux!=null && !exito){
            exito= ancestrosRecursivos(aux, ls, b);
            aux=  aux.getHermanoDerecho();
        }
        if(exito){
            ls.insertar(r.getElem(), 1);
        }
        
    }
}
    return exito; 
}

public boolean esVacio(){
    boolean esVacio=true;
    if(this.raiz!=null){
        esVacio=false;
    }
    return esVacio;
}

public int altura(){
    int altura=-1;
    if(!this.esVacio()){
        altura=alturaRecursiva(this.raiz,0);
    }
    return altura;
}

private int alturaRecursiva(NodoGen nodo, int a){
    int alturaHermanoDerecho=0;
    int alturaMax=-1;
    if(nodo!=null){
        if(nodo.getHijoIzquierdo()==null){
            //no tiene mas hijos, es una hoja
            a=0;
    }else{
            a=alturaRecursiva(nodo.getHijoIzquierdo(), a+1)+1;
        }
        //recorrido de los hermanos derechos
    NodoGen hermanoDerecho=  nodo.getHermanoDerecho();
      while(hermanoDerecho!=null){
          alturaRecursiva(hermanoDerecho,a);
          hermanoDerecho= hermanoDerecho.getHermanoDerecho();
      }
      if(alturaHermanoDerecho>a){
         a= alturaHermanoDerecho;
      }
      if(a>alturaMax){
          alturaMax=a;
      }
    }
    return alturaMax;
}

public int nivel(Object elem){
    int n=-1;
    if(this.raiz!= null){
        nivelRecursivo(this.raiz,elem,0);
    }
    return n;
}

private int nivelRecursivo(NodoGen nodo,Object elem, int niv){
    int nivel=-1;
    NodoGen aux=null;
    if(nodo!=null){
        if(nodo.getElem().equals(elem)){
            nivel=niv;
        }else{
            aux=nodo.getHijoIzquierdo();
            while(aux!=null && nivel==-1){
                nivel= nivelRecursivo(aux, elem, niv+1);
                aux=aux.getHermanoDerecho();
            }
        }
    }
    return nivel;
}

public Object padre(Object elem){
    Object padre=null;
    if(!esVacio()){
        if(!this.raiz.getElem().equals(elem)){
             padre=padreRecursivo(this.raiz,elem);
        }
    }
    return padre;
}

private Object padreRecursivo(NodoGen n,Object elem){
    Object padreEncontrado=null;
    NodoGen aux = null;
    if(n!=null){
        aux=n.getHijoIzquierdo();
        //a aux le asigno el hijo izquierdo y mientras el hijo izquierdo no sea nulo y tampoco su elemento sea el buscado va a revisar los hermanos derechos
        while(n!=null&&!n.getElem().equals(elem)){
            aux=aux.getHermanoDerecho();
        }//una vez encontrado el elemento o que el nodo a revisar sea null sale del bucle while
        if(aux!=null){
            padreEncontrado= aux.getElem();//si no es null la opcion correcta es que sea el elemento buscado
        }else{
           padreEncontrado =padreRecursivo(n.getHijoIzquierdo(), elem);
           if(padreEncontrado==null){
               padreEncontrado=padreRecursivo(n.getHermanoDerecho(), elem);
           }
    }
    }
    return padreEncontrado;
}

public Lista listarPreorden(){
    Lista salida= new Lista();
    listarPreordenRecursivo(this.raiz,salida);
    return salida;
}
private void listarPreordenRecursivo(NodoGen n, Lista ls){
    if(n!=null){
        
    }
}
public boolean verificarCamino(Lista unaLista){
    int pos=0;
    boolean exito= false;
    if(this.raiz!=null){
        exito= verificarCaminoAux(this.raiz,unaLista, pos);
    }
    return exito;
}
private boolean verificarCaminoAux(NodoGen n, Lista unaLs, int pos){
    boolean exito=false;
    Object aux=null;
    NodoGen hijo= new NodoGen();
    aux=unaLs.recuperar(pos);
    if(n!=null){
        if(n.getElem().equals(aux)){
          hijo=n.getHijoIzquierdo();
          exito=verificarCaminoAux(hijo, unaLs, pos+1);
        }else{
            hijo=n.getHijoIzquierdo();
        while(hijo.equals(aux)==false ||hijo!=null){
            exito=verificarCaminoAux(hijo, unaLs, pos);
            hijo=hijo.getHermanoDerecho();
        }
        }
        if(unaLs.longitud()<=pos){
            exito=true;
        }
    }
    return exito;
}

}
