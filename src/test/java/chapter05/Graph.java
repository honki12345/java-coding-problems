package chapter05;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {
    private final int v;
    private final LinkedList<Integer>[] adjacents;

    public Graph(int v) {
        this.v = v;
        adjacents = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjacents[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int e) {
        adjacents[v].add(e);
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[start] = true;

        queue.add(start);

        while (!queue.isEmpty()) {
            start = queue.poll();
            System.out.printf("%d ", start);

            Iterator<Integer> iterator = adjacents[start].listIterator();
            while (iterator.hasNext()) {
                Integer n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}
