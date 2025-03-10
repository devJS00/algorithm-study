import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N, M 입력
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        // 보드 입력
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 결과 계산
        int result = Solution(board, N, M);

        // 결과 출력
        sb.append(result).append("\n");
        System.out.print(sb.toString());

        br.close();
    }

    public static int Solution(char[][] board, int N, int M) {
        int minRepaint = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minRepaint = Math.min(minRepaint, getRepaintCount(board, i, j));
            }
        }
        return minRepaint;
    }

    public static int getRepaintCount(char[][] board, int row, int col) {
        int count1 = 0; // 체스판의 시작이 W인 경우
        int count2 = 0; // 체스판의 시작이 B인 경우

        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W') {
                        count1++;
                    } else {
                        count2++;
                    }
                } else {
                    if (board[i][j] != 'B') {
                        count1++;
                    } else {
                        count2++;
                    }
                }
            }
        }

        return Math.min(count1, count2);
    }
}
