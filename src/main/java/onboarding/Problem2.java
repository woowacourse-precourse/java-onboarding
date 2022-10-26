package onboarding;

public class Problem2 {

    static int checkPossible(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) return i;
        }
        return -1;
    }


    public static String solution(String cryptogram) {
        int res = checkPossible(cryptogram);
        if(res == -1) return cryptogram;
        int end = res;
        for(; end< cryptogram.length(); end++){
            if(cryptogram.charAt(res) == cryptogram.charAt(end)) continue;
            break;
        }
        cryptogram = cryptogram.substring(0, res) + cryptogram.substring(end);
        return solution(cryptogram);
    }
}
