package onboarding;

/*
*  기능구현 사항
* 1. 1부터 number까지 반복문을 도는 기능
* 2. 해당 숫자가 3, 6, 9를 포함한다면 값을 더해주는 기능
* */
public class Problem3 {
    public static int solution(int number) {
        return sumCounts(number);
    }

    static int sumCounts(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            cnt += getContain369(i);
        }
        return cnt;
    }

    static int getContain369(int number) {
        int cnt = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit == 3 || digit == 6 || digit == 9) cnt++;
            number /= 10;
        }
        return cnt;
    }
}
