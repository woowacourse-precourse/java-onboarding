package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for (int num = 1; num <= number; num++) {
            answer += threeSixNineCount(num);
        }
        return answer;
    }

    public static int threeSixNineCount(int number) {
        int count = 0;
        int nowDigit;
        while (number > 0) {
            nowDigit = number % 10;
            if (nowDigit == 3 || nowDigit == 6 || nowDigit == 9) {
                count++;
            }
            number /= 10;
        }
        return count;
    }
}
