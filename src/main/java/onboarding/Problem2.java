package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while(cryptogram.length() > 0) {
            boolean done = true;
            for (int i = 0; i < cryptogram.length()-1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                    if(i+2 < cryptogram.length())
                        answer = cryptogram.substring(0,i) + cryptogram.substring(i+2);
                    else
                        answer =  cryptogram.substring(0,i);
                    done = false;
                    i += 1;
                    break;
                }
            }
            if(done)break;
            cryptogram = answer;
        }

        return answer;
    }
}
