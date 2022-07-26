package conjuntistas.lineales;

public class ArbolHeap {

    private final int TAMANIO = 10;
    private Comparable[] heap;
    private int ultimo;

    public ArbolHeap() {
        this.ultimo = 0;
        this.heap = new Comparable[TAMANIO];
    }

    public boolean insertar(Comparable elem) {
        boolean exito = false;
        if (ultimo + 1 < TAMANIO) {//si no esta llena
            exito = true;
            ultimo++;
            heap[ultimo] = elem;//agrega el elemento nuevo
            hacerSubir(ultimo);//lo acomoda donde debe estar
        }
        return exito;
    }

     private void hacerSubir(int posHijo) {
        //metodo para hacer subir el ultimo valor ingresado hacia la posicion que debe estar
        boolean exito = true;
        int posPadre;
        //COMPARABLE SIRVE PARA COMPARAR OBJETOS, DEVULVE NEGATIVO SI ES MENOR Y UN NUM POSITIVO SI ES MAYOR
        Comparable temp = this.heap[posHijo];
        while (exito) {
            posPadre = posHijo / 2;//Como los hijos de un nodo estan en la posicion 2k y 2k+1
            //su padre esta en la posicion k/2 , con division entera
            if (posPadre >= 1) {
                if (this.heap[posPadre].compareTo(temp) < 0) {
                    //Si el padre es mayor al hijo, se intercambian
                    this.heap[posHijo]=this.heap[posPadre];
                    this.heap[posPadre]=temp;//la posicion del hijo que teniamos guardado en un aux
                    posHijo=posPadre;
                }else{
                    exito=false;
                }}
                else{
                        exito=false;
                        }
        }
    }
    
    public boolean eliminarCima(){
        boolean exito;
        if(this.ultimo==0){
            exito=false;
        }else{
            this.heap[1]=this.heap[ultimo];
            ultimo--;
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }
    
     public void hacerBajar(int posPadre){
         boolean salida= false;
         Comparable temp= this.heap[posPadre];
         while(!salida){
            int posHijo=posPadre*2;
             if(posHijo<=this.ultimo){
                  //Temp tiene al menos un hijo(izq) y lo considera menor
                 if (posHijo < this.ultimo) {
                    //HijoMenor tiene hermano derecho
                    
                    if(this.heap[posHijo+1].compareTo(this.heap[posHijo])<0){
                        //hijo derecho es menor que hijo izquierdo
                        posHijo++; //acomoda el puntero en el hijo con el que se va a realizar el intercambio
                    }}
                    //ahora lo compara con el padre
                    if(this.heap[posHijo].compareTo(temp)<0){
                        this.heap[posPadre]=this.heap[posHijo];//intercambia con el padre
                        this.heap[posHijo]=temp;
                        posPadre=posHijo;
                    }else{
                        //el padre esta en la posicion correcta ya que de los dos hijos el menor es mayor que el padre
                        salida=true;
             }
         }else{
                 //esta bien ubicado, el temp es hoja
                 salida=true;
             }  
     }
}
     
    public boolean esVacio(){
        boolean salida=true;
        if(this.ultimo!=0){
            salida=false;
        }
        return salida;
        //return (this.ultimo==0);
    }
    
    public Comparable recuperarCima(){
        Comparable aux=null;
        if(!esVacio()){
            aux= this.heap[1];//primer elemento
        }
        return aux;
    }
    
    @Override
    public String toString(){
        String cadena="ARBOL VACIO";
        if(!esVacio()){
            cadena=" ";
            for(int i=0;i<=this.ultimo;i++){
                cadena=cadena+ this.heap[i].toString()+" :";
                if(2*i<=this.ultimo){//me paro en el hijo izquierdo
                    cadena=cadena+"HI->"+this.heap[2*i].toString();
                }
                 if((2*i)+1<=this.ultimo){//me paro en el hijo derecho
                     cadena+="HD->"+this.heap[(2*i)+1].toString();
                 } 
                 cadena += "\n";
            }
        }
        return cadena;
    }
    
    @Override
    public ArbolHeap clone(){
        ArbolHeap clonado= new ArbolHeap();
        clonado.heap=this.heap.clone();
        clonado.ultimo=this.ultimo;
        return clonado;
    }



}
    
    
    
    
    

