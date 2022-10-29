package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int duplicate = 1;
        do {
            char[] answer = cryptogram.toCharArray();
            duplicate = 0;
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (answer[i] == answer[i + 1]) {
                    answer[i] = ' ';
                    answer[i + 1] = ' ';
                    duplicate = 1;
                }
            }
            cryptogram = new String(answer).replace(" ", "");
        }
        while (duplicate == 1);
        return String.valueOf(cryptogram);
    }
}
