package onboarding;

import java.util.Stack;

public class Problem2 {
    static int index;
    static String cryptogram;
    static int cryptogramLength;

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /*
     * 현재 문자와 같지 않은 다른 문자가 나올 떄까지 인덱스 증가
     *
     * @return void
     * */
    private static void moveIndex(char character) {
        while(index < cryptogramLength && character == cryptogram.charAt(index)) {
            index++;
        }
    }
}
