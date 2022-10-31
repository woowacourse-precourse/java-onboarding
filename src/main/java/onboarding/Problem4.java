package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char tmp;
        for (int i = 0; i < word.length(); i++) {
            tmp = word.charAt(i);
            if (tmp >= 'A' && tmp <= 'Z')
                answer += (char) ((int) 'A' + (int) 'Z' - (int) tmp);
            else if (tmp >= 'a' && tmp <= 'z')
                answer += (char) ((int) 'a' + (int) 'z' - (int) tmp);
            else
                answer += tmp;
        }
        return answer;
    }
}
