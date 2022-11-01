package onboarding;

public class Problem4 {
    static char[] reverseLowerCase = new char[26];
    static char[] reverseUpperCase = new char[26];

    public static String solution(String word) {
        String answer = reverseWord(word);
        return answer;
    }

    public static String reverseWord(String word) {
        createReversAlphabet();
        StringBuilder wordSB = new StringBuilder(word);

        for (int i = 0; i < wordSB.length(); i++) {
            char alphabet = wordSB.charAt(i);

            if (alphabet >= 'A' && alphabet <= 'Z') {
                int index = alphabet - 'A';
                wordSB.setCharAt(i, reverseUpperCase[index]);
            }
            if (alphabet >= 'a' && alphabet <= 'z') {
                int index = alphabet - 'a';
                wordSB.setCharAt(i, reverseLowerCase[index]);
            }
        }
        return wordSB.toString();
    }

    public static void createReversAlphabet() {
        int alphabetLength = 26;
        for (int i = 0; i < alphabetLength; i++) {
            reverseUpperCase[i] = (char) (90 - i);
            reverseLowerCase[i] = (char) (122 - i);
        }
    }
}
