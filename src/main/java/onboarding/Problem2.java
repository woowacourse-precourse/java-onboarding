package onboarding;

public class Problem2 {

    public static String decoding(String s) {
        char c = 0;
        boolean isRemoved = false;

        for(int i=0; i<s.length(); i++) {
            if(i != 0 && c == s.charAt(i)) {
                s = s.substring(0, i-1) + s.substring(i+1);
                isRemoved = true;
                break;
            }
            c = s.charAt(i);
        }

        if(isRemoved) {
            s = decoding(s);
        }

        return s;
    }
    public static String solution(String cryptogram) {
        String answer = "";

        answer = decoding(cryptogram);
        return answer;

    }
}
