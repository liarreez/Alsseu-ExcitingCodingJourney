import java.util.Scanner;

public class BOJ1520_내리막길 {
    static int[][] map;
    static int[][] dp;

    static int M;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        dfs(0, 0);
        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if(x == M -1 && y == N -1)
            return  1;

        if(dp[x][y] != -1)
            return dp[x][y];

        dp[x][y] = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= M || ny < 0 || ny >= N)
                continue;
            if(map[nx][ny] < map[x][y])
                dp[x][y] += dfs(nx, ny);
        }
        return dp[x][y];
    }

}
