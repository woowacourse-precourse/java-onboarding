package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            String num = String.valueOf(i);
            for (int j = 0; j < num.length(); j++) {
                int n = num.charAt(j);
                if (isClapNumber(n))
                    cnt+=1;
            }
        }

        return cnt;
    }

    private static boolean isClapNumber(int n) {
        return n == '3' || n == '6' || n == '9';
    }
}
