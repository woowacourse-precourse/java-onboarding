package onboarding;

public class Problem3 {
    private static final int MIN = 1;
    private static final int MAX = 10000;

    public static int count369(String num) {
        int cnt = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9') {
                cnt++;
            }
        }
        return cnt;
    }

}
