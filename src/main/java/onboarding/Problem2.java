package onboarding;

import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";
        System.out.println("암호를 해독하면 다음과 같습니다 : " + solution(cryptogram));
    }
    public static String solution(String cryptogram) {
        String answer = "";

//        반복문 사용하기
        String[] chars = cryptogram.split("");
        System.out.println(Arrays.toString(chars));

        if (cryptogram.length() == 0) {
            answer = "";
            return answer;
        }

        for (int i = 1; i < cryptogram.length(); i++){
            if (chars[i-1].equals(chars[i])) {
                chars[i-1] = "";
                chars[i] = "";
                answer += "";
            }

            if (!chars[i-1].equals(chars[i])) {
                answer += chars[i-1];
            }

            if (i == cryptogram.length()-1) {
                answer += chars[i];
            }
            answer = solution(answer);
        }
        return answer;
    }
}