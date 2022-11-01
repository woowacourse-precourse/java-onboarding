package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String Str = cryptogram;

        int idx1 = 0;
        int idx2;

        for (idx2 = 1; idx2 < Str.length(); idx2++) {
            if(Str.charAt(idx1) == Str.charAt(idx2)) {
                Str = Str.substring(0,idx1) + Str.substring(idx2+1);
                idx1 = 0;
                idx2 = 1;
                continue;
            }
            idx1++;
            idx2++;
        }
        return Str;
    }
}
