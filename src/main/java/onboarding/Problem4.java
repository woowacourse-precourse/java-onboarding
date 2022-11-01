package onboarding;

public class Problem4 {
    private static final int MIN = 1;
    private static final int MAX = 1000;

    public static Character changeAlphabet(Character alpha) {
        if (alpha >= 'A' && alpha <= 'Z') return (char) ('A' + 'Z' - alpha);
        if (alpha >= 'a' && alpha <= 'z') return (char) ('a' + 'z' - alpha);
        return (char) (alpha);
    }

    public static boolean canWord(String word) {
        if (word.length() >= 1 && word.length() <= 1000) return true;
        return false;
    }
}
