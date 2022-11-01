package onboarding;

import java.util.ArrayList;

public class Problem4 {

    public static int change(int charIndex){
        if(Character.isUpperCase(charIndex)){
            charIndex = 155-charIndex;
        }else charIndex = 219-charIndex;
        return charIndex;
    }
    public static String charToString(ArrayList cArr){
        String result = "";
        for(int i = 0; i < cArr.size(); i++){
            result += cArr.get(i).toString();
        }
        return result;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
