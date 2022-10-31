package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        while(true) {
            int flag = 0;
            int len = cryptogram.length();
            for (int i=1; i<len; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i-1)){
                    cryptogram = cryptogram.replaceAll(cryptogram.substring(i-1,i+1), "");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                continue;
            } else {
                answer = cryptogram;
                break;
            }
        }
        return answer;
    }
}


