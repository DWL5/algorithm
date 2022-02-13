package dfs_bfs;

public class Subset {

    static int n; // 집합의 원소의 개수
    static int[] ch;
    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];

        DFS(1);
    }

    public static void DFS(int l) {
        if (l == n+1) {
            String tmp = "";
            for (int i = 1; i <=n; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }

            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        }
        else {
            ch[l] = 1;
            DFS(l + 1);
            ch[l] = 0;
            DFS(l + 1);
        }
    }
}
