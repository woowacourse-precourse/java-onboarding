package onboarding;

/**
 *  구현할 기능 목록
 *      1. 1부터 현재 값까지 3,6,9 개수만큼 손벽 치는 기능
 *          1.1 1부터 현재 값까지 증가하는 기능
 *          1.2 증가된 수에서 3,6,9가 들어있으면 3,6,9개수만큼 카운트 증가하는 기능
 *
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        //1부터 현재 값까지 증가
        for (int i = 1; i <= number; i++) {
            answer += is369(i);
        }

        return answer;
    }


    //3,6,9가 들어있으면 3,6,9개수만큼 카운트 증가
    private static int is369(int number) {
        int count=0;
        while (number > 0) {
            int check = number % 10;
            number /= 10;
            if (check == 3 || check == 6 || check == 9) {
                count++;
            }
        }
        return count;
    }

}
