package onboarding;

import java.util.Scanner;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        for (int i = 0; i < cryptogram.length(); i++) {
            if (cryptogram.indexOf(cryptogram.charAt(i)) == i)	//i의 문자열을 다 가져온다, 같은것을 꺼내온다
                answer += cryptogram.charAt(i);

        }
        return answer;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cryptogram = scanner.next();
        System.out.println(solution(cryptogram));
    }
}
