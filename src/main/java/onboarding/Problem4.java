package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    public static String toGreenFrogLanguage(String word){
        String greenFrogWord = "";
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            char greenFrogChar = translateGreenFrogChar(c);

            greenFrogWord += greenFrogChar;

        }
        return greenFrogWord;
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
