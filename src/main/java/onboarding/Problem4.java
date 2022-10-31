package onboarding;

public class Problem4 {

    public static int[] change = new int[26];

    public static void init() {
        int i = 0;
        for (int j = 25; j >= 0; j--) {
            change[i] = j;
            i++;
        }
    }

    public static String solution(String word) {
        init();
            char[] chars = word.toCharArray();
            String answer = "";
            for (char c : chars) {
                if (c == ' ') answer += ' ';
                else if (c >= 'a' && c <= 'z') answer += (char)(change[c - 'a'] + 'a');
                else if (c >= 'A' && c <= 'Z') answer += (char)(change[c - 'A'] + 'A');
        }
        return answer;
    }
}
