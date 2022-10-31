package onboarding;

public class Problem2 {

    public static String scanDuplicate(String cryptogram) {
        String answer = cryptogram;
        for(int i=0; i<cryptogram.length()-1; i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                answer = cryptogram.substring(0, i) + cryptogram.substring(i+2);
                break;
            }
        }
        return answer;
    }
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while(!scanDuplicate(answer).equals(answer)) {
            answer = scanDuplicate(answer);
        }
        return answer;
    }
}
