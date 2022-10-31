package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    static List<Character> ConvertStringToList(String str){
        List<Character> list_cryptogram = new ArrayList<Character>();
        for (char c: str.toCharArray()){
            list_cryptogram.add(c);
        }
        return list_cryptogram;
    }

    public static String solution(String cryptogram) {
        List<Character> list_cryptogram = ConvertStringToList(cryptogram);
        String answer = "answer";
        return answer;
    }
}
