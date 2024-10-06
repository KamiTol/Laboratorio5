package BFS;

import Util.Graph;

public class BFSAristas {
    public static void main(String[] args) {
        // Crear grafos con distintos tamaños de aristas: 10, 100 y 1000
        Graph<Integer> graph10Edges = createGraph(10, 10);   // Grafo con 10 nodos y 10 aristas
        Graph<Integer> graph100Edges = createGraph(100, 100); // Grafo con 100 nodos y 100 aristas
        Graph<Integer> graph1000Edges = createGraph(1000, 1000); // Grafo con 1000 nodos y 1000 aristas

        BFS1 bfs = new BFS1();

        // Realizar la búsqueda en cada grafo y medir el tiempo de ejecución
        System.out.println("Evaluación en grafo con 10 aristas:");
        evaluatePerformance(graph10Edges, bfs, 1);

        System.out.println("Evaluación en grafo con 100 aristas:");
        evaluatePerformance(graph100Edges, bfs, 1);

        System.out.println("Evaluación en grafo con 1000 aristas:");
        evaluatePerformance(graph1000Edges, bfs, 1);
    }

    public static void evaluatePerformance(Graph<Integer> graph, BFS1 bfs, Integer startVertexId) {
        long startTime = System.nanoTime();  // Captura el tiempo inicial
        bfs.bfs(graph, startVertexId);       // Ejecuta BFS
        long endTime = System.nanoTime();    // Captura el tiempo final
        long duration = endTime - startTime; // Calcula la duración

        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos");
    }

    public static Graph<Integer> createGraph(int numVertices, int numEdges) {
        Graph<Integer> graph = new Graph<>();
        // Crear los vértices
        for (int i = 1; i <= numVertices; i++) {
            graph.addVertex(i);
        }

        // Crear conexiones entre los nodos (aristas)
        int edgesAdded = 0;
        for (int i = 1; i < numVertices && edgesAdded < numEdges; i++) {
            for (int j = i + 1; j <= numVertices && edgesAdded < numEdges; j++) {
                graph.addEdge(i, j);
                edgesAdded++;
            }
        }

        return graph;
    }
}