package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += judge(i); // judge를 통하여 짝 몇번 할 지 계산
        }
        return answer;
    }

    public static int judge(int i) {
        int sum = 0;
        while (i > 0) { // 자릿수별로 3,6,9 가 나온 경우 더하기 위한 반복문
            if ((i % 10 == 3) || (i % 10 == 6) || (i % 10 == 9)) {
                sum++;
            }
            i /= 10;
        }
        return sum;
    }
}
