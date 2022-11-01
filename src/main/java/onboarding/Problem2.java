package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (true) {

            boolean isOverlap = false;

            for (int i = 0; i < cryptogram.length() - 1; i++) {

                if (cryptogram.substring(i, i + 1).equals(cryptogram.substring(i + 1, i + 2))) {

                    String substring = cryptogram.substring(i, i + 1);
                    int j = i + 1;

                    while (j < cryptogram.length() - 1) {

                        if (cryptogram.substring(j + 1, j + 2).equals(substring)) {
                            j++;
                        } else {
                            break;
                        }
                    }

                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(j + 1);
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
