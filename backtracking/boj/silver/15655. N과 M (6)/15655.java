import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N]; 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(N, M, numbers); 

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
