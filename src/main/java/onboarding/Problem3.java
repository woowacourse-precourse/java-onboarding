package onboarding;

// <기능 목록>
// 1. 손뼉 횟수 구하기

public class Problem3 {
    public static int solution(int number) {
        int answer = clapHand(number);
        return answer;
    }

    // 1. 손뼉 횟수 구하기
    // number가 큰 수가 아니기 때문에 이중반복문 사용
    public static int clapHand(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            int n = i;
            while (n > 0) {
                if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) {
                    sum++;
                }
                n /= 10;
            }
        }
        return sum;
    }
}
