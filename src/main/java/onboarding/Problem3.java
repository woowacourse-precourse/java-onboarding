package onboarding;

/*
* 기능 목록
* 1. 특정 숫자의 369 개수 구하기
* 2. 1부터 해당 숫자까지 369개수 구하기
* */
public class Problem3 {

    // 특정 숫자의 369 개수 구하기
    public static int get369Count(int number) {
        int cnt = 0;
        while (number > 0) {
            int num = number % 10;
            if (num == 3 || num == 6 || num == 9) {
                cnt++;
            }
            number /= 10;
        }
        return cnt;
    }

    // 1부터 해당 숫자까지 369개수 구하기
    public static int getAnswer(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += get369Count(i);
        }
        return answer;
    }

    public static int solution(int number) {
        return getAnswer(number);
    }
}
