package onboarding.problem4;

public class Word {

    public static String getReverseWord(String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            char reverseChar = Alphabet.changeAlphabet(word.charAt(i));
            result += reverseChar;
        }
        return result;
    }
}
