package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if(cryptogram.isEmpty()){
            return cryptogram;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cryptogram.charAt(0));
        boolean isDuplicated = false;

        for (int i = 1; i < cryptogram.length(); i++) {
            char now = cryptogram.charAt(i);
            char prev = cryptogram.charAt(i - 1);
            if (now == prev) {
                sb.deleteCharAt(sb.length()-1);
                isDuplicated = true;
                continue;
            }
            sb.append(now);
        }
        if(!isDuplicated){
            return cryptogram;
        }
        return solution(sb.toString());
    }
}
