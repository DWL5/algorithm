package kakao;

public class LockAndKeySolution {
    public boolean solution(int[][] key, int[][] lock) {
        int offset = key.length - 1;

        for (int r = 0; r < offset + lock.length; r++) {
            for (int c = 0; c < offset + lock.length; c++) {
                for (int rot = 0; rot < 4; rot++) {
                  int[][] arr = new int[58][58];
                  // 가운데 자물쇠 위치 시키기
                  for (int i = 0; i < lock.length; i++) {
                      for (int j = 0; j < lock.length; j++) {
                          arr[offset + i][offset + j] = lock[i][j];
                      }
                  }
                  match(arr, key, rot, r, c);
                  if (check(arr, offset, lock.length)) {
                      return true;
                  }
                }
            }
        }

        return false;
    }

    boolean check(int[][] arr, int offset, int n) {
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (arr[offset + i][offset + j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    void match(int[][] arr, int[][] key, int rot, int r, int c) {
        int n = key.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rot == 0) {
                    arr[r + i][c + j] += key[i][j];
                } else if (rot == 1) { // 90
                    arr[r + i][c + j] += key[j][n - 1 - i];
                } else if (rot == 2) { // 180
                    arr[r + i][c + j] += key[n -1 - i][n - 1 -j];
                } else if (rot == 3) { //270
                    arr[r + i][c + j] += key[n - 1 -j][i];
                }

            }
        }
    }
}
