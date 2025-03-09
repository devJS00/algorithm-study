import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> pointList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            pointList.add(br.readLine());
        }
        br.close();

        // 정렬 및 결과 출력
        String result = Solution(pointList);
        System.out.print(result);
    }

    public static String Solution(List<String> pointList) {
        List<Point> points = new ArrayList<>();
        for (String p : pointList) {
            String[] temp = p.split(" ");
            points.add(new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }

        Collections.sort(points, (p1, p2) -> {
            if (p1.x == p2.x) {
                return p1.y - p2.y;
            } else {
                return p1.x - p2.x;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Point p : points) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        return sb.toString();
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
