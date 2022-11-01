package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 3; i <= number; i++) {
            answer += get369Count(i);
        }
        return answer;
    }

    /**
     * 숫자에서 3, 6, 9의 개수 구하기
     * @param num 숫자
     * @return 3, 6, 9의 개수를 반환한다.
     */
    private static int get369Count(int num) {
        int count = 0;
        int rest;
        while (num > 0) {
            rest = num % 10;
            if (rest == 3 || rest == 6 || rest == 9) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}
