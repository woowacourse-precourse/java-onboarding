package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer;
        /*
        * 1. 0~9까지 박수는 3번 친다.
        * 2. 10으로 나는 몫 * 3을 구한다.
        * 3. 10으로 나눈 나머지를 3으로 나누면 몇번 박수를 치는지 알 수 있다.
        * 4. 2번 + 3번을 한다.
         */
        int share = number / 10;
        int remainder = number % 10;

        answer = (share * 3) + (remainder / 3);

        return answer;
    }

}
