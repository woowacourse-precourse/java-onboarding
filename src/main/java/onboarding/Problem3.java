package onboarding;


public class Problem3 {
    /**
     * 기능 요구 사항
     * 1. 숫자 3, 6, 9가 들어가는지 확인
     * 2. 들어가면 손뼉 ( answer 값에 + 1)
     */
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number + 1; i++) {
            answer += String.valueOf(i)
                    .chars().filter(ch -> ch == '3' || ch == '6' || ch == '9')
                    .count();
        }

        return answer;
    }
}
