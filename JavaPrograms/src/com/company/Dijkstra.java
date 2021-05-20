package com.company;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            long weight = scanner.nextLong();
            graph.get(u).add(new Edge(u, v, weight));
            graph.get(v).add(new Edge(v, u, weight));
        }

        int fixedSource = scanner.nextInt() - 1;

        long[] distance = new long[n];
        int[] parent = new int[n];
        doDijkstraFromSourceToAllAndMaintainPath(graph, fixedSource, parent, distance);
        for (int i = 0; i < n; i++) {
            System.out.print(distance[i] + " ");
        }
//        debugPathFromFixedSource(fixedSource, 1, parent, distance);
        scanner.close();
    }

    private static void doDijkstraFromSourceToAllAndMaintainPath(List<List<Edge>> graph, int source,
                                                                 int[] parent, long[] distance) {

        Arrays.fill(distance, Long.MAX_VALUE); // All distance set to INFINITY
        Arrays.fill(parent, -1); // All parents invalidated

        distance[source] = 0L;
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(new Vertex(source, 0L));

        while (!queue.isEmpty()) {
            int v = queue.peek().vertex;
            long distanceFromSourceToV = queue.poll().distanceFromSource;

            /*
             * When current vertex `v` has already been reached from `source`
             * via some other channel with a lesser distance, then there is
             * no need to process it any further.
             */
            if (distanceFromSourceToV > distance[v]) {
                continue;
            }

            for (Edge edge : graph.get(v)) {
                // Push a vertex if and only if it is "making things better"
                if (distance[v] + edge.weight < distance[edge.v]) {
                    distance[edge.v] = distance[v] + edge.weight;
                    parent[edge.v] = v;
                    queue.add(new Vertex(edge.v, distance[edge.v]));
                }
            }
        }
    }

    /*
     * The `source` here should be the same as the one with respect to which our
     * Dijkstra Algorithm loaded our `distance` and `parent` arrays. Otherwise
     * this method will show unexpected results.
     */
    private static void debugPathFromFixedSource(int source, int destination, int[] parent, long[] distance) {
        // In case `source` and `destination` belong to disconnected components
        if (distance[destination] == Long.MAX_VALUE) {
            System.err.println("Path: []; Distance: INFINITY");
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int v = destination; v != source; v = parent[v]) {
            path.add(v);
        }
        path.add(source);

        System.err.print("Path: [");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.err.print(path.get(i) + 1);
            if (i > 0) {
                System.err.print(", ");
            }
        }
        System.err.println("]; Distance: " + distance[destination]);
    }

    // A Graph Vertex
    private static class Vertex implements Comparable<Vertex> {
        int vertex;
        long distanceFromSource;

        public Vertex(int vertex, long distanceFromSource) {
            this.vertex = vertex;
            this.distanceFromSource = distanceFromSource;
        }

        /*
         * This is a comparator which will tell which among the given two
         * vertices (this and other) are closer to the source.
         *
         * When both distances are same, then we are comparing their vertex IDs.
         * Although, this is not necessary to do, but still, if there are two
         * different vertices with the same distance, then there should be some
         * measure to distinguish between them, a good programming practice it is.
         */
        @Override
        public int compareTo(Vertex other) {
            if (this.distanceFromSource == other.distanceFromSource) {
                return this.vertex - other.vertex;
            }
            return (this.distanceFromSource < other.distanceFromSource ? -1 : 1);
        }
    }

    // An Undirected Weighted Graph Edge
    private static class Edge {
        int u, v; // The end points (vertices) of the edge
        long weight; // Edge length

        public Edge(int u, int v, long weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
}

