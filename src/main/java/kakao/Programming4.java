package kakao;

class Programming4 {

    public static void main(String[] args) {
        Programming4 solution = new Programming4();
        System.out.println(solution.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}));
    }

    int[] check;
    int[] info;
    int[] answer;
    int max = Integer.MIN_VALUE;
    int total;

    public int[] solution(int n, int[] info) {
        this.info = info;
        this.check = new int[11];
        this.total = n;
        DFS(0, n);
        if (max < 0) {
            return new int[]{-1};
        }
        return answer;
    }

    public boolean end(int[] check, int total) {
        int sum = 0;
        for (int c : check) {
            sum += c;
        }

        return sum == total;
    }


    public void DFS(int L, int n) {
        if (L == 11) {
            int diff = calculate(info, check);
            if (diff > 0 && diff >= max) {
                check[L - 1] = n;
                answer = check.clone();
                max = diff;
            }
            return;
        }

        if (end(check, total)) {
            if (n < 0) return;
            int diff = calculate(info, check);
            if (diff > 0 && diff >= max) {
                if (diff == max) {
                    answer = checkLowScore(answer, check).clone();
                } else {
                    answer = check.clone();
                    max = diff;
                }
            }
        } else {
            int enable = n - (info[L] + 1);
            if (enable >= 0) {
                check[L] = info[L] + 1;
                DFS(L + 1, enable);
            }
            check[L] = 0;
            DFS(L + 1, n);
        }
    }

    public int calculate(int[] a, int[] r) {
        int aScore = 0;
        int rScore = 0;

        for (int i = 11; i >= 1; i--) {
            if (a[11 - i] >= r[11 - i]) {
                if (a[11 - i] != 0) {
                    aScore += i - 1;
                }
            } else {
                if (r[11 - i] != 0) {
                    rScore += i - 1;
                }
            }
        }
        return rScore - aScore;
    }

    public int[] checkLowScore(int[] a, int[] b) {
        if (a == null) return b;
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println("a : " + a[i] + "b : " + b[i]);
            if (a[i] == b[i]) continue;
            if (a[i] > 0 && b[i] == 0) {
                return a;
            } else {
                return b;
            }
        }
        return b;
    }
}