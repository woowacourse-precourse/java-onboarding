package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }

    public static int countClap(int i) {
        int sum = 0;
        while (i > 0) { // 자릿수별로 3,6,9 가 나온 경우 더하기 위한 반복문
            if (is369(i)) {
                sum++;
            }
            i /= 10;
        }
        return sum;
    }

    private static boolean is369(int i) {
        return (i % 10 == 3) || (i % 10 == 6) || (i % 10 == 9);
    }
}
