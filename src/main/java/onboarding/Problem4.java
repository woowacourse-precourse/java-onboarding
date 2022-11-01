package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='A' && word.charAt(i)<='Z'){
                answer += up_change_word(word.charAt(i));
            }else if(word.charAt(i)>='a' && word.charAt(i)<='z') {
                answer += low_change_word(word.charAt(i));
            }else answer += ' ';
        }


        return answer;
    }

    static char up_change_word(char ch) {
        return (char)('Z' - ch + 'A');
    }

    static char low_change_word(char ch){
        return (char)('z' - ch + 'a');
    }
}
