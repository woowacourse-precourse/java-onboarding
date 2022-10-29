package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int check = 1;
        while (check != 0) {
            check = 0;
            int count = 0;
            String str = "";
            for (int i = 1; i < cryptogram.length(); i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                    count++;
                    check++;
                } else if (count != 0 && cryptogram.charAt(i) != cryptogram.charAt(i - 1)) {
                    count = 0;
                    if (i + 1 == cryptogram.length()) {
                        str += cryptogram.charAt(i);
                    }
                } else {
                    str += cryptogram.charAt(i - 1);
                    if (i + 1 == cryptogram.length()) {
                        str += cryptogram.charAt(i);
                    }
                }
            }
            cryptogram = str;
        }
        answer = cryptogram;
        return answer;
    }
}
