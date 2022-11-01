package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        return answer;
    }

    /**
     * 주어진 숫자의 3, 6, 9 개수 반환하는 메소드
     */
    private static int numOfClaps(int number) {
        int count = 0;
        while (number > 0) {
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                ++count;
            }
            number /= 10;
        }
        return count;
    }
}
