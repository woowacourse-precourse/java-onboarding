package onboarding;
public class Problem3 {
    public static int solution(int number) {
        if(!(0 < number && number < 10001)) return 0;
        if(number < 3) return 0;

        int answer = 0;
        for (int i = 3; i <= number; i++) {
            answer += getClapCount(i);
        }
        return answer;
    }

    private static int getClapCount(int target) {
        String strNum = Integer.toString(target);
        int originCount = strNum.length();
        return originCount - strNum.replaceAll("[369]", "").length();
    }
}