import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        backtracking(N, M);

        br.close();
    }

    static ArrayList<Integer> selected = new ArrayList<>();

    private static void backtracking(int N, int M) {
        if(selected.size() == M) {
            for(int s : selected) {
                System.out.print(s + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!selected.contains(i)){
                selected.add(i);
                backtracking(N, M);
                selected.remove(selected.size() - 1);
            }
        }
    }
}
