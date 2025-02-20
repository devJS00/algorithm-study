import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);

        char[][] grid = new char[r][c];

        for (int i = 0; i < r; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        char[][] result = simulateBomberman(r, c, n, grid);

        for (int i = 0; i < r; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    private static char[][] fullBombGrid(int r, int c) {
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = 'O';
            }
        }
        return grid;
    }

    private static char[][] explode(int r, int c, char[][] grid) {
        char[][] newGrid = fullBombGrid(r, c);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'O') {
                    newGrid[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];

                        if (ni >= 0 && ni < r && nj >= 0 && nj < c) {
                            newGrid[ni][nj] = '.';
                        }
                    }
                }
            }
        }

        return newGrid;
    }

    private static char[][] simulateBomberman(int r, int c, int n, char[][] grid) {
        if (n == 1) return grid;
        if (n % 4 == 1) return explode(r, c, explode(r, c, grid));
        if (n % 2 == 0) return fullBombGrid(r, c);
        if (n % 4 == 3) return explode(r, c, grid);
        return new char[][]{};
    }
}
