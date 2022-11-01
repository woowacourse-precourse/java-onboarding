package onboarding;

public class Problem2 {
    //같은 문자 있는지 확인
    public static boolean check(String cryptogram) {
        int n = cryptogram.length();
        for (int i = 0; i < n-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

}

