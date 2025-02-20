import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer> selected = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();  // StringBuilder 사용하지 않으면 시간 초과 발생

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backtracking();

        System.out.print(sb);
        br.close();
    }

    private static void backtracking() {
        if (selected.size() == M) {
            for (int s : selected) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(selected.size() == 0 || selected.get(selected.size() - 1) < i) {
                selected.add(i);
                backtracking();
                selected.remove(selected.size() - 1);
            }
        }
    }
}
