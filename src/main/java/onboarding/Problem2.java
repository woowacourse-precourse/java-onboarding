package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        boolean check = true;

        while(check) {
            check = false;
            for(int i = 0; i < cryptogram.length() - 1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    if(i == cryptogram.length() - 2)
                        cryptogram = cryptogram.substring(0, i);
                    else
                        cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2, cryptogram.length());
                    check = true;
                }
            }
        }

        answer = cryptogram;

        return answer;
    }
}
