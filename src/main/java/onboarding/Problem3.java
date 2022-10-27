package onboarding;

public class Problem3 {
    /**
     * 기능 목록
     * 1. 특정 숫자에 대해서 손뼉을 치는 수를 구하는 메소드 구현
     * 2. number까지 for문을 돌면서 answer에 추합
     * 3. 10으로 나눴을 때 0이되는 경우 제외
     */
    public static int solution(int number) {
        int answer = 0;
        for(int i = 3; i <= number; i++) {
            answer += count369(i);
        }
        return answer;
    }

    // 1. 손뼉친 횟수를 구하는 메소드
    public static int count369(int n) {
        int cnt = 0;
        while(n > 0) {
            // 3. 10으로 나눴을 때 0이되는 경우 제외
            if(n % 10 != 0) {
                if((n % 10) % 3 == 0) cnt++;
            }
            n = n / 10;
        }
        return cnt;
    }
}
