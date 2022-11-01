package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    cryptogram = cryptogram.substring(0, i).concat(cryptogram.substring(i + 2));
                    i -= 1;
                    flag = true;
                }
            }
        }
        answer = cryptogram;
        return answer;
    }
}
