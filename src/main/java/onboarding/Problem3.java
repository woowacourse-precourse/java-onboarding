package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getTotalClapCnt(number);
    }

    private static int getThreeSixNineCnt(int number) {
        String tmp = Integer.toString(number);
        int ret = 0;

        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '3' || tmp.charAt(i) == '6' || tmp.charAt(i) == '9') ret++;
        }

        return ret;
    }

    private static int getTotalClapCnt(int number) {
        int ret = 0;

        for (int i = 1; i <= number; i++) {
            ret += getThreeSixNineCnt(i);
        }

        return ret;
    }
}
