package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        //String을 List<Character>으로 변환
        List<Character> cyp = new ArrayList<Character>();
        for(int i=0; i<cryptogram.length(); i++){
            cyp.add(cryptogram.charAt(i));
        }

        return answer;
    }
}