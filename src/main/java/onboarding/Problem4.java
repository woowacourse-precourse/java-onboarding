package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                c = (char) ('A' + (26 - (c - 'A') - 1));
                stringBuilder.append(c);
            } else if (Character.isLowerCase(c)) {
                c = (char) ('a' + (26 - (c - 'a') - 1));
                stringBuilder.append(c);
            } else if (Character.isSpaceChar(c))
                stringBuilder.append(c);
        }

        answer = stringBuilder.toString();

        return answer;
    }
}
