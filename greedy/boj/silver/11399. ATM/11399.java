import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }

        int result = getMinimumTime(N, P);

        System.out.println(result);

        scanner.close();
    }

    public static int getMinimumTime(int N, int[] P) {
        Arrays.sort(P);

        int totalTime = 0;
        int sum = 0;

        for (int time : P) {
            sum += time;
            totalTime += sum;
        }

        return totalTime;
    }
}
