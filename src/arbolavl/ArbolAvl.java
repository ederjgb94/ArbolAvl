package arbolavl;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolAvl {

    Nodo raiz;

    void insertarBin(int num) {
        if (raiz == null) {
            raiz = new Nodo(num);
        } else {
            insertarBin(raiz, num);
        }
    }

    Nodo insertarBin(Nodo aux, int num) {
        if (aux == null) {
            return new Nodo(num);
        } else if (num < aux.num) {
            aux.izq = insertarBin(aux.izq, num);
        } else {
            aux.der = insertarBin(aux.der, num);
        }
        return aux;
    }

    void imprimir() {
        Queue<Nodo> cola = new LinkedList<Nodo>();

        if (raiz != null) {
            cola.add(raiz);

            while (!cola.isEmpty()) {
                if (cola.element().izq != null) {
                    cola.add(cola.element().izq);
                }

                if (cola.element().der != null) {
                    cola.add(cola.element().der);
                }

                System.out.print("[" + cola.element().num + " " + cola.poll().altura + "]");

            }
        }

        System.out.println("");

    }

    void altura() {
        altura(raiz);
    }

    void altura(Nodo nodo) {
        //profe... no se ria de mi codigo
        if (nodo != null) {
            altura(nodo.izq);
            altura(nodo.der);
            if (nodo.der == null && nodo.izq == null) { //si es hoja
                nodo.altura = 1;
            } else if (nodo.izq == null) { //si no es hoja y no tiene hijo izq
                nodo.altura = nodo.der.altura + 1;
            } else if (nodo.der == null) {//si no tiene hijo der
                nodo.altura = nodo.izq.altura + 1;
            } else if (nodo.izq.altura > nodo.der.altura) { // si no es hoja, compara quien es el mayor de lso hijos
                nodo.altura = nodo.izq.altura + 1;
            } else {
                nodo.altura = nodo.der.altura + 1;
            }
        }
    }

}
