package greedy;

public class UnionFind {
    public static int[] parent = new int[1000001];

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static  void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    public static boolean isConnected(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return true;
        else return false;
    }
}
