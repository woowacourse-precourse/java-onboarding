package onboarding;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder result = new StringBuilder();
        char[] wordCh = word.toCharArray();

        for (int i = 0; i < wordCh.length; i++) {
            if(!Character.isAlphabetic(wordCh[i])) {
                result.append(wordCh[i]);
            } else if (Character.isUpperCase(wordCh[i])) {
                result.append((char)('Z' - wordCh[i] + 'A'));
            } else {
                result.append((char)('z' - wordCh[i] + 'a'));
            }
        }
        return result.toString();
    }
}
