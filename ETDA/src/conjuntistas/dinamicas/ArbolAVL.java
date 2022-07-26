package conjuntistas.dinamicas;

public class ArbolAVL {

    private NodoAVL raiz;
    //suposicion

    public ArbolAVL() {
        this.raiz = null;
    }

    public Boolean pertenece(Comparable elem) {
        boolean exito = false;
        if (this.raiz != null) {
            exito = auxPertenece(this.raiz, elem);
        }
        return exito;
    }

    private boolean auxPertenece(NodoAVL nodo, Comparable elem) {
        boolean encontrado = false;
        if (nodo != null) {
            if (nodo.getElem().compareTo(elem) > 0) {
                if (nodo.getIzquierdo() != null) {
                    encontrado = auxPertenece(nodo.getIzquierdo(), elem);
                }
            } else if (nodo.getElem().compareTo(elem) < 0) {
                if (nodo.getDerecho() != null) {
                    encontrado = auxPertenece(nodo.getDerecho(), elem);
                }
            } else {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public boolean insertar(Comparable elem) {
        boolean exito = true;
        if (this.raiz != null) {
            exito = insertarAux(this.raiz, null, elem);
        } else {
            this.raiz = new NodoAVL(elem);
        }
        return exito;
    }

    private boolean insertarAux(NodoAVL nodo, NodoAVL padre, Comparable elem) {
        boolean res = true;
        if (nodo != null) {
            if (nodo.getElem().compareTo(elem) == 0) {
                res = false;
            } else {
                if (nodo.getElem().compareTo(elem) > 0) {
                    if (nodo.getIzquierdo() != null) {
                        res = insertarAux(nodo.getIzquierdo(), nodo, elem);
                    } else {
                        nodo.setIzquierdo(new NodoAVL(elem));
                    }
                } else {
                    if (nodo.getDerecho() != null) {
                        res = insertarAux(nodo.getDerecho(), nodo, elem);
                    } else {
                        nodo.setDerecho(new NodoAVL(elem));
                    }
                }
                nodo.recalcularAltura();
                equilibrar(nodo, padre, balance(nodo));
            }
        }
        return res;
    }

    private void equilibrar(NodoAVL nodo, NodoAVL padre, int balanceN) {
        if (nodo != null) {
            if (nodo.getAltura() != 0) {
                int balanceHi = balance(nodo.getIzquierdo());
                int balanceHD = balance(nodo.getDerecho());
                int lado = 1;
                if (padre != null) {
                    if (nodo.getElem().compareTo(padre.getElem()) > 0) {
                        //se ubica a la derecha del padre
                        lado = -1;
                    } else {
                        //se ubica a la izquierda del padre
                        lado = -1;
                    }
                }
                if (balanceN == 2 || balanceN == -2) {
                    if (balanceN == 2) {
                        if (balanceHi >= 0) {
                            if (padre != null) {
                                if (lado == -1) {
                                    padre.setDerecho(rotarDerecha(nodo));
                                } else {
                                    padre.setIzquierdo(rotarIzquierda(nodo));
                                }
                            } else {
                                this.raiz = rotarDerecha(this.raiz);
                                this.raiz.recalcularAltura();
                            }
                        } else {
                            if (padre != null) {
                                if (lado == -1) {
                                    padre.setDerecho(rotarDobleIzqDer(nodo));
                                } else {
                                    padre.setIzquierdo(rotarDobleIzqDer(nodo));
                                }
                            } else {
                                this.raiz = rotarDobleIzqDer(this.raiz);
                                this.raiz.recalcularAltura();
                            }
                        }
                    } else {
                        if (balanceHD <= 0) {
                            if (padre != null) {
                                if (lado == -1) {
                                    padre.setDerecho(rotarIzquierda(nodo));
                                } else {
                                    padre.setIzquierdo(rotarDerecha(nodo));
                                }
                            } else {
                                this.raiz = rotarIzquierda(this.raiz);
                                this.raiz.recalcularAltura();
                            }
                        } else {
                            if (padre != null) {
                                if (lado == -1) {
                                    padre.setDerecho(rotarDobleDerIzq(nodo));
                                } else {
                                    padre.setIzquierdo(rotarDobleDerIzq(nodo));
                                }
                            } else {
                                this.raiz = rotarDobleDerIzq(this.raiz);
                                this.raiz.recalcularAltura();
                            }
                        }
                    }
                }
            }

        }
    }
    
    public void eliminarMinimo(){
        if(this.raiz!=null){
            if(this.raiz.getIzquierdo()!=null){
                eliminarMinimoAux(this.raiz);
            }else{
                this.raiz = this.raiz.getDerecho();
            }
        }
    }
 
    private void eliminarMinimoAux(NodoAVL n){
        if(n.getIzquierdo().getIzquierdo()==null){
            n.setIzquierdo(n.getIzquierdo().getDerecho());
        }else{
            eliminarMinimoAux(n.getIzquierdo());
        }
    }
    
    public void eliminarMaximo(){
        if(this.raiz!=null){
            if(this.raiz.getDerecho()!=null){
                eliminarMaximoAux(this.raiz);
            }else{
                this.raiz= this.raiz.getIzquierdo();
            }
        }
    }
    
    private void eliminarMaximoAux(NodoAVL n){
        if(n.getDerecho().getDerecho()==null){
            n.setDerecho(n.getIzquierdo());
        }else{
            eliminarMaximoAux(n.getDerecho());
        }
    }
            
    private NodoAVL rotarIzquierda(NodoAVL r) {
        NodoAVL h = r.getDerecho();
        NodoAVL temp = h.getIzquierdo();
        h.setIzquierdo(r);
        r.setDerecho(temp);
        return r;
    }

    private NodoAVL rotarDerecha(NodoAVL r) {
        NodoAVL h = r.getIzquierdo();
        NodoAVL temp = h.getDerecho();
        h.setDerecho(r);
        r.setIzquierdo(temp);
        return r;
    }

    private NodoAVL rotarDobleIzqDer(NodoAVL r) {
        r.setIzquierdo(rotarIzquierda(r.getIzquierdo()));
        rotarDerecha(r);
        return r;
    }

    private NodoAVL rotarDobleDerIzq(NodoAVL r) {
        r.setDerecho(rotarIzquierda(r.getDerecho()));
        rotarIzquierda(r);
        return r;
    }

    private int balance(NodoAVL nodo) {
        int alturaHi = -1, alturaHD = -1, balance;
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                alturaHi = nodo.getIzquierdo().getAltura();
            }
            if (nodo.getDerecho() != null) {
                alturaHD = nodo.getDerecho().getAltura();
            }
        }
        balance = alturaHi - alturaHD;
        return balance;
    }

}
