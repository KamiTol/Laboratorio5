package DFS;

import Util.Graph;

public class MainDFS {
    public static void main(String[] args) {
        int[] smallSizes = {5, 12, 15, 17, 20}; // 5, 12, 15, 17, 20 Numero de Localidades
        int[] mediumSizes = {100, 250, 500, 750, 1000}; // 100, 250, 500, 750, 1000 Numero de Localidades
        int[] largeSizes = {1000, 2500, 5000, 7500, 10000}; // 1000, 2500, 5000, 7500, 10000 Numero de Localidades

        DFS dfs = new DFS();

        System.out.println("Pruebas DFS en grafos pequeños:");
        for (int size : smallSizes) {
            Graph graph = createGraph(size);
            long startTime = System.nanoTime();
            dfs.dfs(graph, 1);
            long endTime = System.nanoTime();
            System.out.println("Tiempo para " + size + " nodos: " + (endTime - startTime) + " ns");
        }

        System.out.println("\nPruebas DFS en grafos medianos:");
        for (int size : mediumSizes) {
            Graph graph = createGraph(size);
            long startTime = System.nanoTime();
            dfs.dfs(graph, 1);
            long endTime = System.nanoTime();
            System.out.println("Tiempo para " + size + " nodos: " + (endTime - startTime) + " ns");
        }

        System.out.println("\nPruebas DFS en grafos grandes:");
        for (int size : largeSizes) {
            Graph graph = createGraph(size);
            long startTime = System.nanoTime();
            dfs.dfs(graph, 1);
            long endTime = System.nanoTime();
            System.out.println("Tiempo para " + size + " nodos: " + (endTime - startTime) + " ns");
        }
    }

    private static Graph createGraph(int size) {
        Graph graph = new Graph();
        for (int i = 1; i <= size; i++) {
            graph.addVertex(i);
        }
        for (int i = 1; i < size; i++) {
            graph.addEdge(i, i + 1);
        }
        return graph;
    }
}