package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char translateGreenFrogChar(char c){
        char greenFrogChar = c;
        if(c >= 'a' && c <= 'z'){
            greenFrogChar = (char)('z' - c + 'a');
        }
        else if(c >= 'A' && c <= 'Z'){
            greenFrogChar = (char)('Z' - c + 'A');
        }

        return greenFrogChar;
    }
}
