package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            // 대문자
            if (Character.isUpperCase(character)) {
                sb.append((char) ('Z' - character + 'A'));
            }
            // 소문자
            else if (Character.isLowerCase(character)) {
                sb.append((char) ('z' - character + 'a'));
            }
            // 그 외에는 그대로
            else {
                sb.append(character);
            }
        }

        answer = sb.toString();

        return answer;
    }
}
