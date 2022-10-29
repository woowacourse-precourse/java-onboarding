package onboarding;

public class Problem4 {
    private static final int A = 'A';
    private static final int Z = 'Z';
    private static final int a = 'a';
    private static final int z = 'z';

    public static String solution(String word) {
        String answer = "";
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            chs[i] = reversed(chs[i]);
        }
        answer = new String(chs);
        return answer;
    }

    private static char reversed(int ch) {
        if (ch >= A && ch <= Z)
            return (char) (A + Z - ch);
        if (ch >= a && ch <= z)
            return (char) (a + z - ch);
        return (char) ch;
    }
}
