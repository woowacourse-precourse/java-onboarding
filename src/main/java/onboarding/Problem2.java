package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int check = 0;
        StringBuilder answer = new StringBuilder();

        while (true) {
            for (int i = 0; i < cryptogram.length(); i++) {
                if (i == cryptogram.length() - 1) {
                    answer.append(cryptogram.charAt(i));
                    break;
                }
                if (cryptogram.charAt(i) != cryptogram.charAt(i + 1)) {
                    answer.append(cryptogram.charAt(i));
                } else {
                    check++;
                    i++;
                }
            }
            if(check != 0) {
                check = 0;
                System.out.println(answer);
                cryptogram = answer.toString();
                answer.setLength(0);
            } else break;
        }
        return answer.toString();
    }
}
