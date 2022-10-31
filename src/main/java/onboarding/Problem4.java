package onboarding;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        if (!len_limit(word)) {
            return "word는 길이가 1 이상 1,000 이하인 문자열이 아닙니다.";
        }
        for (char ch : word.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                answer.append(char_change(ch));
            } else {
                answer.append(ch);
            }
        }
        return answer.toString();
    }


    public static boolean len_limit(String s) {
        if (s.length() >= 1 && s.length() <= 1000) {
            return true;
        }
        return false;
    }

    public static char char_change(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            int num = 155 - ch;
            return (char) num;
        }
        int num = 219 - ch;
        return (char) num;

    }

}
