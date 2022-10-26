package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        while (isRepeated(cryptogram)) {
            cryptogram = removeRepeat(cryptogram);
        }
        return cryptogram;
    }

    public static boolean isRepeated(String word) {

        for (int i = 0; i < word.length()-1; i++) {

            if (word.substring(i, i + 1).equals(word.substring(i + 1, i + 2))) {
                return true;
            }
        }
        return false;
    }

    public static String removeRepeat(String word) {
        String newWord = "";

        for (int i = 0; i < word.length()-1; i++) {

            if (word.substring(i, i + 1).equals(word.substring(i + 1, i + 2))) {
                newWord = word.substring(0, i);
                newWord += word.substring(i + 2);
                return newWord;
            }
        }
        return newWord;
    }
}
