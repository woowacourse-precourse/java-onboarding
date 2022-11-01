package onboarding;

import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i=0;i<word.length();i++){
            char target = word.charAt(i);
            if (target>=65 && target<=90){
                answer.append((char)(Math.abs(target-90)+65));
            }
            else if(target>=97 && target<=122){
                answer.append((char)(Math.abs(target-122)+97));
            }else{
                answer.append(target);
            }
        }
        return answer.toString();
    }
}
