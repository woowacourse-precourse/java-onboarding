package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String value = cryptogram;

        for(int i = 1; i < value.length(); i++){
            if(value.charAt(i-1) == value.charAt(i)) {
                value = value.substring(0, i-1) + value.substring(i+1);
                i = 0;
            }
        }

        return value;
    }
}
