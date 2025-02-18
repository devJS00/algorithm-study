import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = getMinimumBags(N);

        bw.write(result + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    public static int getMinimumBags(int N) {
        int[] dp = new int[N + 1];
        final int INF = Integer.MAX_VALUE;

        for (int i = 0; i <= N; i++) {
            dp[i] = INF;
        }

        if (N >= 3) dp[3] = 1;
        if (N >= 5) dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            if (dp[i - 3] != INF) dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            if (dp[i - 5] != INF) dp[i] = Math.min(dp[i], dp[i - 5] + 1);
        }

        return dp[N] == INF ? -1 : dp[N];
    }
}
