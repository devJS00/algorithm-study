import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 총 날짜 수
        int K = Integer.parseInt(st.nextToken()); // 연속 날짜 수

        // 온도 데이터 입력
        int[] temperatures = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(N, K, temperatures);

        // 결과 출력
        bw.write(result + "\n");

        // 스트림 닫기
        bw.flush();
        bw.close();
        br.close();
    }

    static int solution(int N, int K, int[] temperatures) {
        int left = 1;
        int right = K;
        int max_sum = 0;
        int current_sum = 0;

        for (int i = 0; i < K; i++) {
            current_sum += temperatures[i];
        }

        max_sum = current_sum;

        while (right < temperatures.length) {
            current_sum = current_sum - temperatures[left - 1] + temperatures[right];
            max_sum = Math.max(max_sum, current_sum);
            left++;
            right++;

        }
        return max_sum;
    }
}
