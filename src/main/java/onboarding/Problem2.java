package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        //암호문 리스트로 변환
        List<String> cryptogramList = wordToList(cryptogram);
        return answer;
    }
    public static List wordToList(String word){
        return new ArrayList<>(Arrays.asList(word.split("")));
    }
}
