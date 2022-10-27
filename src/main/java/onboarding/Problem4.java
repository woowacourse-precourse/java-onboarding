package onboarding;

public class Problem4 {

    private static final int UPPER_REVERSE_VALUE = 155;
    private static final int LOWER_REVERSE_VALUE = 219;

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder(word);

        for (int i = 0; i < answer.length(); i++) {
            char target = answer.charAt(i);
            if (target >= 'A' && target <= 'Z') answer.setCharAt(i, (char) (UPPER_REVERSE_VALUE - target));
            else if (target >= 'a' && target <= 'z') answer.setCharAt(i, (char) (LOWER_REVERSE_VALUE - target));
        }

        return answer.toString();
    }

}
