import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] numbers;
    static int count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        backtracking(0, 0);

        if (S == 0) count--;

        System.out.println(count);
        br.close();
    }

    // 트리로 경우의 수를 탐색한다고 생각하면 이해하기 쉬움
    private static void backtracking(int idx, int sum) {
        if(idx == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        backtracking(idx + 1, sum + numbers[idx]);  // 현재 원소를 더하는 경우
        backtracking(idx + 1, sum);  // 현재 원소를 더하지 않는 경우
    }
}
