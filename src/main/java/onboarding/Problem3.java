package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int now_num = 0;

        // 1부터 number까지 손뼉을 몇 번 치는지
        for(int i = 1; i <= number; i++) {
            now_num = i;

            // 현재 숫자가 i일때 손뼉을 몇 번 치는지 answer에 더해주기
            while(now_num > 0) {
                // 0이 아니면서 3의 배수(3, 6, 9)일때 손뼉 치기
                if(((now_num % 10) != 0) && (((now_num % 10) % 3) == 0)) {
                    answer++;
                }
                now_num /= 10;
            }
        }

        return answer;
    }
}
