package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += getClapCount(i);
        }
        return answer;
    }


    private static int getClapCount(int number) {
        int clapCount = 0;
        String num = String.valueOf(number);
        for (int i = 0; i < num.length(); i++) {
            char value = num.charAt(i);
            if (value == '3' || value == '6' || value == '9') {
                clapCount++;
            }
        }
        return clapCount;
    }
}
