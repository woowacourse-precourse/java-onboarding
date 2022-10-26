package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char convertToFrogAlphabet(char alphabet){
        char frogAlphabet;
        if (Character.isLowerCase(alphabet)){
            frogAlphabet = (char)('z' - (alphabet - 'a'));
        }else{
            frogAlphabet = (char)('Z' - (alphabet - 'A'));
        }
        return frogAlphabet;
    }
}