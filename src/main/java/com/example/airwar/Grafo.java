package com.example.airwar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase representa un grafo no dirigido en Java.
 */
public class Grafo {
    private Map<Point, Nodo> nodos;

    /**
     * Crea un nuevo grafo vacío.
     */
    public Grafo() {
        nodos = new HashMap<>();
    }

    /**
     * Agrega un nodo al grafo.
     *
     * @param nodo el nodo a agregar
     */
    public void agregarNodo(Nodo nodo) {
        nodos.put(new Point(nodo.getX(), nodo.getY()), nodo);
    }

    /**
     * Agrega una conexión entre dos nodos del grafo.
     *
     * @param nodo1 el primer nodo
     * @param nodo2 el segundo nodo
     */
    public void agregarConexion(Nodo nodo1, Nodo nodo2) {
        nodo1.agregarVecino(nodo2);
        nodo2.agregarVecino(nodo1);
    }

    /**
     * Obtiene un nodo del grafo dado su posición (x, y).
     *
     * @param x la coordenada x del nodo
     * @param y la coordenada y del nodo
     * @return el nodo correspondiente a la posición (x, y), o null si no se encuentra
     */
    public Nodo obtenerNodo(double x, double y) {
        return nodos.get(new Point(x, y));
    }

    // Otros métodos y operaciones del grafo

    /**
     * Esta clase representa un nodo en el grafo.
     */
    public static class Nodo {
        private double x;
        private double y;
        private List<Nodo> vecinos;

        /**
         * Crea un nuevo nodo con la posición (x, y).
         *
         * @param x la coordenada x del nodo
         * @param y la coordenada y del nodo
         */
        public Nodo(double x, double y) {
            this.x = x;
            this.y = y;
            this.vecinos = new ArrayList<>();
        }

        /**
         * Obtiene la coordenada x del nodo.
         *
         * @return la coordenada x del nodo
         */
        public double getX() {
            return x;
        }

        /**
         * Obtiene la coordenada y del nodo.
         *
         * @return la coordenada y del nodo
         */
        public double getY() {
            return y;
        }

        /**
         * Obtiene la lista de vecinos del nodo.
         *
         * @return la lista de vecinos del nodo
         */
        public List<Nodo> getVecinos() {
            return vecinos;
        }

        /**
         * Agrega un vecino al nodo.
         *
         * @param vecino el nodo vecino a agregar
         */
        public void agregarVecino(Nodo vecino) {
            vecinos.add(vecino);
        }
    }

    /**
     * Esta clase representa un punto en un plano.
     */
    public static class Point {
        private double x;
        private double y;

        /**
         * Crea un nuevo punto con las coordenadas (x, y).
         *
         * @param x la coordenada x del punto
         * @param y la coordenada y del punto
         */
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Compara este punto con otro objeto para verificar si son iguales.
         *
         * @param o el objeto a comparar
         * @return true si el objeto es igual a este punto, false en caso contrario
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }

        /**
         * Calcula el hash code de este punto.
         *
         * @return el hash code calculado
         */
        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(x);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(y);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}
