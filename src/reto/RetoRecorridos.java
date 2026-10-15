package reto;

public class RetoRecorridos {
 
    // Inserta una matricula en el ABB (ignora repetidos). Ya viene hecho.
    static NodoEstudiante insertar(NodoEstudiante nodo, int matricula) {
        if (nodo == null) { // caso base: lugar libre
            return new NodoEstudiante(new Estudiante(matricula,
                    String.format("18%08d", matricula),
                    "Estudiante " + matricula, 8));
        }
        int actual = nodo.getDato().getMatricula();
        if (matricula < actual) { // caso recursivo: izquierda
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), matricula));
        } else if (matricula > actual) { // caso recursivo: derecha
            nodo.setDerecho(insertar(nodo.getDerecho(), matricula));
        }
        return nodo;
    }
 
    // TODO 1: PREORDEN = visita el nodo, luego izquierda, luego derecha
    static void preorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) {
            System.out.println(sangria + "null -> regresa");
            return;
        }
        int matricula = nodo.getDato().getMatricula();
        System.out.println(sangria + "entra " + matricula);
        
        // VISITA
        System.out.println(sangria + "VISITA " + matricula);
        salida.append(matricula).append(' ');
        
        // Llamadas recursivas
        preorden(nodo.getIzquierdo(), sangria + "  ", salida);
        preorden(nodo.getDerecho(), sangria + "  ", salida);
    }
 
    // TODO 2: INORDEN = izquierda, luego visita el nodo, luego derecha
    static void inorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) {
            System.out.println(sangria + "null -> regresa");
            return;
        }
        int matricula = nodo.getDato().getMatricula();
        System.out.println(sangria + "entra " + matricula);
        
        inorden(nodo.getIzquierdo(), sangria + "  ", salida);
        
        // VISITA
        System.out.println(sangria + "VISITA " + matricula);
        salida.append(matricula).append(' ');
        
        inorden(nodo.getDerecho(), sangria + "  ", salida);
    }
 
    // TODO 3: POSORDEN = izquierda, luego derecha, luego visita el nodo
    static void posorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) {
            System.out.println(sangria + "null -> regresa");
            return;
        }
        int matricula = nodo.getDato().getMatricula();
        System.out.println(sangria + "entra " + matricula);
        
        posorden(nodo.getIzquierdo(), sangria + "  ", salida);
        posorden(nodo.getDerecho(), sangria + "  ", salida);
        
        // VISITA
        System.out.println(sangria + "VISITA " + matricula);
        salida.append(matricula).append(' ');
    }
 
    // TODO 4 (EXTRA): altura en aristas (1 + la mayor altura de sus dos lados)
    static int altura(NodoEstudiante nodo) {
        if (nodo == null) {
            return -1;
        }
        int alturaIzq = altura(nodo.getIzquierdo());
        int alturaDer = altura(nodo.getDerecho());
        return 1 + Math.max(alturaIzq, alturaDer);
    }
 
    static NodoEstudiante construir(int[] matriculas) {
        NodoEstudiante raiz = null;
        for (int m : matriculas) {
            raiz = insertar(raiz, m);
        }
        return raiz;
    }
 
    static void ejecutar(String titulo, int[] matriculas) {
        System.out.println("=== " + titulo + " ===");
        NodoEstudiante raiz = construir(matriculas);
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder pos = new StringBuilder();
        System.out.println("-- traza PREORDEN");
        preorden(raiz, "", pre);
        System.out.println("-- traza INORDEN");
        inorden(raiz, "", in);
        System.out.println("-- traza POSORDEN");
        posorden(raiz, "", pos);
        System.out.println("Preorden: " + pre.toString().trim());
        System.out.println("Inorden:  " + in.toString().trim());
        System.out.println("Posorden: " + pos.toString().trim());
        System.out.println("Altura (extra): " + altura(raiz));
        System.out.println();
    }
 
    public static void main(String[] args) {
        ejecutar("Reto SW-N3-A", new int[]{45, 25, 70, 10, 30, 60, 90, 27, 65});
        ejecutar("Caso limite: arbol vacio", new int[]{});
        ejecutar("Caso limite: un solo nodo", new int[]{50});
        ejecutar("Caso limite: cadena", new int[]{10, 20, 30, 40});
        ejecutar("Caso limite: repetido (30 dos veces)", new int[]{20, 30, 30, 10});
    }
}
