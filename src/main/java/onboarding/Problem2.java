package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (compareAdjacent(cryptogram)) {
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    String begin = cryptogram.substring(0, i);
                    String end = cryptogram.substring(i + 2);
                    cryptogram = begin + end;
                }
            }
        }
        answer = cryptogram;

        return answer;
    }

    public static boolean compareAdjacent(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}

