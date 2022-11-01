package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        int start = -1;
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                start = i;
                break;
            }
        }
        if (start != -1) {
            String doubleWord = cryptogram.substring(start, start + 2);
            String newWord = cryptogram.replace(doubleWord, "");
            return solution(newWord);
        }
        return answer;
    }
}
