import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 수업 개수 입력
        int N = scanner.nextInt();
        int[][] lectures = new int[N][2];

        // 수업 시작 시간과 종료 시간 입력
        for (int i = 0; i < N; i++) {
            lectures[i][0] = scanner.nextInt(); // 시작 시간
            lectures[i][1] = scanner.nextInt(); // 종료 시간
        }

        int result = minClassrooms(N, lectures);

        System.out.println(result);

        scanner.close();
    }

    public static int minClassrooms(int N, int[][] lectures) {
        Arrays.sort(lectures, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i][0]) { // 가장 빨리 끝나는 강의의 종료 시간보다 현재 강의의 시작 시간이 늦다면
                pq.poll();
            }
            pq.add(lectures[i][1]); // 현재 강의의 종료 시간을 우선순위 큐에 추가
        }

        return pq.size();
    }
}
