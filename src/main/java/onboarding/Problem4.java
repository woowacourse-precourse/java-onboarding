package onboarding;
import java.util.*;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        StringBuffer str = new StringBuffer();
        str.append(word);

        int[] chararr = new int[word.length()];         
      
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascch = (int)ch;
            if((64 < ascch & ascch < 78) | (97 < ascch & ascch < 110)){
                chararr[i] = 155 - ascch;
            }
        }
        
        answer = chararr.toString();

        return answer;
    }
}

