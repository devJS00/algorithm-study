import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        int[] drinks = new int[N];
        for (int i = 0; i < N; i++) {
            drinks[i] = Integer.parseInt(parts[i]);
        }

        // 출력
        System.out.println(solution(drinks));
    }

    public static double solution(int[] drinks) {
        Arrays.sort(drinks);
        double answer = drinks[drinks.length - 1];
        for (int i = 0; i < drinks.length - 1; i++) {
            answer += (double) drinks[i] / 2.0;
        }

        return answer;
    }
}
