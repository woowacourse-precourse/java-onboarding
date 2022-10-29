package onboarding;

public class Problem4 {

    //문자열의 문자가 알파벳인지 아닌지 확인
    public static boolean isAlphabet(char c){
        if((c-'a'>=0) & (c-'a'<26))
            return true;
        else if((c-'A'>=0) & (c-'Z' <26))
            return true;
        else
            return false;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
