package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 3, 6, 9 개수
        int cnt = 0;

        // 1 ~ number 까지 확인
        for (int i = 1; i <= number; i++) {

            // 현재 보는 수
            int temp = i;

            // 0이 될때까지 반복
            while (temp != 0) {
                // 3, 6, 9가 존재하는 경우
                if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9){
                    cnt++;
                }
                temp /= 10;
            }
        }

        // 정답
        answer = cnt;
        return answer;
    }
}