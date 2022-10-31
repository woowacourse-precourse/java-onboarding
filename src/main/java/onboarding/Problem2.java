package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        if(checkException(cryptogram)){
            throw new IllegalArgumentException();
        }

        return answer;
    }
    public static boolean checkException(String cryptogram){
        if(checkLength(cryptogram.length())){
            return true;
        }

        return false;
    }
    public static boolean checkLength(int length){
        return length < 1 || length > 1000;
    }
}
