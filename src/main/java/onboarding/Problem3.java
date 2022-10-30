package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer;
        answer = countClap(number);
        return answer;
    }
    public static int countClap(int number) {
        int result = 0;
        for (int i = 1; i <= number + 1; i++) {
            String num = String.valueOf(i);
            if (num.contains("3")|num.contains("6")|num.contains("9")) {
                result++;
            }
        }
        return result;
    }
}
