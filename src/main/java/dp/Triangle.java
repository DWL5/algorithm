package dp;

class Triangle {
    public int solution(int[][] triangle) {
        int h = triangle.length;
        int[] dp = new int[h*(h+1)/2];
        int last = triangle.length - 1;
        int idx = 0;
        for (int i = 0; i < triangle[last].length; i++) {
            dp[i] = triangle[last][i];
            idx++;
        }

        for(int i = last - 1; i >= 0; i--) {
            int[] line = triangle[i];
            for (int j = 0; j < line.length; j++) {
                int left = line[j] + dp[idx - (line.length + 1)];
                int right = line[j] + dp[idx - line.length];
                dp[idx] = Math.max(left, right);
                idx++;
            }
        }

        return dp[dp.length -1];
    }
}