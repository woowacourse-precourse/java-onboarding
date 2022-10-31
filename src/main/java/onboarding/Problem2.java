package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (true) {

            boolean isOverlap = false;

            for (int i = 0; i < cryptogram.length() - 1; i++) {

                if (cryptogram.substring(i, i + 1).equals(cryptogram.substring(i + 1, i + 2))) {

                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
                    isOverlap = true;
                    break;
                }
            }

            if (!isOverlap) {
                break;
            }
        }

        answer = cryptogram;
        return answer;
    }
}
