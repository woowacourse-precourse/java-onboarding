package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (isLowerCase(c)){
                c = (char)(-c + 'z' + 'a');
            }
            else if (isUpperCase(c)){
                c = (char)(-c + 'Z' + 'A');
            }
            answer += c;
        }
        return answer;
    }

    public static boolean isLowerCase(char c){
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }

    public static boolean isUpperCase(char c){
        if (c >= 'A' && c <= 'Z') return true;
        return false;
    }



}
