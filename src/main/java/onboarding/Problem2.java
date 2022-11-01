package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        while (cryptogram.length()>0) {
            answer = String.valueOf(cryptogram.charAt(0));
            for (int i = 1; i < cryptogram.length(); i++) {
                char c = cryptogram.charAt(i);
                if (answer.charAt(answer.length() - 1) != c) {
                    answer += c;
                }
                else {
                    answer = answer.substring(0,answer.length() - 1);
                }
            }
            if (answer.equals(cryptogram)) {
                break;
            }
            else {
                cryptogram = answer;
            }
        }

        return answer;
    }
}
