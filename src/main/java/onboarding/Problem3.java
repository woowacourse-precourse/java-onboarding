package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // number까지 순서대로 박수 치는 횟수 구하기
        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }

    // 숫자에 3, 6, 9가 몇 번 포함되는지 반환
    static int countClap(int number) {
        int count = 0;

        while (number > 0) {
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                count++;
            }
            number /= 10;
        }

        return count;
    }
}
