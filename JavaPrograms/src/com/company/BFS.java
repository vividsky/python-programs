package com.company;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class Graph {
    static LinkedList<Integer> adj[];

    public Graph(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }
    public static int BFS(int source, int destination) {
        boolean[] vis = new boolean[adj.length];
        int[] parent = new int[adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;
        parent[source] = -1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == destination) break;
            for (int neighbour : adj[cur]) {
                if (vis[neighbour] == false) {
                    q.add(neighbour);
                    vis[neighbour] = true;
                    parent[neighbour] = cur;
                }
            }
        }
        int cur = destination;
        int distance = 0;
        while (parent[cur] != -1) {
            distance++;
            System.out.print(cur + " -> ");
            cur = parent[cur];
        }System.out.println(source);
        return distance;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        System.out.println("V and E: ");
        int v = input.nextInt(), e = input.nextInt();
        Graph graph = new Graph(v);
//        System.out.print(e + "Edges: ");

        for (int i = 0; i < e; i++) {
            int source = input.nextInt();
            int destination = input.nextInt();
            graph.addEdge(source, destination);
        }
//        System.out.println("Source and Destination:");
        int source = input.nextInt(), destination = input.nextInt();
        int distance = BFS(source, destination);

        System.out.println(distance);
    }
}


