package onboarding;

public class Problem3 {

    // 숫자를 입력 받으면 손뼉을 치는 횟수 반환하는 메소드
    public static int countClap(int number) {
        int result = 0;

        while (number != 0) {
            // 3 6 9 라면 -> 카운트 증가
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                result++;
            }
            number /= 10;
        }

        return result;
    }

    public static int solution(int number) {
        int answer = 0;

        // 숫자를 입력 받으면 손뼉을 치는 횟수 반환하는 메소드

        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }

        return answer;
    }
}
