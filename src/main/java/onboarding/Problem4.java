package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        char curr, change;
        int n;
        for (int i = 0; i < word.length(); i++) {
            curr = word.charAt(i);
            if (curr == ' ') {
                // 띄어쓰기 일 때
                sb.append(curr);
            } else if (curr >= 'a') {
                // 소문자일 때
                n = curr - 'a';
                change = (char) ('z' - n);
                sb.append(change);
            } else {
                // 소문자도 띄어쓰기도 아닐 떄
                n = curr - 'A';
                change = (char) ('Z' - n);
                sb.append(change);
            }
        }

        answer = sb.toString();
        return answer;
    }
}
