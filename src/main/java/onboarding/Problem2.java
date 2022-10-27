package onboarding;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(solution(str));
    }

    public static String solution(String cryptogram) {
        if (cryptogram == null || cryptogram.length() == 0) {
            return "";
        }

        char[] ch = cryptogram.toCharArray();

        int i, k = 0;

        for (i = 1; i < ch.length; i++) {
            if (ch[i - 1] != ch[i]) {
                ch[k++] = ch[i - 1];
            }else {

                while (i < ch.length && ch[i - 1] == ch[i]) {
                    i++;
                }
            }
        }

        ch[k++] = ch[i - 1];

        String answer = new String(ch).substring(0, k);

        if (k != ch.length) {
            return solution(answer);
        }

        return answer;

    }
}
