package onboarding;

public class Problem3 {

    public static int solution(int number) {

        int answer = 0;
        return answer;
    }

    //한 숫자에 대해 손뼉을 치는 횟수 반환
    static int getClapCount(int number) {

        int cnt = 0;
        int n;

        while (number != 0) {
            n = number % 10;

            if (n == 3 || n == 6 || n == 9) {
                cnt += 1;
            }

            number = number / 10;
        }
        return cnt;
    }

}
