package kakao;

public class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int[] degree = {0, 90, 180, 270};
        int[] arrow = {0, 1, 2, 3};
        int m = key.length;
        int[][] k;
        for (int i = 0; i < degree.length; i++) {
            if (i == 0) {
                k = key;
            } else {
                k = rotate(key, degree[i]);
            }
            if(check(k, lock)) {
                return true;
            }
            // move하기전 검사
            int[][] mK = new int[m][m];
            for (int j = 0; j < arrow.length; j++) {
                for (int l = 0; l < m - 1; l++) {
                    mK = move(key, arrow[j], l);
                }

                if(check(mK, lock)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean check(int[][] key, int[][] lock) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                if (key[i][j] == lock[i][j]) {
                    return false;

                }
            }
        }
        return true;
    }

    // 0 오른쪽, 1 왼쪽, 2 위, 3 아래
    int[][] move(int[][] arr, int arrow, int dist) {
        int n = arr.length;
        int[][] move = new int[n][n];
        if (arrow == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - dist < 0) {
                        move[j][i] = 0;
                    } else {
                        move[j][i] = arr[j][i - dist];
                    }
                }
            }
        } else if (arrow == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - dist > 0) {
                        move[j][i] = 0;
                    } else {
                        move[j][i] = arr[j][i + dist];
                    }
                }
            }
        } else if (arrow == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - dist < 0) {
                        move[i][j] = 0;
                    } else {
                        move[i][j] = arr[i - dist][j];
                    }
                }
            }
        } else if (arrow == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - dist > 0) {
                        move[i][j] = 0;
                    } else {
                        move[i][j] = arr[i + dist][j];
                    }
                }
            }
        }
        return move;
    }

    int[][] rotate(int[][] arr, int degree) {
        int n = arr.length; // 행
        int[][] rotate = new int[n][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                if (degree == 90) {
                    rotate[i][j] = arr[n-1-j][i];
                } else if (degree == 180) {
                    rotate[i][j] = arr[n - 1 - i][n - 1 - j];
                } else if(degree == 270) {
                    rotate[i][j] = arr[j][n-1-i];
                }
            }
        }

        return rotate;
    }
}
