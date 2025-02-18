import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 스위치 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 스위치 상태 입력
        int[] switches = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 수 입력
        int students = Integer.parseInt(br.readLine());

        // 학생 정보 입력 및 처리
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            changeSwitches(switches, n, gender, num);
        }

        // 스위치 상태 출력
        for (int i = 1; i <= n; i++) {
            bw.write(switches[i] + " ");
            if (i % 20 == 0) {
                bw.newLine();
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void changeSwitches(int[] switches, int n, int gender, int num) {
        if (gender == 1) {
            for (int i = num; i <= n; i += num) {
                switches[i] = 1 - switches[i];
            }
        } else if(gender == 2) {
            int left = num - 1;
            int right = num + 1;
            switches[num] = 1 - switches[num];
            while(left > 0 && right <= n && switches[left] == switches[right]) {
                switches[left] = 1 - switches[left];
                switches[right] = 1 - switches[right];
                left--;
                right++;
            }
        }

    }
}
