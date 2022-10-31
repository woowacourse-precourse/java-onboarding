package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] str = word.toCharArray();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                int tmp = (int) str[i];
                str[i] = (char) (tmp + 25 - 2 * (tmp - 'a'));
            }
            else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                int tmp = (int) str[i];
                str[i] = (char) (tmp + 25 - 2 * (tmp - 'A'));
            }
        }

        answer = new String(str);
        return answer;
    }
}
