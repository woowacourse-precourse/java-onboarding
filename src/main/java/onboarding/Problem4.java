package onboarding;

public class Problem4 {

    private static char getConvertCharacter(char c) {
        int valueDifference;
        if(isAlpha(c)){
            if(Character.isUpperCase(c)){
                valueDifference = 'Z' - c + 'A';
            }
            else{
                valueDifference = 'z' - c + 'a';
            }
            c = (char)valueDifference;
        }
        return c;
    }

    private static boolean isAlpha(char c) {
        return (int) c >= 65 && (int) c <= 122;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
