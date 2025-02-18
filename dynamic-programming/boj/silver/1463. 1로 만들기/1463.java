import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = getMinOperations(N);

        bw.write(result + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    public static int getMinOperations(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 0;

        for(int i = 2; i <= N; i++) {
            // 먼저 1을 빼는 경우, 3으로 나누는 경우, 2로 나누는 경우 중 최소 연산 횟수를 찾는다.
            dp[i] = dp[i - 1] + 1;
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }

        return dp[N];
    }
}
