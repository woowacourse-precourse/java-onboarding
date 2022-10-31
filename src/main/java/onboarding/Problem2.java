package onboarding;

import org.mockito.internal.matchers.Null;

public class Problem2 {
    public static boolean CHECK_REDUP(String cryptogram){
        char[] charArr = cryptogram.toCharArray();
        boolean result = false;
        for(int i = 0; i < charArr.length - 1; i++){
            if(charArr[i] == charArr[i + 1]){
                result = true;
                break;
            }
        }
        return result;
    }
    public static String REMOVE_DUP(String s){
        String result = "";
        for (int i = 0; i < s.length(); i++){
            if(i == s.length() - 1){
                if(s.charAt(i) != s.charAt(i-1)){
                    result += Character.toString(s.charAt(i));
                }
            } else {
                if(s.charAt(i) != s.charAt(i+1)){
                    result += Character.toString(s.charAt(i));
                } else {
                    while(s.charAt(i) == s.charAt(i + 1)){
                        if(i == s.length() - 2){
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return result;
    }
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while(CHECK_REDUP(answer)){
            answer = REMOVE_DUP(answer);
        }

        return answer;
    }
}
