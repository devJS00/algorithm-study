import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String result = reverseWords(input);
        bw.write(result);
        bw.newLine();

        bw.flush();
        br.close();
        bw.close();
    }

    public static String reverseWords(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isTag = false;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                isTag = true;
                sb.append(ch);
            } else if (ch == '>') {
                isTag = false;
                sb.append(ch);
            } else if (isTag == true) {
                sb.append(ch);
            } else if (ch == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
