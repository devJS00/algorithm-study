import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = getMinimumCoins(n);
        System.out.println(result);

        scanner.close();
    }

    public static int getMinimumCoins(int n) {
        if (n < 2) {
            return -1;
        }
        
        int twoCount = 0;
        
        while(n % 5 != 0) {
            n -= 2;
            twoCount++;
            
            if(n < 0) {
                return -1;
            }
        }

        int fiveCount = n / 5;

        return fiveCount + twoCount;
    }
}
