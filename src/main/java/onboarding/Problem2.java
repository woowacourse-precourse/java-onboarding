package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    private static boolean exception(String cryptogram) {
        if(cryptogram.length() < 1 || cryptogram.length() > 1000){
            return false;
        }
        for (int i = 0; i < cryptogram.length(); i++) {
            if (Character.isUpperCase(cryptogram.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
