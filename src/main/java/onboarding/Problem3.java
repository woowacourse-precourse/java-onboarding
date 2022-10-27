package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += hasThreeTimes(i);
        }
        return answer;
    }

    public static int hasThreeTimes(int number) {
        String str = String.valueOf(number);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) % 3 == 0 && str.charAt(i) != '0') count++;
        }
        return count;
    }
}
