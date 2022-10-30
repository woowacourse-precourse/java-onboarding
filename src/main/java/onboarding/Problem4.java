package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i=0; i<word.length();i++){
            char current = word.charAt(i);
            int charCode = (int)current;
            if ((charCode>64) && (charCode<91))
            {
                int idx = charCode-65;
                idx = 90 - idx;
                current = (char) idx;
            }
            if ((charCode>96) && (charCode<123))
            {
                int idx = charCode-97;
                idx = 122 - idx;
                current = (char) idx;
            }
            answer+=current;
        }
        return answer;
    }
}
