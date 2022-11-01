package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {
    public static String solution(String cryptogram) {

        StringBuilder sb = new StringBuilder(cryptogram);

        check : while (true) {
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb = sb.deleteCharAt(i);
                    sb = sb.deleteCharAt(i);
                    i--;
                    //    System.out.println(sb);
                }

                if (i == sb.length() -2) { // rechecking
                    for (int j = 0; j < sb.length() - 1; j++) {
                        if (sb.charAt(j) == sb.charAt(j + 1)) {
                            continue check;
                        }
                        if (j == sb.length() - 2) {
                            break check;
                        }
                    }
                }
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solution(s));
    }
}
