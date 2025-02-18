import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N];

        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int result = getMaxScore(N, stairs);

        bw.write(result + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    public static int getMaxScore(int N, int[] stairs) {
        if (N == 1) return stairs[0];
        if (N == 2) return stairs[0] + stairs[1];

        int[] dp = new int[N];

        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];
        dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        return dp[N - 1];
    }
}
