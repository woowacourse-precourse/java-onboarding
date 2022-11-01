package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if (temp >= 65 && temp <= 90) {
                sb.append((char) ('A' + 'Z' - temp));
            } else if (temp >= 97 && temp <= 122) {
                sb.append((char) ('a' + 'z' - temp));
            } else {
                sb.append(temp);
            }
            answer = String.valueOf(sb);
        }
        return answer;
    }

}
