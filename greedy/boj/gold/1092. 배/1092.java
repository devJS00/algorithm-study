import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 크레인 개수 입력
        int N = scanner.nextInt();
        int[] cranes = new int[N];

        // 크레인 무게 제한 입력
        for (int i = 0; i < N; i++) {
            cranes[i] = scanner.nextInt();
        }

        // 박스 개수 입력
        int M = scanner.nextInt();
        int[] boxes = new int[M];

        // 박스 무게 입력
        for (int i = 0; i < M; i++) {
            boxes[i] = scanner.nextInt();
        }

        // 최소 시간 계산
        int result = calculateMinTime(N, cranes, M, boxes);

        // 결과 출력
        System.out.println(result);

        scanner.close();
    }

    public static int calculateMinTime (int N, int[] cranes, int M, int[] boxes) {
        Arrays.sort(cranes);
        Arrays.sort(boxes);

        if (cranes[N - 1] < boxes[M - 1]) {
            return -1;
        }

        List<Integer> craneList = new ArrayList<>();
        List<Integer> boxList = new ArrayList<>();

        // 내림차순 정렬
        for (int i = N - 1; i >= 0; i--) {
            craneList.add(cranes[i]);
        }

        for (int i = M - 1; i >= 0; i--) {
            boxList.add(boxes[i]);
        }

        int time = 0;

        while (!boxList.isEmpty()) {
            int craneIndex = 0;
            int boxIndex = 0;

            while (craneIndex < craneList.size()) {
                if (boxIndex >= boxList.size()) {
                    break;
                }
                if (craneList.get(craneIndex) >= boxList.get(boxIndex)) {
                    boxList.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }
            time++;
        }
        return time;
    }
}
