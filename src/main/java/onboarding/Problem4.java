package onboarding;

public class Problem4 {


    public static char convertAlpahbet(char ch) {   // 해당 문자를 변환
        char converted;

        if (Character.isUpperCase(ch)) {
            converted = (char)('Z' - (ch - 'A'));
        }
        else {
            converted = (char)('z' - (ch - 'a'));
        }

        return converted;
    }



    public static String solution(String word) {
        String answer = "";

        return answer;
    }
}
