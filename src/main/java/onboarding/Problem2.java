package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        List<Character> charList = new ArrayList<Character>();

        for(int i = 0; i < cryptogram.length(); i++){
            charList.add(cryptogram.charAt(i));
        }
        boolean bool = true;
        while(bool) {
            bool = false;
            int n = 1;
            for (int i = 0; i < charList.size() - n; i++) {
                if (charList.get(i) == charList.get(i + 1)) {
                    charList.remove(i);
                    charList.remove(i);
                    i--;
                    n = n + 2;
                    bool = true;
                }
            }
        }

        answer = "";
        for(int i = 0; i < charList.size();i++){
            answer = answer + charList.get(i);
        }

        return answer;
    }
}
