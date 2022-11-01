package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if(cryptogram.isEmpty()){
            return cryptogram;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cryptogram.charAt(0));

        return solution(sb.toString());
    }
}
