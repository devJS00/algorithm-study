import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = getMinimumBags(N);

        bw.write(result + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    public static int getMinimumBags(int N) {
        int threeCount = 0;
        int fiveCount = 0;

        // 5로 나누어 떨어질 때까지 3을 빼줌
        while(N % 5 != 0) {
            N -= 3;
            threeCount++;
            if(N < 0) {
                return -1;
            }
        }

        fiveCount = N / 5;

        return threeCount + fiveCount;
    }
}
