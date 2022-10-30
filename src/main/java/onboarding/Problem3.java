package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += getClapCount(i);
        }
        return answer;
    }

    public static int getClapCount(int number) {
        String stringNumber = String.valueOf(number);

        int cnt = 0;
        for (int i = 0; i < stringNumber.length(); i++) {
            char num = stringNumber.charAt(i);

            if (num == '3' || num == '6' || num == '9') {
                cnt++;
            }
        }

        return cnt;
    }
}
