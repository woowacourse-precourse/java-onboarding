package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String cryptoAvail = cryptogram;
        boolean flag = true;

        while (flag) {
            for (int start = 0; start < cryptoAvail.length() - 1; start++) {
                int end = 0;
                for (int i = start; i < cryptoAvail.length() - 1; i++) {
                    if (cryptoAvail.charAt(i) == ' ') break;
                    if (cryptoAvail.charAt(i) != cryptoAvail.charAt(i + 1)) break;
                    if (cryptoAvail.charAt(i) == cryptoAvail.charAt(i + 1)) end = i + 1;
                }

                if (end > 0) {
                    for (int i = start; i <= end; i++) {
                        char[] temp = cryptoAvail.toCharArray();
                        temp[i] = ' ';
                        cryptoAvail = String.valueOf(temp);
                    }
                }
            }

            cryptoAvail = cryptoAvail.replaceAll(" ", "");

            for (int i = 0; i < cryptoAvail.length()-1; i++) {
                flag = false;
                if (cryptoAvail.charAt(i) == cryptoAvail.charAt(i+1)) {
                    flag = true;
                    break;
                }
            }

            if (cryptoAvail.isEmpty()) flag = false;
        }

        answer = cryptoAvail;
        return answer;
    }
}
