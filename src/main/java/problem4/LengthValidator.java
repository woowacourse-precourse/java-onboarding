package problem4;

public class LengthValidator {
    public static int lengthValidate(String word) {
        int wordLength = word.length();
        if (wordLength >= 1 && wordLength <= 1000) return wordLength;
        else throw new RuntimeException("Invalid word length");
    }
}
