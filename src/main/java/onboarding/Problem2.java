package onboarding;

public class Problem2 {
    static boolean state = true;

    public static String solution(String cryptogram) {
        String answer = "answer";

        while (state) {
            state = false;

            answer = getAnswerWithoutDuplicate(cryptogram);

            cryptogram = answer;
        }

        return answer;
    }

    private static String getAnswerWithoutDuplicate(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        boolean isDuplicate;

        for (int i = 0; i < cryptogram.length(); i++) {

            if (i == 0) {

            } else if (i == cryptogram.length() - 1) {

            } else {

            }
        }

        return answer.toString();
    }
}
