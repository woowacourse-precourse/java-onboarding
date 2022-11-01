package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getSum(number);
    }

    // 입력받은 숫자에 3의 배수가 몇 개인지 반환하는 함수
    public static int getCount(int number) {
        int count = 0;
        while (number > 10) {
            int digit = number % 10;
            number/=10;
            if (digit == 0) continue;
            if (digit % 3 == 0) count++;
        }

        if (number % 3 == 0) count++;
        return count;
    }

    public static int getSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += getCount(number);
            number--;
        }
        return sum;
    }
}

