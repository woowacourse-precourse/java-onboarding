package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    static char reverse(char token){
        char result = token;
        if (Character.isAlphabetic(token)){
            result = Character.isLowerCase(token) ? (char)('a' + 'z' - token): (char)('A' + 'Z' - token);
        }

        return result;
    }
}
