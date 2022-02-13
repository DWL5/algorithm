package kakao;

public class BlockGame {
    int n;
    int[][] b;

    boolean find(int row, int col, int h, int w) {
        int empty = 0;
        int lastValue = -1;

        for (int r = row; r < row + h; r++) {
            for (int c = col; c < col + w; c++) {
                if (b[r][c] == 0) {
                    if (!canFill(r,c)) return false;
                    empty++;
                    if (empty > 2) {
                        return false;
                    }
                } else {
                    // 블록이 채워져 있는 경우
                    //최초 만난 블록값과 h, w내에서 다른 값을 만난다면 다른 도형이 겹친것으로 판단
                    if (lastValue != -1 && lastValue != b[r][c]) {
                        return false;
                    }
                    //최초 만난 블록 값
                    lastValue = b[r][c];
                }
            }
        }

        //지워주기
        for (int r = row; r < row + h; r++) {
            for (int c = col; c < col + w; c++) {
                b[r][c] = 0;
            }
        }
        return true;
    }

    boolean canFill(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (b[i][col] != 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[][] board) {
        this.n = board.length;
        this.b = board;
        int answer = 0;
        int cnt;
        do {
            cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i <= n-2 && j <= n-3 && find(i, j, 2, 3)) {
                        cnt++;
                    } else if(i <= n-3 && j <= n-2 && find(i, j, 3,2)) {
                        cnt++;
                    }
                }
            }
            answer += cnt;
        } while (cnt != 0);
        return answer;
    }
}
