package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        boolean decrypting = true;
        while(decrypting && answer.length() > 1) {
            StringBuilder temp = new StringBuilder();
            decrypting = false;
            for(int idx = 0; idx < answer.length(); idx++) {
                if(idx + 1 == answer.length() || answer.charAt(idx) != answer.charAt(idx + 1)) {
                    temp.append(answer.charAt(idx));
                } else {
                    idx++;
                    decrypting = true;
                }
            }
            answer = temp.toString();
        }
        return answer;
    }
}
