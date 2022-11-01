package onboarding;

public class Problem4 {
    private static final int MIN = 1;
    private static final int MAX = 1000;

    public static String solution(String word) {
        if (!canWord(word)) throw new IllegalArgumentException("제한 사항을 위반하였습니다.");
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer += changeAlphabet(word.charAt(i));
        }
        return answer;
    }

    public static Character changeAlphabet(Character alpha) {
        if (alpha >= 'A' && alpha <= 'Z') return (char) ('A' + 'Z' - alpha);
        if (alpha >= 'a' && alpha <= 'z') return (char) ('a' + 'z' - alpha);
        return (char) (alpha);
    }

    public static boolean canWord(String word) {
        if (word.length() >= MIN && word.length() <= MAX) return true;
        return false;
    }
}
