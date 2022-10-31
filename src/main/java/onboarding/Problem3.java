package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return countClap(number);
    }

    // 3, 6, 9의 개수만큼 손뼉친 횟수 리턴
    public static int countClap(int number) {
        int answer = 0;
        int nowNumber;
        for (int i = 1; i <= number; i++) {
            nowNumber = i;
            while (nowNumber != 0) {
                if (nowNumber % 10 == 3 || nowNumber % 10 == 6 || nowNumber % 10 == 9) {
                    answer++;
                }
                nowNumber /= 10;
            }
        }
        return answer;
    }
}