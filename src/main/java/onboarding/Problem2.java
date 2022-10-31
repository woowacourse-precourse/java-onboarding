package onboarding;

public class Problem2 {
    public static String compression(String zipAnswer, int start) {
        String frontOfzipAnwer = zipAnswer.substring(0, start);
        String endOfzipAnswer = zipAnswer.substring(start + 2);

        zipAnswer = frontOfzipAnwer + endOfzipAnswer;
        return zipAnswer;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        String zipAnswer = cryptogram;
        char firstLetter;
        char secondLetter;

        for (int i = 0; i < zipAnswer.length() - 1; i++) {
            firstLetter = zipAnswer.charAt(i);
            secondLetter = zipAnswer.charAt(i + 1);

            if (firstLetter == secondLetter) {
                zipAnswer = compression(zipAnswer, i);
                i = -1;
            }
        }
        answer = zipAnswer;
        return answer;
    }
}