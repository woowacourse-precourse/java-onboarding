package onboarding;

public class Problem4 {
    // main method for testing purposes
    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }

    public static String solution(String word) {

        int ASCII_UPPER_CASE_SUM = 155;
        int ASCII_LOWER_CASE_SUM = 219;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int ascii = word.charAt(i);

            if (Character.isUpperCase(word.charAt(i))) {
                answer.append(Character.toString((char) ASCII_UPPER_CASE_SUM - ascii));
            } else if (Character.isLowerCase(word.charAt(i))) {
                answer.append(Character.toString((char) ASCII_LOWER_CASE_SUM - ascii));
            } else {
                answer.append(word.charAt(i));
            }

        }
        return answer.toString();
    }
}
