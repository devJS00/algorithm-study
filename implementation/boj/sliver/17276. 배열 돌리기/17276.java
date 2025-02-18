import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] rotatedMatrix = rotateMatrix(matrix, d);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(rotatedMatrix[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
        br.close();
    }

    private static int[][] rotateMatrix(int[][] matrix, int d) {
        int n = matrix.length;
        int rotateCount = d / 45;
        if (rotateCount < 0) {
            rotateCount = 8 + rotateCount;
        }

        for (int r = 0; r < rotateCount; r++) {
            int[][] tempMatrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        tempMatrix[i][(n - 1) / 2] = matrix[i][j];
                    } else if (j == (n - 1) / 2) {
                        tempMatrix[i][n - i - 1] = matrix[i][j];
                    } else if (i + j == n - 1) {
                        tempMatrix[(n - 1) / 2][j] = matrix[i][j];
                    } else if(i == (n - 1) / 2) {
                        tempMatrix[j][j] = matrix[i][j];
                    }
                    else {
                        tempMatrix[i][j] = matrix[i][j];
                    }
                }
            }
            matrix = tempMatrix;
        }

        return matrix;

    }
}
