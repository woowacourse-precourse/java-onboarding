package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        System.out.println("====solution====");
        // 암호문 문자 리스트
        ArrayList<Character> result = new ArrayList<>();
        for(int i=0; i<cryptogram.length(); i++) {
            result.add(cryptogram.charAt(i));
        }
        System.out.println("result: "+ Arrays.toString(result.toArray()));

        String answer = "answer";
        return answer;
    }
}
