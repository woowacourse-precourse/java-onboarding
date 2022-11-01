package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sentence = new StringBuilder(word);
        
        for (int i = 0; i < word.length(); i++) {
            sentence.setCharAt(i, changeAlphabet(word.charAt(i)));
        }
        return sentence.toString();
    }
}
