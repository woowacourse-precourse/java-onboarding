package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {

        // word는 길이가 1 이상 1,000 이하인 문자열이다.
        if (word.length() < 1 || word.length() > 1000){
            return "";
        }
        return transferLogic(word);
    }

    public static boolean isLowerAlpha(int word){
        if (word >= 97 && word <= 122){
            return true;
        }
        return false;
    }

    public static boolean isUpperAlpha(int word){
        if (word >= 65 && word <= 90){
            return true;
        }

        return false;
    }

    public static String transferLogic(String word){
        String answer ="";
        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i);

            if (isUpperAlpha(index)){
                index = 90 - (index - 65);
            }

            else if (isLowerAlpha(index)){
                index = 122 - (index - 97);
            }


            answer += (char)index;
        }
        return answer;
    }
}
