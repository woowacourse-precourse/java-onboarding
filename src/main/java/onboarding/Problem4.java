package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char convertAlphabet(char c){
        if(isUpper(c))
            return (char)('Z' - c + 'A');

        return (char)('z' - c + 'a');
    }

    private static boolean isUpper(char c){
        return c>='A'&&c<='Z';
    }

    private static boolean isAlphabet(char c){
        return (c>='A'&&c<='Z')||(c>='a'&&c<='z');
    }
}
