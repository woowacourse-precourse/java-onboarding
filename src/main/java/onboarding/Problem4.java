package onboarding;

public class Problem4 {
    public static String solution(String word) {
        int[] chars = getInts(word);
        return new String(chars, 0, chars.length);
    }

    private static int[] getInts(String word) {
        return word.chars().map(
                ch -> Character.isUpperCase(ch) ? 25 - ch + 'A' * 2 :
                        Character.isLowerCase(ch) ? 25 - ch + 'a' * 2 : ch).toArray();
    }
}
