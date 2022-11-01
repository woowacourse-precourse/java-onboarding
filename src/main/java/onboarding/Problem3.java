package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int i = 1;

        // 1부터 number 까지 반복하여 각 자릿수 별 3,6,9 확인
        while (i <= number) {
            // 십의 자리 3,6,9 확인
            if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
                answer++;
            }
            // 일의 자리 3,6,9 확인
            if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                answer++;
            }
            i++;
        }

        return answer;
    }
}
