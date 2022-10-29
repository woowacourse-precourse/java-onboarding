package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;

        // cheek for end
        int check = Integer.MAX_VALUE;
        // check for do remove
        boolean check_rmv;

        // check == 0 -> not have duplicate character
        while(check > 0){
            check = 0;
            for(int i = 0; i < cryptogram.length() - 1; i++) {
                // check for do remove cryptogram[i]
                check_rmv = false;
                for (int j = i+1; j < cryptogram.length(); j++) {
                    // if cryptogram[i] == cryptogram[j] remove j
                    if (cryptogram.charAt(i) == cryptogram.charAt(j)) {
                        cryptogram = cryptogram.substring(0, j) + cryptogram.substring(j + 1);
                        check += 1;
                        check_rmv = true;
                    } else break;

                }
                if(check_rmv) cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 1);
            }
        }
        answer = cryptogram;
        return answer;
    }
}
