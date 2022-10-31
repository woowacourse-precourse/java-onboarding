package onboarding;

import java.util.List;
import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] list = word.toCharArray();
        for(int i=0;i<list.length;i++){
            if(!Character.isLetter(list[i])){
                continue;
            }
            if(Character.isUpperCase(list[i])){
                list[i] = (char)(155 - (int)list[i]);
            }
            else{
                list[i] = (char)(219 - (int)list[i]);
            }
        }
        answer = new String(list);
        return answer;
    }
}
