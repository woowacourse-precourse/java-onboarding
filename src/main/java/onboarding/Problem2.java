package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while(true) {
            String temp = cryptogram.substring(0, 1);
            for(int i = 1; i < cryptogram.length(); i++) {
                temp += cryptogram.substring(i, i + 1);
            }
            cryptogram = temp;
            if()
        }
        return answer;
    }
}
