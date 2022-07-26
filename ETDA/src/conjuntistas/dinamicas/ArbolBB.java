
package conjuntistas.dinamicas;


import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Nodo;

public class ArbolBB {
    private NodoABB raiz;

    public ArbolBB(){
        this.raiz=null;
    }
    
    public boolean pertenece(Comparable elem){
        boolean existe= false;
        if(this.raiz!=null){
         existe= perteneceAux(this.raiz,elem);
        }
        return existe;
    }
    private boolean perteneceAux(NodoABB nodo, Comparable elem){
        boolean existe= false;
        if(nodo!=null){//si el nodo no es nulo
            Comparable elemNodo= nodo.getElem();//guardo el valor del nodo para comparar
            
            if(elemNodo.compareTo(elem)==0){//comparamos el valor con el que tambien tenemos por parametros, si es 0 la comparacion, encontramos el nodo
                existe=true;
            }else if(elemNodo.compareTo(elem)<0){// si el elemento del nodo es menor que el elemento buscado, recorremos el arbol de la izquierda
                existe=perteneceAux(nodo.getIzquierdo(),elem);
            }else{
                existe=perteneceAux(nodo.getDerecho(),elem);// si el elemento del nodo es mayor que el elemento buscado, recorremos el arbol de la derecha
            } 
        }
        return existe;
        
}
    
    public boolean insertar(Comparable elem){
        boolean exito=false;
        if(!pertenece(elem)){
          if(this.raiz!=null){//si la raiz no es nula empieza a comparar con recursion
          exito=insertarAux(this.raiz,elem);
        }else//si la raiz es nula, pone el nuevo elemento como raiz
              this.raiz= new NodoABB(elem,null,null);}
             //this.raiz.setElem(elem);        
        return exito;
    }
    private boolean insertarAux(NodoABB nodo, Comparable elem){
        boolean exito= true;
        Comparable elemNodo= nodo.getElem();
        if(elem.compareTo(elemNodo)<0){
            if(nodo.getIzquierdo()!=null){
                exito= insertarAux(nodo.getIzquierdo(), elem);
            }else{
                nodo.setIzquierdo(new NodoABB(elem,null,null));
            }
        }else{
            if(nodo.getDerecho()!=null){
                exito= insertarAux(nodo.getDerecho(), elem);
            }else{
                nodo.setDerecho(new NodoABB(elem,null,null));
            }
        }
        return exito;
    }
    
    public boolean eliminar(Comparable elem){
        boolean exito= false;
        if(this.raiz!=null){
            exito=eliminarAux(this.raiz, null ,elem);
        }
        return exito;
    }
    private boolean eliminarAux(NodoABB nodo,NodoABB padre ,Comparable elem){
        boolean exito=false;
        if(nodo!=null){
            if(nodo.getElem().compareTo(elem)<0){//si el elem del nodo es mas chico que el nodo a incertar pasa a su rama izquierda
                exito= eliminarAux(nodo.getIzquierdo() , nodo , elem);
            }else if(nodo.getElem().compareTo(elem)>0){//si el elem del nodo es mas grande que el nodo a incertar pasa a su rama derecha
                exito= eliminarAux(nodo.getDerecho() , nodo , elem);
        }else{//es igual el elemento del nodo a el buscado, ahora tenemos que eliminar ese elemento dependiendo de su caso
                //CASO 1
                if(nodo.getDerecho()==null&&nodo.getIzquierdo()==null){//no tiene hijos
                    eliminarCaso1(padre,elem);
                    //CASO 2
                }else if((nodo.getDerecho()!=null&&nodo.getIzquierdo()==null)||(nodo.getDerecho()==null && nodo.getIzquierdo()!=null)){//tiene al menos un hijo
                    eliminarCaso2(padre,nodo,elem);
                }else{//CASO 3 ambos hijos existen
                    eliminarCaso3(nodo);
                }
                    
            }
        }
        return exito;
    }
    private void eliminarCaso1( NodoABB padre, Comparable elem){//caso 1: es una hoja y solo se la elimina y listo
        if(padre.getDerecho()!=null){
       if(padre.getDerecho().getElem().compareTo(elem)==0){//elimnamos si estaba en el derecho y si no pasamos al izquiero y eliminamos
           padre.setDerecho(null);
       }
        }else if(padre.getIzquierdo()!=null){
            if(padre.getIzquierdo().getElem().compareTo(elem)==0){
                padre.setIzquierdo(null);
            }
        } 
    }  //preguntar si en vez de esta opcion podiamos pasar el nodo y setear en null su elemento y listo
    private void eliminarCaso2(NodoABB padre, NodoABB nodo, Comparable elem){
        if(padre.getElem().compareTo(nodo.getElem())>0){//buscamos que hijo es, si izquierdo o derecho,caso que devuelva mas de 1 es hijo izquierdo
            if(nodo.getDerecho()!=null){
                padre.setIzquierdo(nodo.getDerecho());
            }else{
                padre.setIzquierdo(nodo.getIzquierdo());
            }
        }else{//es hijo derecho
             if(nodo.getDerecho()!=null){
                padre.setDerecho(nodo.getDerecho());
            }else{
                padre.setDerecho(nodo.getIzquierdo());
            }
            
        }
    }
    private void eliminarCaso3(NodoABB nodo){
        //siempre tendremos 2 candidatos 
        NodoABB candidato1= nodo.getIzquierdo();
        NodoABB padreCandidato=nodo;//variable para usar en el caso de eliminarCaso2
        while(candidato1.getDerecho()!=null){//se mueve a la izquierda y despues todo por la derecha
            candidato1=candidato1.getDerecho();
        }
        nodo.setElem(candidato1.getElem());//ponemos el valor del candidato en el nodo, asi eliminamos su valor
        //se elimina el candidato del que se saco el elem
        if((candidato1.getDerecho()==null)&&(candidato1.getIzquierdo()==null)){//es una hoja a borrar
            eliminarCaso1(candidato1, candidato1.getElem());//pasamos el candidato y tambien su elemento asi lo borra
        }else{//tiene un hijo
            eliminarCaso2(padreCandidato, candidato1, candidato1.getElem());
        }
    }
    
    public Lista listar(){
        Lista ls= new Lista();
        if(!esVacio()){
            listarAux(ls,this.raiz);
        }
        return ls;    
    }
    public void listarAux(Lista ls, NodoABB nodo){
        if(nodo!=null){
            NodoABB izquierdo= nodo.getIzquierdo();
            NodoABB derecho= nodo.getDerecho();
            
            listarAux(ls,izquierdo);
            ls.insertar(nodo.getElem(),ls.longitud()+1);
            
            listarAux(ls,derecho);
        }
        
        
    }
    
    public boolean esVacio(){
        return this.raiz==null;
        
    }
    
    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo){
        Lista ls = new Lista();
        if(!esVacio()){
            listarRangoAux(elemMinimo,elemMaximo,ls,this.raiz);
        }
        return ls;
    }
    private void listarRangoAux(Comparable min, Comparable max, Lista ls, NodoABB nodo){
        if(nodo!=null){
            Comparable elemNodo= nodo.getElem();
            if(elemNodo.compareTo(max)<0){
                listarRangoAux(min, max, ls, nodo.getDerecho());
            }
            if(elemNodo.compareTo(min)>=0 && elemNodo.compareTo(max)<=0){
                ls.insertar(elemNodo,1);
            }
            if(elemNodo.compareTo(min)>0){
                listarRangoAux(min, max, ls, nodo.getIzquierdo());
            }
        }
    }
    
    public Comparable minimoElem(){
        Comparable min;
        min= minAux(this.raiz);
        return min;
    }
    private Comparable minAux(NodoABB nodo){
        Comparable minimo=null;
        if(nodo!=null){
            if(nodo.getIzquierdo()!=null){//si tiene hijo izquierdo lo sigue pasando hasta llegar a la hoja 
                minimo = minAux(nodo.getIzquierdo());
            }else//cuando es hoja asigna el valor y lo devuelve
                minimo=nodo.getElem();
        }
        return minimo;
    }
    
    public Comparable maximoElem(){
        Comparable max;
        return max=maxAux(this.raiz);
    }
    private Comparable maxAux(NodoABB nodo){
        Comparable maximo=null;
        if(nodo!=null){//si el nodo no es nulo(sirve por si es vacio)
            if(nodo.getDerecho()!=null){//si el nodo hijo derecho existe, sigue iterando hasta encontrar la hoja
                maximo=maxAux(nodo.getDerecho());
            }else{
                maximo=nodo.getElem();
            }
        }
        return maximo;
    }
    
    @Override
    public ArbolBB clone(){
        ArbolBB clon = new ArbolBB();
        clon.raiz= clonarAux(this.raiz);
        return clon;
    }
    private NodoABB clonarAux (NodoABB nodo){
        NodoABB hijo= null;
        if(nodo!=null){
            hijo= new NodoABB(nodo.getElem(), clonarAux(nodo.getDerecho()),clonarAux(nodo.getIzquierdo()));
        }
        return hijo;
    }
    
    public String toString(){
        //preorden
        String cadena="";
        if(this.raiz!=null){
            cadena= auxToString(this.raiz);
        }
        return cadena;
    }
    private String auxToString(NodoABB nodo){
        String cad="";
        if(nodo!=null){
            cad = cad+"Nodo: "+nodo.getElem();
            if(nodo.getIzquierdo()!=null){
                cad=cad+ "HI: "+nodo.getIzquierdo().getElem();   
            }else{
                cad=cad+"HI -";
            }
            cad+="HD:";
            if(nodo.getDerecho()!=null){
                cad+=nodo.getDerecho().getElem();
            }else{
                cad+="-";
        }
        cad+="\n" + auxToString(nodo.getIzquierdo()) + auxToString(nodo.getDerecho());
        }
        return cad;
    }
    
    
    
    




























































}
