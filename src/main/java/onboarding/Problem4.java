package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    // 대소문자 구별
    public static int ascii(char ch) {
        int asc = 0;

        if(Character.isUpperCase(ch))
            asc = 65;
        else if(Character.isLowerCase(ch))
            asc = 97;

        return asc;
    }
}
