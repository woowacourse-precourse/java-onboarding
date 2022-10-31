package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int x = 0;
        char[] ch = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (ch[i] > 64 && ch[i] < 91) {
                x = 155 - ch[i];
                ch[i] = (char) x;
            } else if (ch[i] > 96 && ch[i] < 123) {
                x = 219 - ch[i];
                ch[i] = (char) x;
            }
        }
        answer = String.valueOf(ch);
        return answer;
    }
}