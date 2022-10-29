package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int count369(int number) {
        int count = 0;
        while (number != 0) {
            int digit = number % 10;
            //각 자리수가 3,6,9(3의 배수)인지 확인해서 카운트
            if (digit % 3 == 0 && digit != 0) {
                count++;
            }
            number /= 10;
        }
        return count;
    }
}
