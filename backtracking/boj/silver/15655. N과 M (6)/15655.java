import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N]; // 입력된 N개의 자연수 저장 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers); // 수열을 사전순으로 출력하기 위해 정렬

        backtracking(N, M, numbers); // 백트래킹 함수 호출

        br.close();
    }

    static ArrayList<Integer> selected = new ArrayList<>();

    private static void backtracking(int N, int M, int[] numbers) {
        Arrays.sort(numbers);
        if(selected.size() == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(selected.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(selected.isEmpty() || selected.get(selected.size() - 1) < numbers[i]) {
                selected.add(numbers[i]);
                backtracking(N, M, numbers);
                selected.remove(selected.size() - 1);
            }
        }
    }
}
