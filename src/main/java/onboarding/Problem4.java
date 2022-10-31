package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
//z+a-c
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c))
                answer.append((char) ('Z' + 'A' - c));
            else if (Character.isLowerCase(c))
                answer.append((char) ('z' + 'a' - c));
            else
                answer.append(c);
        }
        return answer.toString();
    }
}
