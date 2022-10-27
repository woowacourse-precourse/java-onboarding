package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String reversedWord = "";

        for (int i = 0; i < word.length(); i++) {

            if (isAlphabet(word.charAt(i))) {
                reversedWord += reverseAlphabet(word.charAt(i));
                continue;
            }
            reversedWord += word.charAt(i);
        }
        return reversedWord;
    }

    public static boolean isAlphabet(char alphabet) {

        if (alphabet >= 'a' && alphabet <= 'z') {
            return true;
        } else if (alphabet >= 'A' && alphabet <= 'Z') {
            return true;
        }
        return false;
    }

    public static char reverseAlphabet(char alphabet) {
        String reversedUpperAlphabet = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String reversedLowerAlphabet = "zyxwvutsrqponmlkjihgfedcba";
        char reversedChar = ' ';

        if (Character.isUpperCase(alphabet)) {
            reversedChar = reversedUpperAlphabet.charAt(alphabet - 65);
        } else if (Character.isLowerCase(alphabet)) {
            reversedChar = reversedLowerAlphabet.charAt(alphabet - 97);
        }
        return reversedChar;
    }
}
