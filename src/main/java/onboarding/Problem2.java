package onboarding;

public class Problem2 {

    public boolean validation(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return false;
        }
        else if (!cryptogram.equals(cryptogram.toLowerCase())){
            return false;
        }else {
            return true;
        }
    }

    public static String solution(String cryptogram) {
        String answer = "answer";


        return answer;
    }
}
