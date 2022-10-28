package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            while(i != 0) {
                if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9)
                    answer++;
                i /= 10;
            }
        }
        return answer;
    }
    /**
     * 3 6 9 게임 이다.
     * number를 받고 각 자리수에 3 6 9가 들어가면 카운트
     * 해당 개수만큼 카운트를 해야함
     * 3 -> 1개
     * 336 -> 3개
     * 즉, 각 자리를 검사해야 한다.
     * 1부터 해당 값까지 증가하면서 차례대로 검사를 해야 한다.
     * %10으로 나눠주면 제일 마지막 자리숫자가 나오게 된다.
     * 그리고 해당 값을 제외시키기 위해 10으로 나누어 주면
     */
}
