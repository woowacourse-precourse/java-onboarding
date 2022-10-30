package problem4;

public class LengthValidator {
    public static boolean lengthValidate(String word) {
        int wordLength = word.length();
        return wordLength >= 1 && wordLength <= 1000;
    }
}
