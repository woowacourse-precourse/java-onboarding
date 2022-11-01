package onboarding;

import java.util.StringTokenizer;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0;i<word.length();i++){
            if(word.charAt(i) >= 65 && word.charAt(i) <=90){
                answer += (char)(155-word.charAt(i));
            }
            else if(word.charAt(i) >= 97 && word.charAt(i) <=122){
                answer += (char)(219-word.charAt(i));
            }
            else{
                answer += (char)(word.charAt(i));
            }
        }

        return answer;
    }
}
