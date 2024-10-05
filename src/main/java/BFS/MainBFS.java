package BFS;

import Util.Graph;


public class MainBFS {
    public static void main(String[] args) {
        // Crear grafos con distintos tamaños: pequeños, medianos y grandes
        Graph smallGraph = createGraph(10);   // Grafo pequeño con 10 nodos
        Graph mediumGraph = createGraph(100); // Grafo mediano con 100 nodos
        Graph largeGraph = createGraph(1000); // Grafo grande con 1000 nodos

        BFS bfs = new BFS();

        // Realizar la búsqueda en cada grafo y medir el tiempo de ejecución
        System.out.println("Evaluación en grafo pequeño:");
        evaluatePerformance(smallGraph, bfs, 1);

        System.out.println("Evaluación en grafo mediano:");
        evaluatePerformance(mediumGraph, bfs, 1);

        System.out.println("Evaluación en grafo grande:");
        evaluatePerformance(largeGraph, bfs, 1);
    }

    public static void evaluatePerformance(Graph graph, BFS bfs, int startVertexId) {
        long startTime = System.nanoTime();  // Captura el tiempo inicial
        bfs.bfs(graph, startVertexId);       // Ejecuta BFS
        long endTime = System.nanoTime();    // Captura el tiempo final
        long duration = endTime - startTime; // Calcula la duración

        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos");
    }

    public static Graph createGraph(int size) {
        Graph graph = new Graph();
        // Crear los vértices
        for (int i = 1; i <= size; i++) {
            graph.addVertex(i);
        }

        // Crear conexiones entre los nodos (aristas)
        for (int i = 1; i < size; i++) {
            graph.addEdge(i, i + 1); // Conectar cada nodo con el siguiente
        }

        return graph;
    }
}
