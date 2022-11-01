package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int check = 0;
        StringBuilder answer = new StringBuilder();

        while (true) {
            for (int index = 0; index < cryptogram.length(); index++) {
                if (index == cryptogram.length() - 1) {
                    answer.append(cryptogram.charAt(index));
                    break;
                }
                if (cryptogram.charAt(index) != cryptogram.charAt(index + 1)) {
                    answer.append(cryptogram.charAt(index));
                } else {
                    check++;
                    index++;
                }
            }
            if(check != 0) {
                check = 0;
                cryptogram = answer.toString();
                answer.setLength(0);
            } else break;
        }
        return answer.toString();
    }
}
