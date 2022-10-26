package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (char c: word.toCharArray()){
            char current = c;
            if (Character.isAlphabetic(c)){
                current = convertToFrogAlphabet(c);
            }
            answer += current;
        }

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