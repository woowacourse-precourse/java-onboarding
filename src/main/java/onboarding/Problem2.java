package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer;

        int leftIndex = 0;
        int rightIndex = 1;

        while (rightIndex < cryptogram.length()) {
            if (cryptogram.charAt(leftIndex) == cryptogram.charAt(rightIndex)) {
                cryptogram = cryptogram.substring(0, leftIndex) + cryptogram.substring(rightIndex + 1);
                leftIndex = 0;
                rightIndex = 1;
            } else {
                leftIndex++;
                rightIndex++;
            }
        }
        answer = cryptogram;
        return answer;
    }
}
