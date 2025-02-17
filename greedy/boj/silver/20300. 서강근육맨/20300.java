import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long[] T = new long[N];

        for (int i = 0; i < N; i++) {
            T[i] = scanner.nextLong();
        }

        System.out.println(getMinimumM(N, T));

        scanner.close();
    }

    public static long getMinimumM(int N, long[] T) {
        Arrays.sort(T);
        long minLoss = 0;

        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                minLoss = Math.max(minLoss, T[i] + T[N - 1 - i]);
            }
        } else {
            minLoss = T[N - 1];
            for (int i = 0; i < N / 2; i++) {
                minLoss = Math.max(minLoss, T[i] + T[N - 2 - i]);
            }
        }

        return minLoss;
    }
}
