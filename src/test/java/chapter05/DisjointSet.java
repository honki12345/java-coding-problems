package chapter05;

import org.junit.jupiter.api.Test;

public class DisjointSet {
    int n;
    int[] rank;
    int[] parent;

    public DisjointSet(int n) {
        this.n = n;
        rank = new int[n];
        parent = new int[n];

    }

    private void initializeDisjointSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent[x]);
        }
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            return;
        }

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    @Test
    void test() throws Exception {
        //given //when //then
        DisjointSet set = new DisjointSet(11);
        set.union(0, 1);
        set.union(4, 9);
        set.union(6, 5);
        set.union(0, 7);
        set.union(4, 3);
        set.union(4, 2);
        set.union(6, 10);
        set.union(4, 5);

    }
}
