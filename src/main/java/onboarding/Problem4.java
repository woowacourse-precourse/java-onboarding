package onboarding;

public class Problem4 {

    static char[] lowerCase = new char[26];
    static char[] reverseLowerCase = new char[26];
    static char[] upperCase = new char[26];
    static char[] reverseUpperCase = new char[26];

    public static String solution(String word) {
        String answer = reverseWord(word);
        return answer;
    }

    public static String reverseWord(String word) {
        createArray();
        StringBuilder wordToSb = new StringBuilder(word);

        for (int i = 0; i < wordToSb.length(); i++) {
            char alphabet = wordToSb.charAt(i);
            
            if (alphabet >= 'A' && alphabet <= 'Z') {
                int index = alphabet - 'A';
                wordToSb.setCharAt(i, reverseUpperCase[index]);
            }
            if (alphabet >= 'a' && alphabet <= 'z') {
                int index = alphabet - 'a';
                wordToSb.setCharAt(i, reverseLowerCase[index]);
            }
        }
        return wordToSb.toString();
    }

    public static void createArray() {
        for (int i = 0; i < upperCase.length; i++) {
            upperCase[i] = (char) (65 + i);
        }
        for (int i = 0; i < lowerCase.length; i++) {
            lowerCase[i] = (char) (97 + i);
        }
        for (int i = 0; i < reverseUpperCase.length; i++) {
            reverseUpperCase[i] = (char) (90 - i);
        }
        for (int i = 0; i < reverseLowerCase.length; i++) {
            reverseLowerCase[i] = (char) (122 - i);
        }
    }
}
