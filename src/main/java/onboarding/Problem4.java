package onboarding;

import java.util.HashMap;
import java.util.Objects;

public class Problem4 {
    public static String solution(String word) {
        //스트링연산이 많으므로 StringBuilder를 사용한다.
        StringBuilder answer = new StringBuilder();

        //청개구리 알파벳 map을 만든다.
        HashMap<Character, Character> alphabet = createAlphabetDic();

        //
        for (String s: word.split("")) {
            char c = s.charAt(0);
            //문자가 알파벳에 해당하면 사전에서 찾아서 바꿔준다.
            if (65 <= c && c <= 122) {
                answer.append(alphabet.get(c));
            } else {
                answer.append(s);
            }
        }

        return answer.toString();
    }

    private static HashMap<Character, Character> createAlphabetDic() {
        HashMap<Character, Character> alphabetDic = new HashMap<>();
        for (int i = 0; i < 26; i++ ){
            alphabetDic.put((char) ('a'+i), (char) ('z'-i));
            alphabetDic.put((char) ('A'+i), (char) ('Z'-i));
        }
        return alphabetDic;
    }
}
