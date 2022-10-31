package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        int cryp_idx = 0;
        int ans_idx = -1;
        while (cryp_idx < cryptogram.length()) {
            if (answer.equals("")) {
                answer += cryptogram.charAt(cryp_idx);
                ans_idx += 1;
            }
            else if (answer.charAt(ans_idx) == cryptogram.charAt(cryp_idx)) {
                answer = answer.substring(0, answer.length()-1);
                ans_idx -= 1;
            }
            else {
                answer += cryptogram.charAt(cryp_idx);
                ans_idx += 1;
            }
            cryp_idx += 1;
        }

        return answer;
    }


}
