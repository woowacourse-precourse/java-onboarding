package onboarding;

import java.util.regex.Pattern;

public class Problem4 {
    public static String solution(String word) {
        String result ="";
        char[] wordtemp = word.toCharArray();
        int reverse, abstmp, acsii = 0;
        for(int index = 0; index < wordtemp.length; index++){
            if(Character.isUpperCase(wordtemp[index])){
                acsii = 65;
            }
            if(Character.isLowerCase(wordtemp[index])){
                acsii = 97;
            }
            if(!(Character.isUpperCase(wordtemp[index]) || Character.isLowerCase(wordtemp[index]))){
                result += ' ';
                continue;
            }
            abstmp = Math.abs(acsii - wordtemp[index]);
            reverse = (acsii + 25 ) - abstmp;
            result = result + String.valueOf((char) reverse);
        }
        return result;
    }
}
