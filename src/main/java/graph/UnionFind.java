package graph;

public class UnionFind {
    static int[] unf;

    // 부모찾기
    // 나와 연결된 애를 거슬러 올라가 부모를 찾는다.
    // 부모를 찾으면 배열을 업데이트 한다.
    public static int find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }


    //셋팅하기
    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fb] = fa;
    }
}
