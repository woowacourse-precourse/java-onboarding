package onboarding;

import java.util.ArrayList;
import java.util.List;
public class Problem4 {
    public static String solution(String word) {
        List<String> strList = new ArrayList<>();
        String answer = "";

        for(int i=0; i<word.length(); i++){
            // ASCII UPPER
            if((int)word.charAt(i)>=65 && (int)word.charAt(i)<=90){
                strList.add(String.valueOf((char)((int)word.charAt(i)+25-(((int)word.charAt(i)-65)*2))));
            }
            // ASCII LOWER
            else if((int)word.charAt(i)>=97 && (int)word.charAt(i)<=122) {
                strList.add(String.valueOf((char) ((int) word.charAt(i) + 25 - (((int) word.charAt(i) - 97) * 2))));
            }
        }
        answer=strList.toString().join("",strList);
        return answer;
    }
}
