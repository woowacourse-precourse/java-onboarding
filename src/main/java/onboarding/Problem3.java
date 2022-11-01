package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int n = 1; n <= number; n++) {
            answer += getClapCount(n);
        }

        return answer;
    }

    public static int getClapCount(int number) {
        String numberToString = String.valueOf(number);
        int result = 0;
        for (int idx = 0; idx < numberToString.length(); idx++) {
            char charAtString = numberToString.charAt(idx);
            if (charAtString == '3' || charAtString == '6' || charAtString == '9')
                result++;
        }
        return result;
    }
}
