import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] ropes = new int[N];

        for (int i = 0; i < N; i++) {
            ropes[i] = scanner.nextInt();
        }

        int result = getMaxWeight(N, ropes);

        System.out.println(result);

        scanner.close();
    }

    public static int getMaxWeight(int N, int[] ropes) {
        Arrays.sort(ropes);
        int maxWeight = 0;
        for (int i = 0; i < N; i++) {
            int weight = ropes[i] * (N - i); // 사용할 로프 개수만큼 곱함
            maxWeight = Math.max(maxWeight, weight);
        }

        return maxWeight;
    }
}
