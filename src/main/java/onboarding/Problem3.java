package onboarding;

public class Problem3 {

    // TODO 입력받은 수의 3,6,9 개수를 반환하는 메서드
    public static int getCountNum(int num) {
        int cnt = 0;

        while (num > 0) {
            if (num%10 == 3 || num%10 == 6 || num%10 == 9) cnt++;
            num /= 10;
        }

        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i<=number; i++) {
            int num = getCountNum(i);
            answer += num;
        }

        return answer;
    }
}