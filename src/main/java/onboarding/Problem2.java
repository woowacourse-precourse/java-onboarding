package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    // code 배열 상태에 따른 알파벳 넣을지 말지.
    static List<Character> updateCode(List<Character> code, char alpha) {
        if(code.size() != 0 && code.get(code.size()-1) == alpha) {
            code.remove(code.size()-1);
        } else {
            code.add(alpha);
        }
        return code;
    }

    public static String solution(String cryptogram) {
        List<Character> code = new ArrayList<>();
        for(char alpha : cryptogram.toCharArray()) {
            code = updateCode(code, alpha);
        }
        return code;
    }
}
