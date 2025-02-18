import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 격자 크기 입력
        int n = Integer.parseInt(br.readLine());

        // 지뢰 위치 입력
        char[][] mineField = new char[n][n];
        for (int i = 0; i < n; i++) {
            mineField[i] = br.readLine().toCharArray();
        }

        // 플레이 상태 입력
        char[][] playField = new char[n][n];
        for (int i = 0; i < n; i++) {
            playField[i] = br.readLine().toCharArray();
        }

        // 지뢰찾기 결과 계산
        char[][] resultField = getMineSweeperResult(n, mineField, playField);

        // 결과 출력
        for (int i = 0; i < n; i++) {
            bw.write(resultField[i]);
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static char[][] getMineSweeperResult(int n, char[][] mineField, char[][] playField) {
        char[][] result = new char[n][n];
        boolean isMine = false;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(playField[i][j] == 'x') {
                    if(mineField[i][j] == '*') {
                        isMine = true;
                    } else {
                        int count = 0;
                        for(int x = i - 1; x <= i + 1; x++) {
                            for(int y = j - 1; y <= j + 1; y++) {
                                if(x < 0 || x >= n || y < 0 || y >= n) {
                                    continue;
                                }
                                if(mineField[x][y] == '*') {
                                    count++;
                                }
                            }
                        }
                        result[i][j] = (char)(count + '0');
                    }
                } else {
                    result[i][j] = '.';
                }
            }
        }

        // 지뢰를 밟았을 경우 지뢰가 있는 위치를 모두 표시
        if(isMine) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(mineField[i][j] == '*') {
                        result[i][j] = '*';
                    }
                }
            }
        }
        return result;
    }
}
