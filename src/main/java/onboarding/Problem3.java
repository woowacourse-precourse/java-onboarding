package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;

        for(int i = 3; i < number + 1; i++) { // 3 ~ 입력받은 숫자만큼 for문 반복
            int num = i;

            while (num > 0) {
                // 각 자릿수마다 3, 6, 9가 있으면 count 증가
                if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                    answer++;
                }
                num /= 10; // 자릿수를 줄여준다.
            }
        }

        return answer;
    }
}