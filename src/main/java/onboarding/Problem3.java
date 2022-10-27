package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int getThreeSixNineCnt(int number) {
        String tmp = Integer.toString(number);
        int ret = 0;

        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '3' || tmp.charAt(i) == '6' || tmp.charAt(i) == '9') ret++;
        }

        return ret;
    }
}
