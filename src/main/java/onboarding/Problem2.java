package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        for(int i=0; i<cryptogram.length()-1; i++) {
            if(cryptogram.indexOf(cryptogram.charAt(i)) == i)
                answer += cryptogram.charAt(i);
        }
        return answer;
    }

}